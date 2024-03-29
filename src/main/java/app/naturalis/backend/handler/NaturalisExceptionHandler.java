package app.naturalis.backend.handler;

import app.naturalis.backend.handler.exception.ClienteIsInativoException;
import app.naturalis.backend.handler.exception.NewUserEqualsCpfException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class NaturalisExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String msgUser = messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale());
        String msgDev = ex.getCause() != null ? ex.getCause().toString() : ex.toString();
        List<Erro> erros = Arrays.asList(new Erro(msgUser, msgDev));
        return handleExceptionInternal(ex,erros, headers,HttpStatus.BAD_REQUEST,request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Erro> erros = listErrorsHandler(ex.getBindingResult());
        return handleExceptionInternal(ex, erros, headers,HttpStatus.BAD_REQUEST,request);
    }

    @ExceptionHandler({ EmptyResultDataAccessException.class })
    public ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex, WebRequest request){
        String msgUser = messageSource.getMessage("recurso.nao-encontrado", null, LocaleContextHolder.getLocale());
        String msgDev = ex.toString();
        List<Erro> erros = Arrays.asList(new Erro(msgUser, msgDev));
        return handleExceptionInternal(ex, erros, new HttpHeaders(),HttpStatus.NOT_FOUND,request);
    }

    @ExceptionHandler( { DataIntegrityViolationException.class} )
    public ResponseEntity<Object> handleDataIntegrityViolationException(DataIntegrityViolationException ex, WebRequest request){
        String msgUser = messageSource.getMessage("recurso.operacao-invalida", null, LocaleContextHolder.getLocale());
        String msgDev = ExceptionUtils.getRootCauseMessage(ex);
        List<Erro> erros = Arrays.asList(new Erro(msgUser, msgDev));
        return handleExceptionInternal(ex, erros, new HttpHeaders(),HttpStatus.BAD_REQUEST,request);
    }

    @ExceptionHandler( {NewUserEqualsCpfException.class} )
    public ResponseEntity<Object> handleNewUserEqualsCpfException(NewUserEqualsCpfException ex, HttpServletResponse response){
        String msgUser = messageSource.getMessage("user.cpf-existente", null, LocaleContextHolder.getLocale());
        String msgDev = ex.toString();
        List<NaturalisExceptionHandler.Erro> erros = Arrays.asList(new NaturalisExceptionHandler.Erro(msgUser, msgDev));
        return ResponseEntity.badRequest().body(erros);
    }

    @ExceptionHandler( {ClienteIsInativoException.class} )
    public ResponseEntity<Object> handleClienteIsInativoException(ClienteIsInativoException ex, HttpServletResponse response){
        String msgUser = messageSource.getMessage("cliente.inexistente-ou-inativo", null, LocaleContextHolder.getLocale());
        String msgDev = ex.toString();
        List<NaturalisExceptionHandler.Erro> erros = Arrays.asList(new NaturalisExceptionHandler.Erro(msgUser, msgDev));
        return ResponseEntity.badRequest().body(erros);
    }

    private List<Erro> listErrorsHandler(BindingResult bindingResult){
        List<Erro> erros = new ArrayList<>();
        for (FieldError fieldError : bindingResult.getFieldErrors()){
            String msgUser = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());
            String msgDev = fieldError.toString();
            erros.add(new Erro(msgUser, msgDev));
        }
        return erros;
    }

    public static class Erro {
        private String msgUser;
        private String msgDev;

        public Erro(String msgUser, String msgDev) {
            this.msgUser = msgUser;
            this.msgDev = msgDev;
        }

        public String getMsgUser() {
            return msgUser;
        }

        public String getMsgDev() {
            return msgDev;
        }
    }
}

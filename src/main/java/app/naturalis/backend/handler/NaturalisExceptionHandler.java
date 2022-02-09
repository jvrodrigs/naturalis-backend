package app.naturalis.backend.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class NaturalisExceptionHandler extends ResponseEntityExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        String msgUser = messageSource.getMessage("mensagem.invalida", null, LocaleContextHolder.getLocale());
        String msgDev = ex.getCause().toString();
        return handleExceptionInternal(ex, new Erro(msgUser, msgDev), headers,HttpStatus.BAD_REQUEST,request);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<Erro> erros = listErrorsHandler(ex.getBindingResult());
        return handleExceptionInternal(ex, erros, headers,HttpStatus.BAD_REQUEST,request);
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

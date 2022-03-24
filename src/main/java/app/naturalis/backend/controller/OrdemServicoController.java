package app.naturalis.backend.controller;

import app.naturalis.backend.dto.OrdemServicoPorDiaDto;
import app.naturalis.backend.dto.OrdemServicoPorPessoaDto;
import app.naturalis.backend.dto.OrdemServicoResDto;
import app.naturalis.backend.event.RecursoEvent;
import app.naturalis.backend.model.OrdemServico;
import app.naturalis.backend.repository.filter.OrdemServicoFilter;
import app.naturalis.backend.repository.OrdemServicoRepository;
import app.naturalis.backend.service.OrdemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrdemServicoController {

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @Autowired
    private OrdemService ordemService;

    @Autowired
    private ApplicationEventPublisher pubEvent;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<OrdemServicoResDto> getAllFilter(OrdemServicoFilter osFilter){
        return this.ordemServicoRepository.filtrar(osFilter)
                .stream()
                .map(this::toOrdemServicoResDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/get-day")
    public List<OrdemServicoPorDiaDto> getFilterMonth() {
        OrdemServicoFilter osFilterDate = new OrdemServicoFilter();
        LocalDate dateInLocal = LocalDate.now();
        Date dateConverter = Date.from(dateInLocal.atStartOfDay(ZoneId.systemDefault()).toInstant());
        osFilterDate.setDataCriacaoDe(dateConverter);
        return this.ordemServicoRepository.filtrarPorDia(osFilterDate)
                .stream()
                .map(this::ordemServicoPorMesDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/report")
    public ResponseEntity<byte[]> reportGetOrders(OrdemServicoFilter osFilter) throws Exception {
        var data = this.ordemServicoRepository.filtrar(osFilter)
                .stream()
                .map(this::toOrdemServicoResDto)
                .collect(Collectors.toList());
        byte[] rel = ordemService.reportOrders(data, osFilter);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        String filename = "relatorio-ordens-servico";
        headers.setContentDispositionFormData(filename, filename);
//        return new ResponseEntity<>(rel, headers, HttpStatus.OK);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE)
                .body(rel);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> orderGetById(@PathVariable("id") int id){
        Optional<OrdemServico> os = this.ordemService.getById(id);

        return os.isPresent() ? ResponseEntity.ok(os) : ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<OrdemServico> create(@Valid @RequestBody OrdemServico ordemServico, HttpServletResponse response){
        OrdemServico os = ordemService.newOs(ordemServico);
        pubEvent.publishEvent(new RecursoEvent(this, response, os.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(os);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<OrdemServico> editById(@PathVariable("id") int id, @Valid @RequestBody OrdemServico osRequest){
        var os = this.ordemService.editById(id, osRequest);
        return ResponseEntity.ok(os);
    }

    private OrdemServicoResDto toOrdemServicoResDto(OrdemServico os){
        return modelMapper.map(os, OrdemServicoResDto.class);
    }

    private OrdemServicoPorDiaDto ordemServicoPorMesDto(OrdemServico os){
        return modelMapper.map(os, OrdemServicoPorDiaDto.class);
    }

    private OrdemServicoPorPessoaDto ordemServicoPorPessoaDto(OrdemServico os){
        return modelMapper.map(os, OrdemServicoPorPessoaDto.class);
    }

}

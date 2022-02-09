package app.naturalis.backend.controller;

import app.naturalis.backend.event.RecursoEvent;
import app.naturalis.backend.model.Substancias;
import app.naturalis.backend.repository.SubstanciasRepository;
import app.naturalis.backend.service.SubstanciasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/substances")
public class SubstanciasController {

    @Autowired
    private SubstanciasService substanciasService;

    @Autowired
    private SubstanciasRepository substanciasRepository;

    @Autowired
    private ApplicationEventPublisher pubEvent;

    @GetMapping
    public List<Substancias> getAll(){
        return this.substanciasRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Substancias> create(@Valid @RequestBody Substancias substancias, HttpServletResponse response){
        Substancias subsCreate = this.substanciasService.newSubst(substancias);

        pubEvent.publishEvent(new RecursoEvent(this, response, subsCreate.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(subsCreate);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id){
        Optional<Substancias> substancias = this.substanciasService.getById(id);

        return substancias.isPresent() ? ResponseEntity.ok(substancias) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/del/{id}")
    public void removeSubsById(@PathVariable("id") int id){
        this.substanciasService.removeSubsById(id);
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Substancias> editById(@PathVariable("id") int id, @Valid @RequestBody Substancias substancias){
        var subs = this.substanciasService.editById(id, substancias);
        return ResponseEntity.ok(subs);
    }
}

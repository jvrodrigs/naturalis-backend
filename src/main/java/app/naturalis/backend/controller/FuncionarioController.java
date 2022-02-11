package app.naturalis.backend.controller;

import app.naturalis.backend.model.Funcionario;
import app.naturalis.backend.repository.FuncionarioRepository;
import app.naturalis.backend.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioService funcionarioService;


    @GetMapping
    public List<Funcionario> getAll(){
        return this.funcionarioRepository.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Funcionario> create(@Valid @RequestBody Funcionario funcionario){
        Funcionario funcSave = funcionarioService.newFunc(funcionario);

        return ResponseEntity.status(HttpStatus.CREATED).body(funcSave);
    }
}

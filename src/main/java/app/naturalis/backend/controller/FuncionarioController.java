package app.naturalis.backend.controller;

import app.naturalis.backend.dto.FuncionarioResDto;
import app.naturalis.backend.model.Funcionario;
import app.naturalis.backend.repository.FuncionarioRepository;
import app.naturalis.backend.service.FuncionarioService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioService funcionarioService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping
    public List<FuncionarioResDto> getAll(){
        return this.funcionarioRepository.findAll()
                .stream()
                .map(this::toFuncionarioResDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/create")
    public ResponseEntity<Funcionario> create(@Valid @RequestBody Funcionario funcionario){
        Funcionario funcSave = funcionarioService.newFunc(funcionario);

        return ResponseEntity.status(HttpStatus.CREATED).body(funcSave);
    }

    @DeleteMapping("/del/{id}")
    public void removeFuncById(@PathVariable("id") int id){
        this.funcionarioService.removeFuncById(id);
    }

    private FuncionarioResDto toFuncionarioResDto(Funcionario funcionario){
        return modelMapper.map(funcionario, FuncionarioResDto.class);
    }
}

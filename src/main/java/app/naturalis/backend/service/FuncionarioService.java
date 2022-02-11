package app.naturalis.backend.service;

import app.naturalis.backend.model.Funcionario;
import app.naturalis.backend.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public Funcionario newFunc(Funcionario funcionario){
        String bcryptPass = passwordEncoder .encode(funcionario.getSenha());
        funcionario.setSenha(bcryptPass);
        return this.funcRepo.save(funcionario);
    }
}

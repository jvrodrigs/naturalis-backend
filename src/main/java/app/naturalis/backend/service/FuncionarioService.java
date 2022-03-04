package app.naturalis.backend.service;

import app.naturalis.backend.handler.exception.NewUserEqualsCpfException;
import app.naturalis.backend.model.Cliente;
import app.naturalis.backend.model.Funcionario;
import app.naturalis.backend.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PersistenceContext
    private EntityManager manager;


    public Funcionario newFunc(Funcionario funcionario){
        Optional<Funcionario> funcEqualsCpf = this.funcRepo.findByCpf(funcionario.getCpf());
        if (!funcEqualsCpf.isEmpty()){
            throw new NewUserEqualsCpfException();
        }

        String bcryptPass = passwordEncoder .encode(funcionario.getSenha());
        funcionario.setSenha(bcryptPass);
        Funcionario funcionarioSave = this.funcRepo.save(funcionario);

        List<Integer> roles = identifPermissionsNewFunc(funcionario.getCargo().getId());
        for (int i : roles){
            funcRepo.createRelationPermFunc(funcionarioSave.getId(), i);
        }
        return funcionario;
    }

    public Optional<Funcionario> funcGetById(int id){
        Optional<Funcionario> funcById = Optional.ofNullable(this.funcRepo.findById(id).orElseThrow(() -> new EmptyResultDataAccessException(1)));
        return funcById;
    }

    public void removeFuncById(int id){
        this.funcRepo.deleteById(id);
    }

    public List<Integer> identifPermissionsNewFunc(int cargo){
        List<Integer> permissions = new ArrayList<Integer>();
        switch(cargo) {
            case 1: //ADM
                Integer permAdm[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
                permissions.addAll(Arrays.asList(permAdm));
                break;
            case 2: //ATENDENTE
                Integer permAtend[] = {1,2,6,9,14};
                permissions.addAll(Arrays.asList(permAtend));
                break;
            case 3: // ENTREGADOR
                Integer permEnt[] = {12};
                permissions.addAll(Arrays.asList(permEnt));
                break;
            case 4: // FARMACEUTICO
                Integer permFarm[] = {2,4,5,6,7,9,10,11,12};
                permissions.addAll(Arrays.asList(permFarm));
                break;
        }

        return permissions;
    }
}

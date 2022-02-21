package app.naturalis.backend;

import app.naturalis.backend.handler.exception.NewUserEqualsCpfException;
import app.naturalis.backend.model.Cargo;
import app.naturalis.backend.model.Funcionario;
import app.naturalis.backend.projection.FuncionarioSerial;
import app.naturalis.backend.repository.FuncionarioRepository;
import app.naturalis.backend.service.FuncionarioService;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class FuncionarioApplicationTests {

    @Autowired
    private FuncionarioService service;

    @Autowired
    private FuncionarioRepository repository;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    void List() throws Exception{
        List<Funcionario> Users = this.repository.findAll();
        assertThat(Users).size().isGreaterThan(0);
    }

    @Test
    void CreateUser(){
        Funcionario func = new Funcionario();
        Cargo cargo = new Cargo();
        cargo.setId(3);
        func.setNome("João do Teste");
        func.setUsername("jvrodrigsTest");
        func.setCargo(cargo);
        func.setCpf("07064193332");
        func.setEmail("jvrodrigs@gmail.com");
        func.setSenha("123");
        this.service.newFunc(func);

        assertThat(func.getId()).isNotNull();
        assertThat(func.getNome()).isEqualTo("João do Teste");
    }

    @Test
    void CreateUserEqualsCpf(){
        Funcionario func = new Funcionario();
        Cargo cargo = new Cargo();
        cargo.setId(3);
        func.setNome("João do Teste");
        func.setUsername("jvrodrigsTest");
        func.setCargo(cargo);
        func.setCpf("07064193332");
        func.setEmail("jvrodrigs@gmail.com");
        func.setSenha("123");
        try {
            this.service.newFunc(func);
        }catch (NewUserEqualsCpfException ex){
            exception.expect(NewUserEqualsCpfException.class);
        }
        assertThat(func.getId()).isNotNull();
        assertThat(func.getNome()).isEqualTo("João do Teste");
    }

    @Test
    void UserGetById(){
        int id = 1;
        Optional<Funcionario> func = this.service.funcGetById(id);

        System.out.println(func.get().getPermissaos());
        assertThat(func.get()).isNotNull();
        assertThat(func.get().getNome()).isEqualTo("João Vitor");
        assertThat(func.get().getEmail()).isEqualTo("jvrodrigs@algamoney.com");
    }

    @Test
    void UserGetByIdPermissionsAdmin(){
        int id = 1;
        Optional<Funcionario> func = this.service.funcGetById(id);

        assertThat(func.get().getPermissaos()).size().isEqualTo(15);
    }

    //Falta criar um user Atendente para testar
    @Test
    void UserGetByIdPermissionsAtendent(){
        int id = 1;
        Optional<Funcionario> func = this.service.funcGetById(id);

        assertThat(func.get().getPermissaos()).size().isEqualTo(5);
    }

    @Test
    void UserGetByIdPermissionsEntreg(){
        int id = 7;
        Optional<Funcionario> func = this.service.funcGetById(id);

        assertThat(func.get().getPermissaos()).size().isEqualTo(1);
    }


    @Test
    void UserGetByIdPermissionsPham(){
        int id = 3;
        Optional<Funcionario> func = this.service.funcGetById(id);

        assertThat(func.get().getPermissaos()).size().isEqualTo(9);
    }

}

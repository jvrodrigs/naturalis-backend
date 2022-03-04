package app.naturalis.backend.dto;

import app.naturalis.backend.model.Cargo;
import app.naturalis.backend.model.Funcionario;
import app.naturalis.backend.model.Permissao;

import java.util.List;

public class FuncionarioResDto {
    private int id;
    private String nome;
    private String username;
    private String cpf;
    private String email;
    private String cargo;
    private List<Permissao> permissaos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public List<Permissao> getPermissaos() {
        return permissaos;
    }

    public void setPermissaos(List<Permissao> permissaos) {
        this.permissaos = permissaos;
    }
}

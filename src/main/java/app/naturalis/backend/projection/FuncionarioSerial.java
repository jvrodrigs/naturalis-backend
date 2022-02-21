package app.naturalis.backend.projection;

import java.io.Serializable;

public class FuncionarioSerial implements Serializable {

    private int id;

    private String nome;

    private String username;

    private String email;

    public FuncionarioSerial(int id, String nome, String username, String email) {
        this.id = id;
        this.nome = nome;
        this.username = username;
        this.email = email;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

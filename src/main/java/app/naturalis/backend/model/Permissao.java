package app.naturalis.backend.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "permissao")
public class Permissao {

    @Id
    private int id;

    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Permissao permissao = (Permissao) o;
        return id == permissao.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

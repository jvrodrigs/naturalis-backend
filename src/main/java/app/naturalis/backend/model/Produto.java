package app.naturalis.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String codigoReferencia;

    @NotNull
    private String nome;

    private String descricao;

    @NotNull
    private String fabricante;

    @ManyToMany
    @JoinTable(name = "substancia_prod",
                joinColumns = @JoinColumn(name = "produto_id"),
                inverseJoinColumns = @JoinColumn(name = "substancia_id"))
    private List<Substancias> substanciasList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoReferencia() {
        return codigoReferencia;
    }

    public void setCodigoReferencia(String codigoReferencia) {
        this.codigoReferencia = codigoReferencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public List<Substancias> getSubstanciasList() {
        return substanciasList;
    }

    public void setSubstanciasList(List<Substancias> substanciasList) {
        this.substanciasList = substanciasList;
    }
}

package app.naturalis.backend.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "substancias")
public class Substancias {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;

    @NotNull
    private String descricao;

    @NotNull
    private String potencia;

    private String nfe;

    @NotNull
    private String laboratorio;

    @NotNull
    private String loteOrigem;

    private String loteInterno;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataFabricacao;

    @NotNull
    @Temporal(TemporalType.DATE)
    private Date dataValidade;

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

    public String getPotencia() {
        return potencia;
    }

    public void setPotencia(String potencia) {
        this.potencia = potencia;
    }

    public String getNfe() {
        return nfe;
    }

    public void setNfe(String nfe) {
        this.nfe = nfe;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getLoteOrigem() {
        return loteOrigem;
    }

    public void setLoteOrigem(String loteOrigem) {
        this.loteOrigem = loteOrigem;
    }

    public String getLoteInterno() {
        return loteInterno;
    }

    public void setLoteInterno(String loteInterno) {
        this.loteInterno = loteInterno;
    }

    public Date getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Date dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }
}

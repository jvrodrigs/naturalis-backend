package app.naturalis.backend.repository.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class OrdemServicoFilter {

    private String descricao;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dataCriacaoDe;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date dataCriacaoAte;

    private String valorTotalDe;
    private String valorTotalAte;

    private int resp;
    private int autor;


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValorTotalDe() {
        return valorTotalDe;
    }

    public void setValorTotalDe(String valorTotalDe) {
        this.valorTotalDe = valorTotalDe;
    }

    public String getValorTotalAte() {
        return valorTotalAte;
    }

    public void setValorTotalAte(String valorTotalAte) {
        this.valorTotalAte = valorTotalAte;
    }

    public Date getDataCriacaoDe() {
        return dataCriacaoDe;
    }

    public void setDataCriacaoDe(Date dataCriacaoDe) {
        this.dataCriacaoDe = dataCriacaoDe;
    }

    public Date getDataCriacaoAte() {
        return dataCriacaoAte;
    }

    public void setDataCriacaoAte(Date dataCriacaoAte) {
        this.dataCriacaoAte = dataCriacaoAte;
    }

    public int getResp() {
        return resp;
    }

    public void setResp(int resp) {
        this.resp = resp;
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }
}

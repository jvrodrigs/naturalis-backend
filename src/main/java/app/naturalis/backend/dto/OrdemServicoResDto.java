package app.naturalis.backend.dto;

import app.naturalis.backend.model.Cliente;
import app.naturalis.backend.model.Produto;
import app.naturalis.backend.model.Status;

import java.math.BigDecimal;
import java.util.Date;

public class OrdemServicoResDto {
    private int id;
    private Cliente cliente;
    private Produto produto;
    private String idAutor;
    private String nomeAutor;
    private Status status;
    private String idResp;
    private String nomeResp;
    private String descricao;
    private BigDecimal total;
    private Date dataCriado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public String getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(String idAutor) {
        this.idAutor = idAutor;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getIdResp() {
        return idResp;
    }

    public void setIdResp(String idResp) {
        this.idResp = idResp;
    }

    public String getNomeResp() {
        return nomeResp;
    }

    public void setNomeResp(String nomeResp) {
        this.nomeResp = nomeResp;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getDataCriado() {
        return dataCriado;
    }

    public void setDataCriado(Date dataCriado) {
        this.dataCriado = dataCriado;
    }
}

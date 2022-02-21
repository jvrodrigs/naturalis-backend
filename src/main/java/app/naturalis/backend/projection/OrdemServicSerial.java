package app.naturalis.backend.projection;

import app.naturalis.backend.model.Cliente;
import app.naturalis.backend.model.Produto;
import app.naturalis.backend.model.Status;

import java.io.Serializable;
import java.util.Date;

public class OrdemServicSerial implements Serializable {
    private int id;
    private Cliente cliente;
    private Produto produto;
    private FuncionarioSerial autor;
    private Status status;
    private String descricao;
    private String valorTotal;
    private FuncionarioSerial responsavel;
    private Date dataCriado;

    public OrdemServicSerial(int id, Cliente cliente, Produto produto, FuncionarioSerial autor, Status status, String descricao, String valorTotal, FuncionarioSerial responsavel, Date dataCriado) {
        this.id = id;
        this.cliente = cliente;
        this.produto = produto;
        this.autor = autor;
        this.status = status;
        this.descricao = descricao;
        this.valorTotal = valorTotal;
        this.responsavel = responsavel;
        this.dataCriado = dataCriado;
    }

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

    public FuncionarioSerial getAutor() {
        return autor;
    }

    public void setAutor(FuncionarioSerial autor) {
        this.autor = autor;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(String valorTotal) {
        this.valorTotal = valorTotal;
    }

    public FuncionarioSerial getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(FuncionarioSerial responsavel) {
        this.responsavel = responsavel;
    }

    public Date getDataCriado() {
        return dataCriado;
    }

    public void setDataCriado(Date dataCriado) {
        this.dataCriado = dataCriado;
    }
}

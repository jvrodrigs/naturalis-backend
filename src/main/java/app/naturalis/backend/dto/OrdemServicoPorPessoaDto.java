package app.naturalis.backend.dto;

import app.naturalis.backend.model.Cliente;
import app.naturalis.backend.model.OrdemServico;

import java.math.BigDecimal;

public class OrdemServicoPorPessoaDto {
    private int id;

    private Cliente cliente;

    private String status;

    private BigDecimal total;

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

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

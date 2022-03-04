package app.naturalis.backend.dto;

import java.math.BigDecimal;
import java.util.Date;

public class OrdemServicoPorMesDto {
    private String nomeCliente;
    private String nomeProduto;
    private Date mes;
    private BigDecimal total;

    public OrdemServicoPorMesDto(String nomeCliente, String nomeProduto, Date mes, BigDecimal total) {
        this.nomeCliente = nomeCliente;
        this.nomeProduto = nomeProduto;
        this.mes = mes;
        this.total = total;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Date getMes() {
        return mes;
    }

    public void setMes(Date mes) {
        this.mes = mes;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}

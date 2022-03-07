package app.naturalis.backend.dto;

import java.math.BigDecimal;
import java.util.Date;

public class OrdemServicoPorDiaDto {
    private Date dataCompra;
    private BigDecimal total;

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}

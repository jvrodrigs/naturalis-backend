package app.naturalis.backend.repository.filter;

public class ProdutoFilter {

    private String nome;
    private String codigoRef;
    private String fabricante;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoRef() {
        return codigoRef;
    }

    public void setCodigoRef(String codigoRef) {
        this.codigoRef = codigoRef;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }
}

public class Aficionado {
    private String celular;
    private String PaisFavorito;

    public Aficionado(String celular, String PaisFavorito) {
        this.celular = celular;
        this.PaisFavorito = PaisFavorito;
    }

    public String getcelular() {
        return celular;
    }

    public String getPaisFavoito() {
        return PaisFavorito;
    }

    public void setcelular(String celular) {
        this.celular = celular;
    }

    public void setPaisFavorito(String PaisFavorito) {
        this.PaisFavorito = PaisFavorito;
    }
}

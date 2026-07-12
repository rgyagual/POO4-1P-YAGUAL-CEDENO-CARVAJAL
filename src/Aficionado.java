import java.util.ArrayList;

public class Aficionado extends Usuario {
    private String celular;
    private String PaisFavorito;
    private ArrayList<Compra> historialCompras;

    public Aficionado(String codigoUnico, String cedula,
            String nombres, String apellidos,
            String usuario, String contraseña,
            String correo, String celular,
            String paisFavorito) {
        super(codigoUnico, cedula, nombres,
                apellidos, usuario, contraseña,
                correo);

        this.celular = celular;
        PaisFavorito = paisFavorito;
        historialCompras = new ArrayList<>();
    }

    public String getCelular() {
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

    @Override
    public void consultarEntradas(){}
}

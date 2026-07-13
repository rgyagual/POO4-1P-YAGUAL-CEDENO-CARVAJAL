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
        this.PaisFavorito = paisFavorito;
        historialCompras = new ArrayList<>();
    }

    public String getCelular() {
        return celular;
    }

    public String getPaisFavoito() {
        return PaisFavorito;
    }

    public ArrayList<Compra> getHistorialCompras() {
        return historialCompras;
    }
    
    public void setcelular(String celular) {
        this.celular = celular;
    }

    public void setPaisFavorito(String PaisFavorito) {
        this.PaisFavorito = PaisFavorito;
    }


    @Override
    public void consultarEntradas(ArrayList<Compra> compras){
        System.out.println("COMPRAS REALIZADAS");
        for(Compra c: compras){
            if(c.getCodigoAficionado().equals(this.getCodigoUnico())){
                System.out.println(c.toString());
            }
        }
    }

    public Compra comprar(Partido p, Zona zona, int cantidad, 
            String numeroTarjeta){
        int entradasDisponibles=0;
        double precioEntrada=0;
        switch(zona){
            case GENERAL:
                entradasDisponibles=p.getEntradaGeneral();
                precioEntrada=p.getPrecioGeneral();
                break;
            case PREFERENCIAL:
                entradasDisponibles=p.getEntradaPreferencial();
                precioEntrada=p.getPrecioPreferencial();
                break;
            case VIP:
                entradasDisponibles=p.getEntradaVip();
                precioEntrada=p.getPrecioVip();
                break;
        }
        Compra compraNueva=null;
        if(cantidad>entradasDisponibles || cantidad<=0){
            System.out.println("No hay entradas disponibles para esa zona");        
        }else{
            double totalPagar=cantidad*precioEntrada;
            System.out.println("Total a pagar: "+totalPagar);
            System.out.println("Pago exitoso");
            compraNueva=new Compra("Entrada", p.getCodigoPartido(), 
                new Date(), cantidad, totalPagar, this.codigoUnico);
        }
        return compraNueva;
        
    }
}
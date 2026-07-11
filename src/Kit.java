import java.util.ArrayList;

public class Kit {

    private String codigoKit;
    private String nombreKit;
    private String descripcion;
    private double precioKit;
    private int cantidadDisponible;
    private ArrayList<Partido> partidosIncluidos;

    public Kit(String codigoKit, String nombreKit,
            String descripcion, double precioKit,
            int cantidadDisponible, ArrayList<Partido> partidosIncluidos) {

        this.codigoKit = codigoKit;
        this.nombreKit = nombreKit;
        this.descripcion = descripcion;
        this.precioKit = precioKit;
        this.cantidadDisponible = cantidadDisponible;
        this.partidosIncluidos = partidosIncluidos;
    }

    public String getCodigoKit() {
        return codigoKit;
    }

    public void setCodigoKit(String codigoKit) {
        this.codigoKit = codigoKit;
    }

    public String getNombreKit() {
        return nombreKit;
    }

    public void setNombreKit(String nombreKit) {
        this.nombreKit = nombreKit;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecioKit() {
        return precioKit;
    }

    public void setPrecioKit(double precioKit) {
        this.precioKit = precioKit;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public ArrayList<Partido> getPartidosIncluidos() {
        return partidosIncluidos;
    }

    public void setPartidosIncluidos(ArrayList<Partido> partidosIncluidos) {
        this.partidosIncluidos = partidosIncluidos;
    }

    @Override
    public String toString() {
        String partidos = "";
        for (Partido p : partidosIncluidos) {
            partidos += "\n-" + p.getEquipoLocal() + " vs " + p.getEquipoVisitante();
        }
        return nombreKit +
                "\nIncluye: " + partidos +
                "\n\nPrecio: " + precioKit +
                "\nDisponibles: " + cantidadDisponible;
    }

}

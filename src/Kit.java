import java.util.ArrayList;

/**
 * Representa un kit de entradas disponible para la venta.
 * Un kit agrupa varios partidos y cuenta con un precio y una
 * cantidad limitada de unidades disponibles.
 *
 * @author Yagual-Cedeño-Carvajal
 */
public class Kit {

    // ===========================
    // ATRIBUTOS
    // ===========================
    /** Código único que identifica al kit */
    private String codigoKit;
    /** Nombre del Kit */
    private String nombreKit;
    /** Descripción del contenido del Kit */
    private String descripcion;
    /** Precio de venta del Kit */
    private double precioKit;
    /** Cantidad de Kits Disponibles */
    private int cantidadDisponible;
    /** lista de partidos que incluye el Kit */
    private ArrayList<Partido> partidosIncluidos;

    // ======================
    // CONSTRUCTOR
    // ======================
    /**
     * Se genera un Kit con la información necesario
     * 
     * @param codigoKit          Código único del Kit
     * @param nombreKit          Nomre del Kit
     * @param descripcion        Descripcion del kit
     * @param precioKit          Precio del kit
     * @param cantidadDisponible Cantidad de kits disponibles para la venta
     * @param partidosIncluidos  Lista de partidos incluidos en el Kit
     */
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

    // =========================
    // Getter y Setters
    // =========================
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

    // =========================
    /**
     * Devuelve una representación en texto con la información del Kit
     * 
     * @return Cadena de texto con la informacion del kit
     */
    @Override
    public String toString() {
        String partidos = "";
        for (Partido p : partidosIncluidos) {
            partidos += "\n-" + p.getEquipoLocal() + " vs " + p.getEquipoVisitante();
        }
        return nombreKit +
                "\nIncluye: " + partidos +
                "\n\nPrecio: " + precioKit +
                "\nDisponibles: " + cantidadDisponible+
                "\n------------";
    }

}

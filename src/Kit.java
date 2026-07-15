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
    /**
     * Devuelve el código del Kit
     *
     * @return codigo del kit
     */
    public String getCodigoKit() {
        return codigoKit;
    }

    /**
     * Establece o actualiza el código del Kit
     * 
     * @param codigoKit código de kit a asignar
     */
    public void setCodigoKit(String codigoKit) {
        this.codigoKit = codigoKit;
    }

    /**
     * Devuelve el nombre del Kit
     * 
     * @return nombre del kit
     */
    public String getNombreKit() {
        return nombreKit;
    }

    /**
     * Establece o actualiza el nombre del kit
     * 
     * @param nombreKit nombre de Kit a asignar
     */
    public void setNombreKit(String nombreKit) {
        this.nombreKit = nombreKit;
    }

    /**
     * Devuelve la descripción del Kit
     * 
     * @return descripción del kit
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Establece o actualiza la descripción del kit
     * 
     * @param descripcion descripcion de kit a asignar
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve el precio del kit
     * 
     * @return precio del kit
     */
    public double getPrecioKit() {
        return precioKit;
    }

    /**
     * Establece o actualiza el precio del Kit
     * 
     * @param precioKit precio de Kit a asignar
     */
    public void setPrecioKit(double precioKit) {
        this.precioKit = precioKit;
    }

    /**
     * Devuelve la cantidad de Kits disponibles
     * 
     * @return cantidad de kits disponibles
     */
    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    /**
     * Establece o actualiza la cantidad de kits
     * 
     * @param cantidadDisponible cantidad de kit a asignar
     */
    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    /**
     * Devuelve la lista de los partidos incluidos en el Kit
     * 
     * @return lista de partidos incluidos en el Kit
     */
    public ArrayList<Partido> getPartidosIncluidos() {
        return partidosIncluidos;
    }

    /**
     * Establece o actualiza la lista de partidos incluidos en el Kit
     * 
     * @param partidosIncluidos lista de partidos a asignar
     */
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
                "\nDisponibles: " + cantidadDisponible +
                "\n------------";
    }

}

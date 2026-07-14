import java.util.Date;

/**
 * Representa una compra realizada por un aficionado dentro del sistema.
 * Una compra puede corresponder a la adquisición de una entrada o de un kit,
 * almacenando la información necesaria sobre la compra.
 *
 * @author Yagual-Cedeño-Carvajal
 */
public class Compra {
    // ==================================
    // ATRIBUTOS
    // ==================================
    /** Código único de compra */
    private String codigoCompra;
    /** Tipo de compra: Kit o Entrada */
    private String tipo;
    /** Código del Kit o Entrada adquirido */
    private String codigoReferencia;
    /** Fecha en la que se realizó la compra */
    private Date fechaCompra;
    /** Cantidad de elementos comprados */
    private int cantidad;
    /** Valor total de la compra */
    private double valorPagado;
    /** Codigo del Aficionado Comprador */
    private String codigoAficionado;
    /** Zona elegida de la compra */
    private Zona zonaCompra;
    /** Contador utilizado para generar código de compra */
    private static int contador = 0;
    /** FasesMundial elegida en la compra */
    private FasesMundial fase;

    private String descripcionKit;

    // ===================================
    // CONSTRUCTOR
    // ===================================

    /**
     * Crea una nueva Compra con la información recopilada
     * 
     * @param tipo             Tipo de compra realizada
     * @param codigoReferencia Codigo del Kit o Entrada
     * @param fechaCompra      Fecha en la que se realiza la compra
     * @param cantidad         Cantidad de elementos en la compra
     * @param valorPagado      Valor total cancelado
     * @param codigoAficionado Codigo del Aficionado que realiza la compra
     */
    public Compra(String tipo,
            String codigoReferencia,
            Date fechaCompra,
            int cantidad,
            double valorPagado,
            String codigoAficionado,
            Zona zona) {

        this.tipo = tipo;
        this.codigoReferencia = codigoReferencia;
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
        this.valorPagado = valorPagado;
        this.codigoAficionado = codigoAficionado;
        this.zonaCompra = zona;
        this.cantidad = cantidad;
        contador++;
        generarCodigoCompra();
    }

    public Compra(String tipo,
            String codigoReferencia,
            Date fechaCompra,
            int cantidad,
            double valorPagado,
            String codigoAficionado,
            String descripcionKit) {

        this.tipo = tipo;
        this.codigoReferencia = codigoReferencia;
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
        this.valorPagado = valorPagado;
        this.codigoAficionado = codigoAficionado;
        this.descripcionKit = descripcionKit;
        this.zonaCompra = null;
        this.cantidad = cantidad;
        contador++;
        generarCodigoCompra();
    }

    // ================================
    // Getters y Setters
    // ================================
    public String getCodigoCompra() {
        return codigoCompra;
    }

    public String getTipo() {
        return tipo;
    }

    public String getCodigoReferencia() {
        return codigoReferencia;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getvalorPagado() {
        return valorPagado;
    }

    public String getCodigoAficionado() {
        return codigoAficionado;
    }

    public static int getContador() {
        return contador;
    }

    public Zona getZonaCompra() {
        return zonaCompra;
    }

    public FasesMundial getfase() {
        return fase;
    }
    public String getDescripcionKit() {
        return descripcionKit;
    }
    // ================================

    /**
     * Genera el codigo de Compra usando el contador de compras registradas
     */
    public void generarCodigoCompra() {
        String codigoCompra = String.format("C%03d", contador);
        this.codigoCompra = codigoCompra;
    }

    /**
     * Devuelve una representación en texto con la información de la compra.
     *
     * @return Cadena de texto con los datos de la compra.
     */
    @Override
    public String toString() {
        if (zonaCompra != null) {
            return "Código: " + codigoCompra +
                    "\nTipo: " + tipo +
                    "\nCodigo de Referencia: " + codigoReferencia +
                    "\nFecha: " + fechaCompra +
                    "\nZona: " + zonaCompra +
                    "\nCantidad: " + cantidad +
                    "\nCodigo de Aficionado: " + codigoAficionado;
        }else{
            return "Código: " + codigoCompra +
                    "\nTipo: " + tipo +
                    "\nCodigo de Referencia: " + codigoReferencia +
                    "\nFecha: " + fechaCompra +
                    "\nDescripción: " +descripcionKit+
                    "\nCantidad: " + cantidad +
                    "\nCodigo de Aficionado: " + codigoAficionado;
        }
    }

    public void agregarCompraTxt() {
        if(zonaCompra != null){
        ManejoArchivos.EscribirArchivo("compras.txt",
                codigoCompra + "|" + tipo + "|" + codigoReferencia + "|" + fechaCompra + "|" + zonaCompra + "|"
                        + cantidad + "|" + codigoAficionado);
        }else{
            ManejoArchivos.EscribirArchivo("compras.txt",
                codigoCompra + "|" + tipo + "|" + codigoReferencia + "|" + fechaCompra + "|" + descripcionKit + "|"
                        + cantidad + "|" + codigoAficionado);
        }
    }

}
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
    /** Categoría de ubicación del ticket */
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
     * Crea una nueva Compra de Entradas con la información recopilada
     * 
     * @param tipo             Tipo de compra realizada
     * @param codigoReferencia Codigo del Kit o Entrada
     * @param fechaCompra      Fecha en la que se realiza la compra
     * @param cantidad         Cantidad de elementos en la compra
     * @param valorPagado      Valor total cancelado
     * @param codigoAficionado Codigo del Aficionado que realiza la compra
     * @param zona             zona asignada a la entrada
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

    /**
     * Crea una nueva Compra de kits con la información recopilada
     * 
     * @param tipo             Tipo de compra realizada
     * @param codigoReferencia Codigo del Kit o Entrada
     * @param fechaCompra      Fecha en la que se realiza la compra
     * @param cantidad         Cantidad de elementos en la compra
     * @param valorPagado      Valor total cancelado
     * @param codigoAficionado Codigo del Aficionado que realiza la compra
     * @param descripcionKit   Descripción del Kit comprado
     */
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
    /**
     * Devuelve el código de la Compra
     * 
     * @return codigo de la compra
     */
    public String getCodigoCompra() {
        return codigoCompra;
    }

    /**
     * Devuelve el Tipo de compra
     * 
     * @return tipo de compra (Kit o Entrada)
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Devuelve el codigo de Referencia ( Codigo del Kit o del Partido)
     * 
     * @return codigo de Referencia
     */
    public String getCodigoReferencia() {
        return codigoReferencia;
    }

    /**
     * Devuelve la fecha de la compra
     * 
     * @return fecha de compra
     */
    public Date getFechaCompra() {
        return fechaCompra;
    }

    /**
     * Devuelve la cantidad de entradas compradas
     * 
     * @return la cantidad de entradas
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Devuelve el valor cancelado por la compra
     * 
     * @return valor total pagado
     */
    public double getvalorPagado() {
        return valorPagado;
    }

    /**
     * Devuelve el codigo del comprador
     * 
     * @return codigo de Aficionado comprador
     */
    public String getCodigoAficionado() {
        return codigoAficionado;
    }

    /**
     * Devuelve el conteo de compras
     * 
     * @return contador de compras
     */
    public static int getContador() {
        return contador;
    }

    /**
     * Devuelve la zona seleccionada por el comprador
     * 
     * @return zona de ticket
     */
    public Zona getZonaCompra() {
        return zonaCompra;
    }

    /**
     * Devuelve la Fase del Mundial
     * 
     * @return fase del mundial
     */
    public FasesMundial getfase() {
        return fase;
    }

    /**
     * Devuelve la descripcion de un kit
     * 
     * @return descripcion de kit
     */
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
     * Devuelve una representación en texto con la información de la compra,
     * evaluando si la compra es un Kit o una Entrada
     *
     * @return Cadena de texto con los datos de la compra.
     */
    @Override
    public String toString() {
        if (zonaCompra != null) {
            return "Código: " + codigoCompra +
                    "\nTipo: " + tipo +
                    "\nCodigo de Referencia: " + codigoReferencia +
                    "\nFecha: " + Sistema.FORMATO_FECHA.format(fechaCompra) +
                    "\nZona: " + zonaCompra +
                    "\nCantidad: " + cantidad +
                    "\nCodigo de Aficionado: " + codigoAficionado +
                    "\n------------";
        } else {
            return "Código: " + codigoCompra +
                    "\nTipo: " + tipo +
                    "\nCodigo de Referencia: " + codigoReferencia +
                    "\nFecha: " + Sistema.FORMATO_FECHA.format(fechaCompra) +
                    "\nDescripción: " + descripcionKit +
                    "\nCantidad: " + cantidad +
                    "\nCodigo de Aficionado: " + codigoAficionado +
                    "\n------------";
        }
    }

    /**
     * Agrega la compra en el formato establecido a el archivo de texto compra.txt
     * evaluando si es una Entrada o un Kit
     * 
     */
    public void agregarCompraTxt() {
        if (zonaCompra != null) {
            ManejoArchivos.EscribirArchivo("compras.txt",
                    codigoCompra + "|" + tipo + "|" + codigoReferencia + "|" + Sistema.FORMATO_FECHA.format(fechaCompra)
                            + "|" + zonaCompra + "|"
                            + cantidad + "|" + valorPagado + "|" + codigoAficionado);
        } else {
            ManejoArchivos.EscribirArchivo("compras.txt",
                    codigoCompra + "|" + tipo + "|" + codigoReferencia + "|" + Sistema.FORMATO_FECHA.format(fechaCompra)
                            + "|" + descripcionKit + "|"
                            + cantidad + "|" + valorPagado + "|" + codigoAficionado);
        }
    }

}
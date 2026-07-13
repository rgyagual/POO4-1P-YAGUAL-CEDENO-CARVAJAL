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
    /** Contador utilizado para generar código de compra */
    private static int contador = 0;

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
            String codigoReferencia, Date fechaCompra,
            int cantidad, double valorPagado,
            String codigoAficionado) {

        this.tipo = tipo;
        this.codigoReferencia = codigoReferencia;
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
        this.valorPagado = valorPagado;
        this.codigoAficionado = codigoAficionado;
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

    public double getValorPagado() {
        return valorPagado;
    }

    public String getCodigoAficionado() {
        return codigoAficionado;
    }

    public static int getContador() {
        return contador;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCodigoReferencia(String codigoReferencia) {
        this.codigoReferencia = codigoReferencia;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCodigoAficionado(String codigoAficionado) {
        this.codigoAficionado = codigoAficionado;
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
        return "Código: " + codigoCompra +
                "\nTipo: " + tipo +
                "\nCodigo de Referencia: " + codigoReferencia +
                "\nFecha: " + fechaCompra +
                "\nCantidad: " + cantidad +
                "\nValor Pagado: " + valorPagado +
                "\nCodigo de Aficionado: " + codigoAficionado;
    }

    public void agregarCompraTxt(){
        ManejoArchivos.EscribirArchivo("compras.txt", 
        codigoCompra +"|" + tipo +"|" + codigoReferencia +"|" + fechaCompra +"|" + cantidad +"|" + valorPagado +"|" + codigoAficionado);
}

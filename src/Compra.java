import java.util.Date;

public class Compra {

    private String codigoCompra;
    private String tipo;
    private String codigoReferencia;
    private Date fechaCompra;
    private int cantidad;
    private double valorPagado;
    private String codigoAficionado;
    private static int contador = 0;

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

    public void generarCodigoCompra() {
        String codigoCompra = String.format("C%03d", contador);
        this.codigoCompra = codigoCompra;
    }

    @Override
    public String toString() {
        return "Código: " + codigoCompra + 
        "\nTipo: " + tipo + 
        "\nCodigo de Referencia: " + codigoReferencia+ 
        "\nFecha: " + fechaCompra + 
        "\nCantidad: " + cantidad + 
        "\nValor Pagado: " + valorPagado+ 
        "\nCodigo de Aficionado: " + codigoAficionado;
    }

}

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

    public void setCodigoCompra(String codigoCompra) {
        this.codigoCompra = codigoCompra;
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

    public void setValorPagado(double valorPagado) {
        this.valorPagado = valorPagado;
    }

    public void setCodigoAficionado(String codigoAficionado) {
        this.codigoAficionado = codigoAficionado;
    }

}

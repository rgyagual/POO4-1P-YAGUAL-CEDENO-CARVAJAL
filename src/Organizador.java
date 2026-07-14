import java.util.ArrayList;
import java.util.List;

/**
 * Representa un usuario de tipo Organizador dento del sistema.
 * Hereda los atributos y métodos de la clase Usuario, y agrega
 * atributos propios como empresa y cargo.
 * Puede consultar entradas y generar reportes de ventas.
 * 
 * @author Yagual-Cedeño-Carvajal
 */
public class Organizador extends Usuario {
    // ====================================
    // ATRIBUTOS
    // ====================================
    /**Nombre de la empresa organizadora. */
    private String empresa;
    /**Cargo del organizador. */
    private String cargo;

    // ====================
    // CONSTRUCTOR
    // ====================
    /**
     * Crea un nuevo organizador.
     * 
     * @param codigoUnico  Código único del organizador.
     * @param cedula       Número de cédula del organizador.
     * @param nombres      Nombre del organizador.
     * @param apellidos    Apellido del organizador.
     * @param usuario      Nombre de usuario para inicio de sesión.
     * @param contraseña   Contraseña del organizador.
     * @param correo       Correo electrónico del organizador.
     * @param empresa      Nombre de la empresa organizadora.
     * @param cargo        Cargo del organizador.
     */
    public Organizador(String codigoUnico, String cedula,
            String nombres, String apellidos,
            String usuario, String contraseña, String correo,
            String empresa, String cargo) {

        super(codigoUnico, cedula, nombres,
                apellidos, usuario, contraseña,
                correo);
        this.empresa = empresa;
        this.cargo = cargo;
    }

    // ===================================
    // Getters y Setters
    // ===================================
    /**
     * Devuelve el nombre de la empresa organizadora
     * 
     * @return Nombre de la empresa organizadora
     */
    public String getEmpresa() {
        return this.empresa;
    }

    /**
     * Establecer nuevo nombre de la empresa organizadora.
     * 
     * @param empresa
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     * Devuelve el cargo del organizador.
     * 
     * @return Cargo del organizador.
     */
    public String getCargo() {
        return this.cargo;
    }

    /**
     * Establecer nuevo cargo del organizador.
     * 
     * @param cargo
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Método sobrescrito que muestra todas las compras
     * realizadas en el sistema.
     * 
     * @param compras Lista de compras registradas en el sistema.
     */
    @Override
    public void consultarEntradas(ArrayList<Compra> compras) {
        System.out.println("COMPRAS REGISTRADAS");
        for (Compra c : compras) {
            System.out.println(c.toString());
        }
    }

    /**
     * Método que genera reporte de las ventas registradas en el 
     * sistema.
     * Muestra el total de compras registradas, cantidad de compras por tipo
     * (entrada o kit) y el monto total recaudado por ventas.
     * 
     * @param compras Lista de compras registradas en el sistema.
     */
    public void generarReporte(List<Compra> compras) {
        int totalEntradas = 0;
        int totalKits = 0;
        int totalCompras = compras.size();
        double total = 0;

        for (Compra c : compras) {
            total += c.getvalorPagado();

            if (c.getTipo().equals("ENTRADA")) {
                totalEntradas += c.getCantidad();
            } else if (c.getTipo().equals("KIT")) {
                totalKits += c.getCantidad();
            }

        }
        System.out.println("===== GENERAR REPORTE DE VENTAS =====");
        System.out.println("Resumen de ventas regisradas: ");
        System.out.println("Total de compras: " + totalCompras);
        System.out.println("Compras por tipo:");
        System.out.println("Entradas: " + totalEntradas);
        System.out.println("Kits: " + totalKits);
        System.out.println("Monto toal recaudado: ");
        System.out.printf("$%,.2f\n", total);

    }
}

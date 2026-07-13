import java.util.ArrayList;
import java.util.List;

public class Organizador extends Usuario {
    private String empresa;
    private String cargo;

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

    public String getEmpresa() {
        return this.empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public void consultarEntradas(ArrayList<Compra> compras) {
        System.out.println("COMPRAS REGISTRADAS");
        for (Compra c : compras) {
            System.out.println(c.toString());
        }
    }

    public void establecerPrecios(Partido p, double precioGeneral, 
            double precioPreferencial,double precioVip){
        p.setPrecioGeneral(precioGeneral);
        p.setPrecioPreferencial(precioPreferencial);
        p.setPrecioVip(precioVip);

    public void generarReporte(List<Compra> compras) {
        int totalEntradas = 0;
        int totalKits = 0;
        int totalCompras = compras.size();
        double total = 0;

        for (Compra c : compras) {
            total += c.getValorPagado();

            if (c.getTipo().equals("ENTRADA")) {
                totalEntradas += c.getCantidad();
            } else if (c.getTipo().equals("KIT")) {
                totalKits += c.getCantidad();
            }

        }
        System.out.println("-----GENERAR REPORTE DE VENTAS-----");
        System.out.println("Resumen de ventas regisradas: ");
        System.out.println("Total de compras: " + totalCompras);
        System.out.println("Compras por tipo:");
        System.out.println("Total de Entradas Vendidas: " + totalEntradas);
        System.out.println("Total de Entradas Kits: " + totalKits);
        System.out.println("Total de dinero generado: ");
        System.out.printf("$%,.2f\n", total);


    }
}

import java.util.ArrayList;

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
    public void consultarEntradas(ArrayList<Compra> compras){
        System.out.println("COMPRAS REGISTRADAS");
        for(Compra c: compras){
            System.out.println(c.toString());
        }
    }
}

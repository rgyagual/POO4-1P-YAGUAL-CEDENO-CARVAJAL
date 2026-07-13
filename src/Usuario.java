import java.util.ArrayList;
/**
 * Representa la clase abstracta base para todos los usuarios del sistema.
 * Contiene los atributos y métodos comunes que comparten los aficionados
 * y los organizadores.
 *
 * @author Yagual-Cedeño-Carvajal
 * 
 */
public abstract class Usuario {
    // ====================================
    // ATRIBUTOS
    // ====================================
    /** Código Único de usuario */
    protected String codigoUnico;
    /** Número de cédula del usuario */
    protected String cedula;
    /** Nombre del Usuario */
    protected String nombres;
    /** Apellido del Usuario */
    protected String apellidos;
    /** Nombre de usuario registrado en el Sistema */
    protected String usuario;
    /** Contraseña del usuario registrada en el Sistema */
    protected String contraseña;
    /** Correo del Usuario registrado en el Sistema */
    protected String correo;
    /** Rol de Usuario dentro del Sistema */
    protected Rol rol;

    // ====================
    // CONSTRUCTOR
    // ====================
    /**
     * Inicia un Usuario con su información básica
     * 
     * @param codigoUnico Código único del usuario
     * @param cedula      Número de cédula del usuario
     * @param nombres     Nombre del usuario
     * @param apellidos   Apellido del usuario
     * @param usuario     Nombre de usuario para inicio de sesión
     * @param contraseña  Contraseña del usuario
     * @param correo      Correo electrónico del usuario
     */
    public Usuario(String codigoUnico,
            String cedula,
            String nombres,
            String apellidos,
            String usuario,
            String contraseña,
            String correo) {

        this.codigoUnico = codigoUnico;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.correo = correo;
    }
    // ===================================
    // Getters y Setters
    // ===================================

    public String getCodigoUnico() {
        return codigoUnico;
    }

    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    // ================================

    /**
     * Método abstracto que permite consultar las entradas al usuario.
     * Este método debe ser implementado por las subclases de Usuario, cada una con
     * su implementación (Sobreescritura)   
     */
    public abstract void consultarEntradas(ArrayList<Compra> compras);

    /**
     * Devuelve una representación en texto con la información del usuario
     * 
     * @return Cadena con datos del usuario.
     */
    @Override
    public String toString() {
        return "\nCodigo Unico: " + codigoUnico +
                "\nCedula: " + cedula +
                "\nNombres: " + nombres +
                "\nApellidos: " + apellidos +
                "\nCorreo: " + correo +
                "\nUsuario: " + usuario +
                "\nRol: " + rol;
    }

}

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

    /**
     * Devuelve el código único del usuario
     * @return Código único del usuario
     */
    public String getCodigoUnico() {
        return codigoUnico;
    }

/**
 *  Establece o actualiza el código único del usuario
 * 
 * @param codigoUnico El nuevo código único a asignar
 */
    public void setCodigoUnico(String codigoUnico) {
        this.codigoUnico = codigoUnico;
    }
/**
 * Devuelve el número de cédula
 * 
 * @return número de cédula
 */
    public String getCedula() {
        return cedula;
    }
/**
 * Establece o actualiza la cédula del usuario
 * 
 * @param cedula El número de cédula a asignar
 */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

/**
 * Devuelve el nombre del Usuario
 * 
 * @return nombre del Usuario
 */
    public String getNombres() {
        return nombres;
    }
/**
 * Establece o actualiza el nombre del usuario
 * 
 * @param nombres nombre a asignar
 */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
/**
 * Devuelve el apellido del usuario
 * 
 * @return apellido del usuario
 */
    public String getApellidos() {
        return apellidos;
    }
/**
 * Establece o actualiza el apellido del usuario
 * 
 * @param apellidos apellido a asignar
 */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
/**
 * Devuelve el username para el inicio de sesión
 * 
 * @return El nombre de usuario registrado
 */
    public String getUsuario() {
        return usuario;
    }
/**
 * Establece o actualiza el username para el inicio de seión
 * 
 * @param usuario nuevo username a asignar
 */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
/**
 * Devuelve la contraseña para el inicio de sesión del usuario
 * 
 * @return contraseña del usuario
 */
    public String getContraseña() {
        return contraseña;
    }
/**
 * Establece o actualiza la contraseña de acceso del usuario
 * 
 * @param contraseña contraseña a asignar
 */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
/**
 * Devuelve el correo del usuario
 * 
 * @return correo del usuario
 */

    public String getCorreo() {
        return correo;
    }
/**
 * Establece o actualiza el correo del usuario
 * @param correo correo a asignar
 */
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

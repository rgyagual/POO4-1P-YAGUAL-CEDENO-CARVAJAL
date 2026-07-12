public abstract class Usuario {

    protected String codigoUnico;
    protected String cedula;
    protected String nombres;
    protected String apellidos;
    protected String usuario;
    protected String contraseña;
    protected String correo;
    protected Rol rol;
    

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
   

    public abstract void consultarEntradas();

    @Override
    public String toString() {
        return "\nCodigo Unico: " + codigoUnico +
                "\nCedula: " + cedula +
                "\nNombres: " + nombres +
                "\nApellidos: " + apellidos +
                "\nCorreo: " + correo +
                "\nUsuario: "+usuario+
                "\nRol: " + rol;
    }

}

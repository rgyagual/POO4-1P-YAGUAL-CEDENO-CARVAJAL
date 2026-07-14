public class Main {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.cargarUsuarios();
        sistema.cargarPartidos();
        sistema.cargarKits();
        sistema.iniciarSesion();
        sistema.cerrarSistema();
    }
}

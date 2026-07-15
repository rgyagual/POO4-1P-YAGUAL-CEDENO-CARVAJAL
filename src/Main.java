/**
 * Clase principal que inicializa la aplicación del sistema de venta de
 * entradas. Controla el flujo principal del programa, la carga de datos de
 * prueba, y despliega el menú de interacción para los usuarios.
 * 
 * @author Yagual-Cedeño-Carvajal
 * 
 */
public class Main {
    public static void main(String[] args) {
        /**Se instancia el sistema */
        Sistema sistema = new Sistema();
        /**Carga de datos en el sistema */
        sistema.cargarUsuarios();
        sistema.cargarPartidos();
        sistema.cargarKits();
        sistema.cargarCompras();
        /**Despliegue del menú según el usuario */
        sistema.iniciarSesion();
        /**Cierre del Sistema -cierre de Scanner- */
        sistema.cerrarSistema();
    }
}

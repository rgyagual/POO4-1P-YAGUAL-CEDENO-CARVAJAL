import java.util.ArrayList;
import java.util.Scanner;

/**
 * Administra la información principal del sistema de venta y gestión
 * de entradas para el Mundial.
 * Mantiene el registro de usuarios, partidos, kits y compras,
 * además de gestionar el proceso de inicio de sesión y ejecución de opciones
 * del menú.
 * 
 * @author Yagual-Cedeño-Carvajal
 */
public class Sistema {
    // =======================================
    // ATRIBUTOS
    // =======================================

    /** Lista de usuarios registrados en el sistema (txt) */
    private ArrayList<Usuario> usuarios;
    /** Lista de partidos registrados en el sistema (txt) */
    private ArrayList<Partido> partidos;
    /** Lista de Kits registrados en el sistema (txt) */
    private ArrayList<Kit> kits;
    /** Lista de Compras Totales realizadas */
    private ArrayList<Compra> compras;

    // ================================
    // Getters y Setters
    // =================================

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    public ArrayList<Kit> getKits() {
        return kits;
    }

    public void setKits(ArrayList<Kit> kits) {
        this.kits = kits;
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }

    /**
     * Permite a un usuario iniciar sesión en el sistema verificando
     * sus credenciales y mostrando el menú correspondiente según su rol.
     * Si la autenticación falla o la verificación de identidad no es
     * confirmada, la sesión se cierra.
     */
    public void iniciarSesion() {

        // Solicitud de credenciales al usuario
        Scanner sc = new Scanner(System.in);
        System.out.println("=====INICIO DE SESIÓN=====");
        System.out.print("Usuario: ");
        String usuario = sc.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = sc.nextLine();
        boolean autenticado = false;
        // Busca un usuario con las credenciales ingresadas
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario) && u.getContraseña().equals(contraseña)) {
                System.out.println("Usuario autenticado correctamente.");
                autenticado = true;
                // Si el usuario autenticado es un aficionado
                if (u instanceof Aficionado) {
                    Aficionado af = (Aficionado) u;
                    System.out.println("Rol detectado: AFICIONADO");
                    System.out.println("\nBienvenida, " + af.getNombres() + " " + af.getApellidos());
                    System.out.println("Celular registrado: " + af.getCelular());
                    System.out.print("¿Este número de celular es correcto? (S/N): ");
                    String validarNumero = sc.nextLine();
                    // Muestra menú de opciones de Aficionado
                    if (validarNumero.equals("S")) {
                        System.out.println("Identidad confirmada.");
                        System.out.println("Menú de Aficionado: ");
                        System.out.println("1. Consultar partidos");
                        System.out.println("2. Comprar entrada");
                        System.out.println("3. Comprar Kit de entradas");
                        System.out.println("4. Consultar entradas");
                        System.out.println("5. Salir");
                        System.out.println("Seleccione una opción: ");
                        int opcionElegida = sc.nextInt();
                        sc.nextLine();
                        switch (opcionElegida) {
                            case 1:
                                System.out.println("Partidos encontrados: ");
                                for (int i = 0; i < partidos.size(); i++) {
                                    System.out.println((i + 1) + ". " + partidos.get(i));
                                }
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Opción elegida inválida");
                                break;
                        }

                    } else {
                        System.out.println("Verificación fallida.");
                        System.out.println("Por motivos de seguridad se cerrará la sesión");
                        System.out.println("\nSaliendo del sistema...");
                        break;
                    }
                    // Si el usuario autenticado es un Organizador
                } else if (u instanceof Organizador) {
                    Organizador og = (Organizador) u;
                    System.out.println("Rol detectado: ORGANIZADOR");
                    System.out.println("Bienvenido, " + og.getNombres() + " " + og.getApellidos());
                    System.out.println("Empresa asignada: " + og.getEmpresa());
                    System.out.print("Esta empresa es correcta(S/N): ");
                    String validarEmpresa = sc.nextLine();
                    // Muestra menú de opciones de Organizador
                    if (validarEmpresa.equals("S")) {
                        System.out.println("Menú de Organizador:");
                        System.out.println("1. Consultar entradas");
                        System.out.println("2. Generar Reporte");
                        System.out.println("3. Salir");
                        System.out.print("Seleccione una opción: ");
                        int opcionElegida = sc.nextInt();
                        sc.nextLine();
                        switch (opcionElegida) {
                            case 1:

                                break;
                            case 2:
                                break;
                            case 3:
                                break;

                            default:
                                System.out.println("Opción elegida inválida");
                                break;
                        }
                    } else {
                        System.out.println("Verificación fallida.");
                        System.out.println("Por motivos de seguridad se cerrará la sesión");
                        System.out.println("\nSaliendo del sistema...");
                        break;

                    }
                }
            }
        } if(!autenticado){
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }
}

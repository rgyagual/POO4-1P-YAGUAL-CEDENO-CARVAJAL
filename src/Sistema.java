import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    // ================================
    // Implementar clase ManejoArchivos para leer los.txt
    // ======================================
    public void cargarUsuarios() {
        ArrayList<String> list_usuarios = ManejoArchivos.LeeFichero("usuarios.txt");
        ArrayList<String> list_aficionados = ManejoArchivos.LeeFichero("aficionados.txt");
        ArrayList<String> list_organizadores = ManejoArchivos.LeeFichero("organizadores.txt");
        // Obtención de datos usuario
        for (String dato : list_usuarios) {
            String[] dato_usuario = dato.split("\\|");
            String codigoUnico = dato_usuario[0];
            String cedula = dato_usuario[1];
            String nombre = dato_usuario[2];
            String apellido = dato_usuario[3];
            String usuario = dato_usuario[4];
            String contrasena = dato_usuario[5];
            String correo = dato_usuario[6];
            String rol = dato_usuario[7];

            // Crear usuario Aficionado
            if (rol.equals("A")) {
                for (String linea : list_aficionados) {
                    String[] datos_aficionados = linea.split("\\|");
                    // datos aficionado
                    String celular = datos_aficionados[4];
                    String paisFavorito = datos_aficionados[5];
                    if (datos_aficionados[0].equals(codigoUnico)) {
                        Aficionado a = new Aficionado(
                                codigoUnico,
                                cedula,
                                nombre,
                                apellido,
                                usuario,
                                contrasena,
                                correo,
                                celular,
                                paisFavorito);
                        usuarios.add(a);
                        break;
                    }
                }
                // crear usuario Organizador
            } else if (rol.equals("O")) {
                for (String linea : list_organizadores) {
                    String[] datos_organizador = linea.split("\\|");
                    // datos organizador
                    String empresa = datos_organizador[4];
                    String cargo = datos_organizador[5];
                    if (codigoUnico.equals(datos_organizador[0])) {
                        Organizador o = new Organizador(
                                codigoUnico,
                                cedula,
                                nombre,
                                apellido,
                                usuario,
                                contrasena,
                                correo,
                                empresa,
                                cargo);
                        usuarios.add(o);
                        break;
                    }
                }
            }

        }

    }

    public void cargarPartidos() throws ParseException {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        ArrayList<String> list_partidos = ManejoArchivos.LeeFichero("partidos.txt");
        for (String datos : list_partidos) {
            String[] datos_partido = datos.split("\\|");
            // Obtencion datos de partido
            String codigo = datos_partido[0];
            String equipoLocal = datos_partido[1];
            String equipoVisitante = datos_partido[2];
            Date fecha = formatoFecha.parse(datos_partido[3]);
            String estadio = datos_partido[4];
            String ciudad = datos_partido[5];
            int capacidad = Integer.parseInt(datos_partido[6]);
            int capacidadGeneral = Integer.parseInt(datos_partido[7]);
            int capacidadPreferencial = Integer.parseInt(datos_partido[8]);
            int capacidadVip = Integer.parseInt(datos_partido[9]);
            String fase = datos_partido[10];

            Partido p = new Partido(
                    codigo,
                    equipoLocal,
                    equipoVisitante,
                    fecha,
                    estadio,
                    ciudad,
                    fase,
                    capacidad,
                    capacidadGeneral,
                    capacidadPreferencial,
                    capacidadVip,
                    0.0,
                    0.0,
                    0.0);
            partidos.add(p);
        }

    }

    public void cargarKits() {
        ArrayList<String> list_kits = new ArrayList<>();
        // Obtencion Datos Kits
        for (String datos : list_kits) {
            String[] datos_kits = datos.split("\\|");
            String codigo = datos_kits[0];
            String nombre = datos_kits[1];
            String descripcion = datos_kits[2];
            Double precio = Double.parseDouble(datos_kits[4]);
            int kitsDisponibles = Integer.parseInt(datos_kits[5]);

            /**
             * Se crea un ArrayList para almacenar los partidos que tendrá un Kit
             * 
             */
            ArrayList<Partido> partidosKits = new ArrayList<>();

            // Obtención de los partidos del Kit
            for (String c : datos_kits[2].split(",")) {
                for (Partido p : partidos) {
                    if (p.getCodigoPartido().equals(c)) {
                        partidosKits.add(p);
                    }
                }

            }
            Kit k = new Kit(
                    codigo,
                    nombre,
                    descripcion,
                    precio,
                    kitsDisponibles,
                    partidosKits);

            kits.add(k);
        }

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
        }
        if (!autenticado) {
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }
}

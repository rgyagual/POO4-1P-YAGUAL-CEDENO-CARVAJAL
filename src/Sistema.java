import java.util.ArrayList;
import java.util.Scanner;

public class Sistema {

    private ArrayList<Usuario> usuarios;
    private ArrayList<Partido> partidos;
    private ArrayList<Kit> kits;
    private ArrayList<Compra> compras;

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

    public void iniciarSesion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=====INICIO DE SESIÓN=====");
        System.out.print("Usuario: ");
        String usuario = sc.nextLine();
        System.out.print("Contraseña: ");
        String contraseña = sc.nextLine();

        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario) && u.getContraseña().equals(contraseña)) {
                System.out.println("Usuario autenticado correctamente.");
                if (u instanceof Aficionado) {
                    Aficionado af = (Aficionado) u;
                    System.out.println("Rol detectado: AFICIONADO");
                    System.out.println("\nBienvenida, " + af.getNombres() + " " + af.getApellidos());
                    System.out.println("Celular registrado: " + af.getCelular());
                    System.out.print("¿Este número de celular es correcto? (S/N): ");
                    String validarNumero = sc.nextLine();
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
                                for(Partido p: partidos){
                                    for(int i = 1; i < partidos.size()+1;i++){
                                        System.out.println(i+". "+p);
                                    }
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
                } else if (u instanceof Organizador) {
                    Organizador og = (Organizador) u;
                    System.out.println("Rol detectado: ORGANIZADOR");
                    System.out.println("Bienvenido, " + og.getNombres() + " " + og.getApellidos());
                    System.out.println("Empresa asignada: " + og.getEmpresa());
                    System.out.print("Esta empresa es correcta(S/N): ");
                    String validarEmpresa = sc.nextLine();
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
            }else{
                System.out.println("Usuario o contraseña incorrectos.");
            }
        }
    }
}

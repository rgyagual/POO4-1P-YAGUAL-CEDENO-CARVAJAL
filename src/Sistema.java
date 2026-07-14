import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Scanner;

/**Librerias necesarias para enviar un email */
import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

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
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    /** Lista de partidos registrados en el sistema (txt) */
    private ArrayList<Partido> partidos = new ArrayList<>();
    /** Lista de Kits registrados en el sistema (txt) */
    private ArrayList<Kit> kits = new ArrayList<>();
    /** Lista de Compras Totales realizadas */
    private ArrayList<Compra> compras = new ArrayList<>();
    //
    public static final SimpleDateFormat FORMATO_FECHA = new SimpleDateFormat("yyyy-MM-dd");
    /** Scanner para solicitar datos al usuario */
    Scanner sc = new Scanner(System.in);
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
    /**
     * Carga los usuarios registrados desde los archivos de texto
     * y crea los objetos correspondientes según su rol.
     */
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

            // Crea el objeto Aficionado utilizando la información de ambos archivos.
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
                // Crea el objeto Organizador utilizando la información de ambos archivos.
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

    /**
     * Carga la información de los partidos desde el archivo de texto
     * y crea los objetos Partido correspondientes.
     * 
     */
    public void cargarPartidos() {
        ArrayList<String> list_partidos = ManejoArchivos.LeeFichero("partidos.txt");
        for (String datos : list_partidos) {
            String[] datos_partido = datos.split("\\|");
            // Obtencion datos de partido
            String codigo = datos_partido[0];
            String equipoLocal = datos_partido[1];
            String equipoVisitante = datos_partido[2];
            Date fecha = null;
            // Se utiliza try-catch para manejar la Excepcion ParseException, debido a que
            // es obligatorio manejar la excepcion al usar DateFormat.parse()
            try {
                fecha = FORMATO_FECHA.parse(datos_partido[3]);
            } catch (ParseException e) {
                System.out.println("Error al convertir la fecha");
            }

            String estadio = datos_partido[4];
            String ciudad = datos_partido[5];
            int capacidad = Integer.parseInt(datos_partido[6]);
            int capacidadGeneral = Integer.parseInt(datos_partido[7]);
            int capacidadPreferencial = Integer.parseInt(datos_partido[8]);
            int capacidadVip = Integer.parseInt(datos_partido[9]);
            String fase = datos_partido[10];

            Partido p = new Partido(codigo, equipoLocal,
                    equipoVisitante,
                    fecha,
                    estadio,
                    ciudad,
                    fase,
                    capacidad,
                    capacidadGeneral,
                    capacidadPreferencial,
                    capacidadVip);
            partidos.add(p);
        }

    }

    /**
     * Carga los kits disponibles desde el archivo de texto y
     * relaciona cada kit con los partidos que contiene.
     */
    public void cargarKits() {
        ArrayList<String> list_kits = ManejoArchivos.LeeFichero("kits.txt");
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
            for (String c : datos_kits[3].split(",")) {
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
     * Método implementado para enviar un correo real a través de Gmail
     * 
     * @param destinatario  Quien recibe el correo
     * @param asunto        Asunto del correo
     * @param mensajeCorreo Mensaje a enviar
     */
    private void enviarCorreo(String destinatario,
            String asunto,
            String mensajeCorreo) {

        /** Se introduce el correo del remitente */
        final String remitente = "ventasentradasmundial@gmail.com";
        final String clave = "nhmm ufew bqac fzwe";

        /** Se conecta con el servidor de Gmail */
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        /** Se inicia sesión en Gmail usando la contraseña de app */
        Session session = Session.getInstance(props,
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(remitente, clave);
                    }
                });
        /** Se introduce la creación de un mensaje */
        try {
            Message mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(remitente));
            mensaje.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(destinatario));
            mensaje.setSubject(asunto);
            mensaje.setText(mensajeCorreo);
            Transport.send(mensaje);
            System.out.println("Correo enviado.");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * Se busca notificar cada que se realiza una compra de entradas a un partido
     * 
     * @param af Aficionado comprador
     * @param c  Compra realizada por el aficionado
     */
    private void notificar(Aficionado af, Compra c) {
        String partidoCompra = "";
        for (Partido p : partidos) {
            if (p.getCodigoPartido().equals(c.getCodigoReferencia())) {
                partidoCompra = p.getEquipoLocal() + " vs " + p.getEquipoVisitante();
                break;
            }
        }
        String mensaje = "Estimado/a " + af.nombres + " " + af.apellidos +
                "\nSu compra ha sido registrada exitosamente con el código " + c.getCodigoCompra() + " el día "
                + FORMATO_FECHA.format(c.getFechaCompra()) +
                ".\nPartido: " + partidoCompra + "\nCódigo del Partido: " + c.getCodigoReferencia() +
                "\nZona: " + c.getZonaCompra() +
                "\nCantidad: " + c.getCantidad() +
                "\nValor Pagado: $" + c.getvalorPagado() +
                "\nGracias por adquirir sus entradas para el Mundial. Recuerde conservar el código de compra para futuras\nconsultas.";
        enviarCorreo(af.correo, "Compra de entradas realizada", mensaje);
    }

    /**
     * Se busca notificar cada que se realiza una compra de un kit de entradas a un
     * partido
     * 
     * @param af         Aficionado comprador
     * @param kitCoompra Kit comprado por el aficionado
     */
    private void notificar(Aficionado af, Kit kitCompra, Compra c) {
        String partidoCompra = "";
        String codigoPartido = "";
        for (Kit k : kits) {

            if (kitCompra.getCodigoKit().equals(k.getCodigoKit())) {
                for (Partido p : k.getPartidosIncluidos()) {
                    partidoCompra = p.getEquipoLocal() + " vs " + p.getEquipoVisitante();
                    codigoPartido = p.getCodigoPartido();
                }
            }
        }
        String mensaje = "Estimado/a " + af.nombres + " " + af.apellidos +
                "\n\nSu compra ha sido registrada exitosamente con el código " + c.getCodigoCompra() + " el día "
                + FORMATO_FECHA.format(c.getFechaCompra()) +
                ".\n\nPartido: " + partidoCompra +
                "\nCódigo del partido: " + codigoPartido +
                "\nDescripcion: " + kitCompra.getDescripcion() +
                "\nCantidad: " + c.getCantidad() +
                "\nValor Pagado " + c.getvalorPagado();
        enviarCorreo(af.correo, "Compra de Kit realizado", mensaje);
    };

    /**
     * Se busca notificar cuando se genere un reporte de ventas totales
     * 
     * @param o Organizador que genera el reporte
     */
    private void notificar(Organizador o) {
        int totalEntradas = 0;
        int totalKits = 0;
        int totalCompras = compras.size();
        double totalRecaudado = 0;

        for (Compra c : compras) {
            totalRecaudado += c.getvalorPagado();

            if (c.getTipo().equals("ENTRADA")) {
                totalEntradas += c.getCantidad();
            } else if (c.getTipo().equals("KIT")) {
                totalKits += c.getCantidad();
            }
        }

        String mensaje = "Estimado/a " + o.nombres + " " + o.apellidos +
                ",\nSe ha generado el reporte de compras del sistema." +
                "\nFecha de generación del reporte: " + FORMATO_FECHA.format(new Date()) +
                "\nTotal de compras registradas: " + totalCompras +
                "\nTotal de compras de entradas individuales: " + totalEntradas +
                "\nTotal de compras Kits: " + totalKits +
                "\nMonto total recaudado: $" + totalRecaudado;
        enviarCorreo(o.correo, "Reporte de compras registradas", mensaje);
    }

    /** Menu a mostrar para el Aficionado */
    private void menuAficionado() {
        System.out.println("=========================");
        System.out.println("Menú de Aficionado: ");
        System.out.println("1. Consultar partidos");
        System.out.println("2. Comprar entrada");
        System.out.println("3. Comprar Kit de entradas");
        System.out.println("4. Consultar entradas");
        System.out.println("5. Salir");
        System.out.println("Seleccione una opción: ");
    }

    /** Menu a mostrar para el Organizador */
    private void menuOrganizador() {
        System.out.println("=========================");
        System.out.println("Menú de Organizador:");
        System.out.println("1. Consultar entradas");
        System.out.println("2. Generar Reporte");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");

    }

    /** Mensajes al mostrar cuando suceda un error de Autenticación */
    private void errorAutenticacion() {
        System.out.println("Verificación fallida.");
        System.out.println("Por motivos de seguridad se cerrará la sesión");
        System.out.println("\nSaliendo del sistema...");
    }

    /** Método que muestra todos los partidos disponiles y su información */
    private void consultarPartidos() {
        System.out.println("Partidos encontrados: ");
        for (int i = 0; i < partidos.size(); i++) {
            System.out.println((i + 1) + ". " + partidos.get(i));
        }
    }

    /**
     * Implementa la compra de entradas, solicitando los datos necesarios del
     * usuario y genera la notificación por correo
     * 
     * @param af Usuario aficionado que realizará la compra
     */
    private void comprarEntrada(Aficionado af) {
        System.out.println("Ingrese código del partido: ");
        String codigoPartido = sc.nextLine();
        // Partido del que se comprará entradas
        Partido partidoCompra = null;
        for (Partido p : partidos) {
            if (p.getCodigoPartido().equals(codigoPartido)) {
                partidoCompra = p;
                break;
            }
        }
        System.out.println("Elija la zona\na. GENERAL\nb. PREFERENCIAL\nc. VIP: ");
        System.out.print("Opcion: ");
        String zonaElegida = sc.nextLine();
        Zona zona;
        switch (zonaElegida) {
            case "a":
                zona = Zona.GENERAL;
                break;
            case "b":
                zona = Zona.PREFERENCIAL;
                break;
            case "c":
                zona = Zona.VIP;
                break;
            default:
                System.out.println("Opcion inválida.");
                return;
        }
        System.out.println("Ingresar cantidad de entradas: ");
        int cantidadEntradas = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingresar número de tarjeta: ");
        String numTarjeta = sc.nextLine();
        Compra c = af.comprar(partidoCompra,
                zona,
                cantidadEntradas,
                numTarjeta);
        notificar(af, c);
    }

    /**
     * Implementa la compra de Kits, solicitando los datos necesarios del
     * usuario aficionado y genera la notificación por correo
     * 
     * @param af Usuario aficionado que realizará la compra
     */
    private void comprarKit(Aficionado af) {
        // Mostrar Kits disponibles
        System.out.println("======== KITS DISPONIBLES ========");
        for (int i = 0; i < kits.size(); i++) {
            System.out.println((i + 1) + ". " + kits.get(i));
        }
        System.out.print("Ingresa el número de kit a comprar: ");
        int kitElegido = sc.nextInt();
        sc.nextLine();
        Kit kitCompra = kits.get(kitElegido - 1);
        System.out.print("Ingrese su número de Tarjeta: ");
        String numTarjeta = sc.nextLine();
        Compra compraKit = af.comprar(kitCompra, numTarjeta);
        notificar(af, kitCompra, compraKit);
    }

    private void generarReporte(Organizador o) {
        o.generarReporte(compras);
        notificar(o);

    }

    /**
     * Permite a un usuario iniciar sesión en el sistema verificando
     * sus credenciales y mostrando el menú correspondiente según su rol.
     * Si la autenticación falla o la verificación de identidad no es
     * confirmada, la sesión se cierra.
     */
    public void iniciarSesion() {

        // Solicitud de credenciales al usuario
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
                        int opcionElegida;
                        do {
                            menuAficionado();
                            opcionElegida = sc.nextInt();
                            sc.nextLine();
                            switch (opcionElegida) {
                                case 1:
                                    consultarPartidos();
                                    break;
                                case 2:
                                    comprarEntrada(af);
                                    break;
                                case 3:
                                    comprarKit(af);
                                    break;
                                case 4:
                                    af.consultarEntradas(af.getHistorialCompras());
                                    break;
                                case 5:
                                    System.out.println("Saliendo del sistema...");
                                    return;
                                default:
                                    System.out.println("Opción elegida inválida");
                                    break;
                            }
                        } while (opcionElegida != 5);

                    } else {
                        errorAutenticacion();
                        break;
                    }
                    return;
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
                        int opcionElegida;
                        do {
                            menuOrganizador();
                            opcionElegida = sc.nextInt();
                            sc.nextLine();
                            switch (opcionElegida) {
                                case 1:
                                    og.consultarEntradas(compras);
                                    break;
                                case 2:
                                    generarReporte(og);
                                    break;
                                case 3:
                                    System.out.println("Saliendo del sistema...");
                                    return;

                                default:
                                    System.out.println("Opción elegida inválida");
                                    break;
                            }
                        } while (opcionElegida != 3);
                    } else {
                        errorAutenticacion();
                    }
                    return;
                }
            }
        }
        if (!autenticado) {
            System.out.println("Usuario o contraseña incorrectos.");
        }
    }

    public void cerrarSistema() {
        sc.close();
    }
}

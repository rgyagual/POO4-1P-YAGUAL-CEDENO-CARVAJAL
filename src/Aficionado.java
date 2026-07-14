import java.util.ArrayList;
import java.util.Date;

/**
 * Representa un usuario de tipo Aficionado dentro del sistema.
 * Hereda los atributos y métodos de la clase Usuario, y agrega
 * atributos propios como celular, PaisFasvorito e historialCompras.
 * Además, gestiona el proceso de compra de entradas y compra de kits,
 * y permite consultar entradas.
 * 
 * @author Yagual-Cedeño-Carvajal
 * 
 */
public class Aficionado extends Usuario {
    // ====================================
    // ATRIBUTOS
    // ====================================
    /** Número de celular del aficionado. */
    private String celular;
    /** País favorito del aficionado. */
    private String PaisFavorito;
    /** Historial de compras realizadas por el aficionado. */
    private ArrayList<Compra> historialCompras;

    // ====================
    // CONSTRUCTOR
    // ====================
    /**
     * Crea un nuevo aficionado.
     * 
     * @param codigoUnico  Código único del aficionado.
     * @param cedula       Número de cédula del aficionado.
     * @param nombres      Nombre del aficionado.
     * @param apellidos    Apellido del aficionado.
     * @param usuario      Nombre de usuario para inicio de sesión.
     * @param contraseña   Contraseña del aficionado.
     * @param correo       Correo electrónico del aficionado.
     * @param celular      Número de celular del aficionado.
     * @param paisFavorito País favorito del aficionado.
     */
    public Aficionado(String codigoUnico, String cedula,
            String nombres, String apellidos,
            String usuario, String contraseña,
            String correo, String celular,
            String paisFavorito) {
        super(codigoUnico, cedula, nombres,
                apellidos, usuario, contraseña,
                correo);

        this.celular = celular;
        this.PaisFavorito = paisFavorito;
        historialCompras = new ArrayList<>();
    }

    // ===================================
    // Getters y Setters
    // ===================================
    /**
     * Devuelve el número de celular del aficionado.
     * 
     * @return Número de celular del aficionado.
     */
    public String getCelular() {
        return celular;
    }

    /**
     * Devuelve el país favorito del aficionado.
     * 
     * @return País favorito del aficionado.
     */
    public String getPaisFavoito() {
        return PaisFavorito;
    }

    /**
     * Devuelve el historial de compras del aficionado.
     * 
     * @return Lista del historial de compras del aficionado.
     */
    public ArrayList<Compra> getHistorialCompras() {
        return historialCompras;
    }

    /**
     * Establecer nuevo número de celular del aficionado.
     * 
     * @param celular Nuevo número de celular del aficionado.
     */
    public void setcelular(String celular) {
        this.celular = celular;
    }

    /**
     * Establecer el país favorito del aficionado.
     * 
     * @param PaisFavorito País favorito del aficionado.
     */
    public void setPaisFavorito(String PaisFavorito) {
        this.PaisFavorito = PaisFavorito;
    }

    /**
     * Método sobrescrito que muestra todas las compras
     * realizadas únicamente por ese aficionado.
     * 
     * @param compras Lista de compras registradas en el sistema.
     */
    @Override
    public void consultarEntradas(ArrayList<Compra> compras) {
        System.out.println("COMPRAS REALIZADAS");
        for (Compra c : compras) {
            if (c.getCodigoAficionado().equals(this.getCodigoUnico())) {
                System.out.println(c.toString());
            }
        }
    }

    /**
     * Método sobrecargado para realizar la compra de entradas,
     * para un partido, zona y cantidad específica.
     * Valida el stock de entradas en la zona elegida, calcula y
     * muestra el total a pagar, simula el pago, crea y registra la
     * compra, y actualiza la disponibilidad de entradas.
     *
     * @param partido       Partido para el que se compran las entradas.
     * @param zona          Zona elegida.
     * @param cantidad      Cantidad de entradas.
     * @param numeroTarjeta Número de tarjeta del aficionado.
     * @return La nueva compra realizada o null si no hay entradas disponibles para
     *         esa zona.
     */
    public Compra comprar(Partido partido, Zona zona, int cantidad, String numeroTarjeta) {
        int entradasDisponibles = 0;

        switch (zona) {
            case GENERAL:
                entradasDisponibles = partido.getEntradaGeneral();

                break;
            case PREFERENCIAL:
                entradasDisponibles = partido.getEntradaPreferencial();

                break;
            case VIP:
                entradasDisponibles = partido.getEntradaVip();

                break;
        }
        Compra compraNueva = null;
        if (cantidad > entradasDisponibles || cantidad <= 0) {
            System.out.println("No hay entradas disponibles para esa zona");
        } else {
            double totalEntrada = PrecioMundial.Precios(zona, partido.getFase());
            double totalPagar = cantidad * totalEntrada;
            System.out.println("Total a pagar: " + totalPagar);
            System.out.println("Pago exitoso");

            compraNueva = new Compra("Entrada",
                    partido.getCodigoPartido(),
                    new Date(),
                    cantidad,
                    totalPagar,
                    codigoUnico,
                    zona);
            compraNueva.agregarCompraTxt();
            int entradasActualizadas = entradasDisponibles - cantidad;
            switch (zona) {
                case GENERAL:
                    partido.setEntradaGeneral(entradasActualizadas);
                    break;
                case PREFERENCIAL:
                    partido.setEntradaPreferencial(entradasActualizadas);
                    break;
                case VIP:
                    partido.setEntradaVip(entradasActualizadas);
                    break;
            }
        }
        return compraNueva;
    }

    /**
     * Método sobrecargado para realizar la compra de un kit de
     * entradas predefinido.
     * Valida la disponibilidad del kit elegido, calcula y muestra
     * el total a pagar, crea y registra la compra.
     * 
     * @param kit           Kit de entradas que se desea comprar.
     * @param numeroTarjeta Número de tarjeta del aficionado.
     * @return La nueva compra realizada o null si no hay kits disponibles.
     */
    public Compra comprar(Kit kit, String numeroTarjeta) {
        Compra compraNueva = null;
        if (kit.getCantidadDisponible() <= 0) {
            System.out.println("No hay kits disponibles");
        } else {
            double totalPagar = kit.getPrecioKit();
            System.out.println("Total a pagar: " + totalPagar);
            compraNueva = new Compra("Kit", kit.getCodigoKit(), new Date(),
                    1, totalPagar, codigoUnico, null);
            compraNueva.agregarCompraTxt();
        }
        return compraNueva;
    }
}
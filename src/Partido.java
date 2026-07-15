import java.util.Date;

/**
 * Representa un Partido del Mundial
 * 
 * @author Yagual-Cedeño-Carvajal
 */
public class Partido {
    // ====================================
    // ATRIBUTOS
    // ====================================
    /** Código del partido. */
    private String codigoPartido;
    /** Nombre del equipo local. */
    private String equipoLocal;
    /** Nombre del equipo visitante. */
    private String equipoVisitante;
    /** Fecha del partido. */
    private Date fechaPartido;
    /** Nombre del estadio. */
    private String estadio;
    /** Nombre de la ciudad. */
    private String ciudad;
    /** Fase del partido. */
    private String faseStr;
    /** Fase del partido en Enum. */
    private FasesMundial faseEnum;
    /** Capacidad del estadio. */
    private int capacidad;
    /** Entradas disponibles en general. */
    private int entradaGeneral;
    /** Entradas disponibles en preferencial. */
    private int entradaPreferencial;
    /** Entradas disponibles en VIP. */
    private int entradaVip;

    // ====================
    // CONSTRUCTOR
    // ====================
    /**
     * Crea un nuevo partido.
     * 
     * @param codigoPartido       Código del partido.
     * @param equipoLocal         Nombre del equipo local.
     * @param equipoVisitante     Nombre del equipo visitante.
     * @param fechaPartido        Fecha del partido.
     * @param estadio             Nombre del estadio.
     * @param ciudad              Nombre de la ciudad.
     * @param faseStr             Fase del partido
     * @param capacidad           Capacidad del estadio.
     * @param entradaGeneral      Entradas disponibles en general.
     * @param entradaPreferencial Entradas disponibles en preferencial.
     * @param entradaVip          Entradas disponibles en Vip.
     */
    public Partido(String codigoPartido, String equipoLocal,
            String equipoVisitante, Date fechaPartido,
            String estadio, String ciudad,
            String faseStr, int capacidad,
            int entradaGeneral, int entradaPreferencial,
            int entradaVip) {

        this.codigoPartido = codigoPartido;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fechaPartido = fechaPartido;
        this.estadio = estadio;
        this.ciudad = ciudad;
        this.capacidad = capacidad;
        this.entradaGeneral = entradaGeneral;
        this.entradaPreferencial = entradaPreferencial;
        this.entradaVip = entradaVip;
        this.faseStr = faseStr;
        definirFaseEnum(faseStr);

    }

    // ===================================
    // Getters y Setters
    // ===================================
    /**
     * Devuelve el código del partido
     *
     * @return codigo del partido
     */
    public String getCodigoPartido() {
        return codigoPartido;
    }

    /**
     * Establece o actualiza el código del partido
     * 
     * @param codigoPartido código de partido a asignar
     */
    public void setCodigoPartido(String codigoPartido) {
        this.codigoPartido = codigoPartido;
    }

    /**
     * Devuelve el nombre del equipo local
     *
     * @return equipo local
     */
    public String getEquipoLocal() {
        return equipoLocal;
    }

    /**
     * Establece o actualiza el nombre del equipo local
     * 
     * @param equipoLocal equipo local a asignar
     */
    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    /**
     * Devuelve el nombre del equipo visitante
     *
     * @return equipo visitante
     */
    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    /**
     * Establece o actualiza el nombre del equipo visitante
     * 
     * @param equipoVisitante equipo visitante a asignar
     */
    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    /**
     * Devuelve la fecha programada para el partido
     *
     * @return fecha del partido
     */
    public Date getFechaPartido() {
        return fechaPartido;
    }

    /**
     * Establece o actualiza la fecha programada para el partido
     * 
     * @param fechaPartido fecha del partido a asignar
     */
    public void setFechaPartido(Date fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    /**
     * Devuelve el nombre del estadio donde se juega el partido
     *
     * @return estadio del partido
     */
    public String getEstadio() {
        return estadio;
    }

    /**
     * Establece o actualiza el nombre del estadio donde se juega el partido
     * 
     * @param estadio estadio a asignar
     */
    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    /**
     * Devuelve la ciudad sede donde se llevará a cabo el partido
     *
     * @return ciudad del partido
     */
    public String getCiudad() {
        return ciudad;
    }

    /**
     * Establece o actualiza la ciudad sede donde se llevará a cabo el partido
     * 
     * @param ciudad ciudad a asignar
     */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Devuelve la representación en texto de la fase del mundial
     *
     * @return fase en formato texto
     */
    public String getFaseStr() {
        return faseStr;
    }

    /**
     * Establece o actualiza la representación en texto de la fase del mundial
     * 
     * @param faseStr fase en formato texto a asignar
     */
    public void setFaseStr(String faseStr) {
        this.faseStr = faseStr;
    }

    /**
     * Devuelve la fase del mundial como tipo Enum
     *
     * @return fase como enum FasesMundial
     */
    public FasesMundial getFaseEnum() {
        return faseEnum;
    }

    /**
     * Establece o actualiza la fase del mundial como tipo Enum
     * 
     * @param faseEnum fase como enum FasesMundial a asignar
     */
    public void setFaseEnum(FasesMundial faseEnum) {
        this.faseEnum = faseEnum;
    }

    /**
     * Devuelve la capacidad total de espectadores del partido
     *
     * @return capacidad de espectadores
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Establece o actualiza la capacidad total de espectadores del partido
     * 
     * @param capacidad capacidad de espectadores a asignar
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Devuelve la cantidad de entradas disponibles para la zona general
     *
     * @return cantidad de entradas generales
     */
    public int getEntradaGeneral() {
        return entradaGeneral;
    }

    /**
     * Establece o actualiza la cantidad de entradas disponibles para la zona
     * general
     * 
     * @param entradaGeneral cantidad de entradas generales a asignar
     */
    public void setEntradaGeneral(int entradaGeneral) {
        this.entradaGeneral = entradaGeneral;
    }

    /**
     * Devuelve la cantidad de entradas disponibles para la zona preferencial
     *
     * @return cantidad de entradas preferenciales
     */
    public int getEntradaPreferencial() {
        return entradaPreferencial;
    }

    /**
     * Establece o actualiza la cantidad de entradas disponibles para la zona
     * preferencial
     * 
     * @param entradaPreferencial cantidad de entradas preferenciales a asignar
     */
    public void setEntradaPreferencial(int entradaPreferencial) {
        this.entradaPreferencial = entradaPreferencial;
    }

    /**
     * Devuelve la cantidad de entradas disponibles para la zona VIP
     *
     * @return cantidad de entradas VIP
     */
    public int getEntradaVip() {
        return entradaVip;
    }

    /**
     * Establece o actualiza la cantidad de entradas disponibles para la zona VIP
     * 
     * @param entradaVip cantidad de entradas VIP a asignar
     */
    public void setEntradaVip(int entradaVip) {
        this.entradaVip = entradaVip;
    }

    /**
     * Calcula y devuelve el precio de una entrada basándose en la zona del estadio
     * y la fase del mundial correspondiente.
     * 
     * @param zona zona solicitada
     * @param fase fase del Mundial
     * @return precio del ticket
     */
    public double precio(Zona zona, FasesMundial fase) {
        switch (fase) {
            case GRUPOS:
                switch (zona) {
                    case VIP:
                        return 250.0;
                    case PREFERENCIAL:
                        return 170.0;
                    case GENERAL:
                        return 90.0;
                }
            case OCTAVOS:
                switch (zona) {
                    case VIP:
                        return 350.0;
                    case PREFERENCIAL:
                        return 270.0;
                    case GENERAL:
                        return 150.0;
                }
            case CUARTOS:
                switch (zona) {
                    case VIP:
                        return 500.0;
                    case PREFERENCIAL:
                        return 425.0;
                    case GENERAL:
                        return 300.0;
                }
            case SEMIFINAL:
                switch (zona) {
                    case VIP:
                        return 700.0;
                    case PREFERENCIAL:
                        return 575.0;
                    case GENERAL:
                        return 450.0;
                }
            case TERCER_LUGAR:
                switch (zona) {
                    case VIP:
                        return 600.0;
                    case PREFERENCIAL:
                        return 500.0;
                    case GENERAL:
                        return 380.0;
                }
            case FINAL:
                switch (zona) {
                    case VIP:
                        return 900.0;
                    case PREFERENCIAL:
                        return 750.0;
                    case GENERAL:
                        return 525.0;

                }
            default:
                return 0.0;
        }
    }

    /**
     * Define la equivalencia de un texto a su correspondiente constante
     * del tipo Enum FasesMundial
     * 
     * @param faseStr fase del Mundial del tipo String
     */
    private void definirFaseEnum(String faseStr) {
        switch (faseStr) {
            case "Fase de grupos":
                faseEnum = FasesMundial.GRUPOS;
                break;
            case "Octavos de final":
                faseEnum = FasesMundial.OCTAVOS;
                break;
            case "Cuartos de final":
                faseEnum = FasesMundial.CUARTOS;
                break;
            case "Semifinal":
                faseEnum = FasesMundial.SEMIFINAL;
                break;
            case "Tercer lugar":
                faseEnum = FasesMundial.TERCER_LUGAR;
                break;
            case "Final":
                faseEnum = FasesMundial.FINAL;
                break;
            default:
                faseEnum = null;
                break;
        }
    }

    /**
     * Devuelve una representación en texto con la información del partido.
     * 
     * @return Cadena con datos del partido.
     */
    @Override
    public String toString() {
        String partido = equipoLocal + " vs " + equipoVisitante;
        String infoZonas = String.format("- %-13s | Disponibles: %7d | Precio: %.2f%n", Zona.GENERAL, entradaGeneral,
                precio(Zona.GENERAL, faseEnum)) +
                String.format("- %-13s | Disponibles: %7d | Precio: %.2f%n", Zona.PREFERENCIAL, entradaPreferencial,
                        precio(Zona.PREFERENCIAL, faseEnum))
                +
                String.format("- %-13s | Disponibles: %7d | Precio: %.2f%n", Zona.VIP, entradaVip,
                        precio(Zona.VIP, faseEnum));

        return "Código: " + codigoPartido +
                "\nPartido: " + partido +
                "\nFecha: " + Sistema.FORMATO_FECHA.format(fechaPartido) +
                "\nEstadio: " + estadio +
                "\nCiudad: " + ciudad +
                "\nFase: " + faseStr +
                "\nZonas Disponibles: " + "\n" + infoZonas +
                "\n--------------------------------------------------";
    }
}

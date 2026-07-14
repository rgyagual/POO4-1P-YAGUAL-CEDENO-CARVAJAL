import java.util.Date;

/**
 * Representa
 * Partido
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
    public String getCodigoPartido() {
        return codigoPartido;
    }

    public void setCodigoPartido(String codigoPartido) {
        this.codigoPartido = codigoPartido;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public Date getFechaPartido() {
        return fechaPartido;
    }

    public void setFechaPartido(Date fechaPartido) {
        this.fechaPartido = fechaPartido;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFaseStr() {
        return faseStr;
    }

    public void setFaseStr(String faseStr) {
        this.faseStr = faseStr;
    }

    public FasesMundial getFaseEnum() {
        return faseEnum;
    }

    public void setFaseEnum(FasesMundial faseEnum) {
        this.faseEnum = faseEnum;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getEntradaGeneral() {
        return entradaGeneral;
    }

    public void setEntradaGeneral(int entradaGeneral) {
        this.entradaGeneral = entradaGeneral;
    }

    public int getEntradaPreferencial() {
        return entradaPreferencial;
    }

    public void setEntradaPreferencial(int entradaPreferencial) {
        this.entradaPreferencial = entradaPreferencial;
    }

    public int getEntradaVip() {
        return entradaVip;
    }

    public void setEntradaVip(int entradaVip) {
        this.entradaVip = entradaVip;
    }

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
                PrecioMundial.Precios(Zona.GENERAL, faseEnum)) +
                String.format("- %-13s | Disponibles: %7d | Precio: %.2f%n", Zona.PREFERENCIAL, entradaPreferencial,
                        PrecioMundial.Precios(Zona.PREFERENCIAL, faseEnum))
                +
                String.format("- %-13s | Disponibles: %7d | Precio: %.2f%n", Zona.VIP, entradaVip,
                        PrecioMundial.Precios(Zona.VIP, faseEnum));

        return "Código: " + codigoPartido +
                "\nPartido: " + partido +
                "\nFecha: " + fechaPartido +
                "\nEstadio: " + estadio +
                "\nCiudad: " + ciudad +
                "\nFase: " + faseStr +
                "\nZonas Disponibles: " + "\n" + infoZonas +
                "\n--------------------------------------------------";
    }
}

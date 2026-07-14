import java.util.Date;

public class Partido {

    private String codigoPartido;
    private String equipoLocal;
    private String equipoVisitante;
    private Date fechaPartido;
    private String estadio;
    private String ciudad;
    private String faseEnum;
    private FasesMundial fase;
    private int capacidad;
    private int entradaGeneral;
    private int entradaPreferencial;
    private int entradaVip;

    public Partido(String codigoPartido, String equipoLocal,
            String equipoVisitante, Date fechaPartido,
            String estadio, String ciudad, 
            String faseEnum, int capacidad,
            int entradaGeneral, int entradaPreferencial,
            int entradaVip, double precioGeneral,
            double precioPreferencial, double precioVip) {

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
        this.faseEnum = faseEnum;
        switch (faseEnum){
            case "Fase de grupos":
                fase=FasesMundial.GRUPOS;                
                break;
            case "Octavos de final":
                fase=FasesMundial.OCTAVOS;
                break;
            case "Cuartos de final":
                fase=FasesMundial.CUARTOS;
                break;
            case "Semifinal":
                fase=FasesMundial.SEMIFINAL;
                break;
            case "Final":
                fase=FasesMundial.FINAL;
                break;        
            default:
                fase=null;
                break;
        }
    }

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

    public String getFaseEnum(){
        return faseEnum;
    }

    public void setFaseEnum(String faseEnum){
        this.faseEnum=faseEnum;
        switch (faseEnum){
            case "Fase de grupos":
                fase=FasesMundial.GRUPOS;                
                break;
            case "Octavos de final":
                fase=FasesMundial.OCTAVOS;
                break;
            case "Cuartos de final":
                fase=FasesMundial.CUARTOS;
                break;
            case "Semifinal":
                fase=FasesMundial.SEMIFINAL;
                break;
            case "Final":
                fase=FasesMundial.FINAL;
                break;        
            default:
                fase=null;
                break;
        }
    }

    public FasesMundial getFase() {
        return fase;
    }

    public void setFase(FasesMundial fase) {
        this.fase = fase;
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

    @Override
    public String toString() {
        String partido = equipoLocal + " vs " + equipoVisitante;
        String infoZonas = String.format("- %-13s | Disponibles: %7d | Precio: %.2f%n", Zona.GENERAL, entradaGeneral,
                PrecioMundial.Precios(Zona.GENERAL, fase)) +
                String.format("- %-13s | Disponibles: %7d | Precio: %.2f%n", Zona.PREFERENCIAL, entradaPreferencial,
                        PrecioMundial.Precios(Zona.PREFERENCIAL, fase))
                +
                String.format("- %-13s | Disponibles: %7d | Precio: %.2f%n", Zona.VIP, entradaVip, 
                        PrecioMundial.Precios(Zona.VIP, fase));

        return "Código: " + codigoPartido +
                "\nPartido: " + partido +
                "\nFecha: " + fechaPartido +
                "\nEstadio: " + estadio +
                "\nCiudad: " + ciudad +
                "\nFase: " + fase +
                "\nZonas Disponibles: " + "\n" + infoZonas +
                "\n--------------------------------------------------";
    }
}

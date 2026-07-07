import java.util.Date;

public class Partido {

    private String codigoPartido;
    private String equipoLocal;
    private String equipoVisitante;
    private Date fechaPartido;
    private String estadio;
    private String ciudad;
    private String fase;
    private int capacidad;
    private int entradaGeneral;
    private int entradaPreferencial;
    private int entradaVip;

    public Partido(String codigoPartido, String equipoLocal,
            String equipoVisitante, Date fechaPartido,
            String estadio, String ciudad,
            String fase, int capacidad,
            int entradaGeneral, int entradaPreferencial,
            int entradaVip) {

        this.codigoPartido = codigoPartido;
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.fechaPartido = fechaPartido;
        this.estadio = estadio;
        this.ciudad = ciudad;
        this.fase = fase;
        this.capacidad = capacidad;
        this.entradaGeneral = entradaGeneral;
        this.entradaPreferencial = entradaPreferencial;
        this.entradaVip = entradaVip;
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

    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
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

}

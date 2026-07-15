/**
 * Genera los precios por entradas
 * 
 * @author Yagual-Cedeño-Carvajal
 */
public class PrecioMundial {
    /*
     * Devuelve el precio de una entrada segun la zona y fase del mundial.
     * 
     * @param zona Zona del estadio.
     * 
     * @param fase Fases del partido.
     * 
     * @return precio de la entrada.
     */
    public static double Precios(Zona zona, FasesMundial fase) {
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

}

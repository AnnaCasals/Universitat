/**
 * Classe UtilMeu: classe d'utilitats amb exemples
 * del Tema 5
 * 
 * @author IIP
 * @version Curs 2016-17
 */
public class UtilMeu {

    /** Torna el major de dos enters x i y, o y si x és igual a y.
     *  @param x int a comparar.
     *  @param y int a comparar.
     *  @return int, el major dels dos enters.
     */
    public static int max(int x, int y) { 
        int max = y;
        if (x > max) { max = x; } 
        return max;
    }
    
    /** Torna el major de dos reals x i y, o y si x és igual a y.
     *  @param x double a comparar.
     *  @param y double a comparar.
     *  @return double, el major dels dos reals.  
     */
    public static double max(double x, double y) { 
        if (x > y) { return x; } 
        else { return y; }
    }

    /** Donada la nota d'un alumne, torna la nota equivalent
     *  en lletra.
     *  @param nota double, la nota.
     *  @return String, la nota equivalent en lletra.
     */
    public static String deNotaALletra(double nota) {
        String notaLletra;
        if (nota < 0.0 || nota > 10.0) { notaLletra = "Error"; }
        else if (nota < 5.0) { notaLletra = "Suspens"; }
        else if (nota < 7.0) { notaLletra = "Aprovat"; }
        else if (nota < 9.0) { notaLletra = "Notable"; }
        else if (nota < 10.0) { notaLletra = "Excel.lent"; }
        else { notaLletra = "Matrícula d’Honor"; }
        return notaLletra;
    }

    /** Donat un número de mes, torna l'estació a la
     *  qual pertany el mes.
     *  @param numMes int, el mes.
     *  @return String, l'estació.
     */
    public static String deNumMesAEstacio(int numMes) {
        String estacio = "";
        switch (numMes) {
            case  1: case  2: case 12:
                estacio = "Hivern"; break;
            case  3: case  4: case  5: 
                estacio = "Primavera"; break;
            case  6: case  7: case  8: 
                estacio = "Estiu"; break;
            case  9: case 10: case 11:
                estacio = "Tardor"; break;
            default:
                estacio = "Error"; break;
        }
        return estacio;
    }

}

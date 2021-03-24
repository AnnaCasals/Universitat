import java.util.Locale;
import java.util.Scanner; 
/** Classe UtilPunt: defineix mètodes estàtics per a realitzar
 *  operacions útils amb punts del pla cartesià.
 *  @author Llibre IIP-PRG
 *  @version 2016-17
 */
public class UtilPunt {
    
    /** Punt constant que representa l’origen de coordenades. */
    public static final Punt ORIGEN = new Punt(0, 0);  

    private UtilPunt() { } // S'oculta el constructor per defecte

    /** Torna un Punt les coordenades cartesianes del qual
     *  es lligen des de teclat. 
     *  @return Punt, punt llegit.
     */
    public static Punt lligPunt() {
        Scanner tec = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Abscissa? "); double abs = tec.nextDouble();
        System.out.print("Ordenada? "); double ord = tec.nextDouble();
        return new Punt(abs, ord);
    }

    /** Torna un Punt les coordenades polars del qual 
     *  es lligen des de teclat. 
     *  @return Punt, punt llegit.  
     */
    public static Punt lligPuntPolar() {
        Scanner tec = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Radi? ");  double rad = tec.nextDouble();
        System.out.print("Angle? "); double ang = tec.nextDouble();
        return Punt.polarsAPunt(rad, ang);
    }

    /** Torna el Punt mitja situat entre altres dos donats. 
     *  @param a Punt.
     *  @param b Punt.
     *  @return Punt, punt mitja.
     */
    public static Punt puntMitja(Punt a, Punt b) {
        return new Punt((a.getX() + b.getX()) / 2, (a.getY() + b.getY()) / 2);
    }

    /** Torna un Punt resultat de la suma d'altres dos donats. 
     *  @param a Punt.
     *  @param b Punt.
     *  @return Punt, punt suma. 
     */
    public static Punt suma(Punt a, Punt b) {
        return new Punt(a.getX() + b.getX(), a.getY() + b.getY());
    }

    /** Torna un Punt resultat de la resta d'altres dos donats. 
     *  @param a Punt.
     *  @param b Punt.
     *  @return Punt, punt resta. 
     */
    public static Punt resta(Punt a, Punt b) {
        return new Punt(a.getX() - b.getX(), a.getY() - b.getY());
    }

    /** Torna un Punt amb l'abscissa de a incrementada en incX,
     *  i l'ordenada de a incrementada en incY. 
     *  @param a Punt.
     *  @param incX double.
     *  @param incY double.
     *  @return Punt, punt desplaçat.   
     */
    public static Punt desplasament(Punt a, double incX, double incY) {
        Punt p = new Punt(a); 
        p.moure(incX, incY); 
        return p;
    }

    /** Torna un Punt resultat d'escalar a en un factor e. 
     *  @param a Punt.
     *  @param e double.
     *  @return Punt, punt escalat.     
     */
    public static Punt escalat(Punt a, double e) {
        return new Punt(e * a.getX(), e * a.getY());
    }

    /** Torna un Punt resultat de girar a un angle alfa. 
     *  @param a Punt.
     *  @param alfa double.
     *  @return Punt, punt rotat.     
     */
    public static Punt rotacio(Punt a, double alfa) {
        double x = a.getX(), y = a.getY();
        double r = Math.sqrt(x * x + y * y), theta = Math.atan2(y, x);
        return Punt.polarsAPunt(r, theta + alfa);
    }
}
/**
 * Classe Punt: defineix punts en un espai bidimensional real 
 * amb la funcionalitat que s'indica a continuació. 
 *  
 * @author IIP
 * @version 2016-17
 */
public class Punt { 
    // Els seguents atributs (constants) representen 
    // les zones del pla on es pot trobar un Punt. 
    // S'usen en la implementació del mètode posicionEnPla
    public static final int QUADRANTS = 0;
    public static final int PRIMER_QUADRANT  = 1;
    public static final int SEGON_QUADRANT = 2; 
    public static final int TERCER_QUADRANT  = 3;
    public static final int QUART_QUADRANT  = 4;
    public static final int EIX_ABSCISSES  = 5;
    public static final int EIX_ORDENADES = 6;
    public static final int CENTRE_COORDENADES = 7;
  
    // Un Punt TÉ ...     
    private double x;  // UNA abscissa  
    private double y;  // UNA ordenada    
        
    /** Crea un punt (abs, ord). 
     *  @param abs double, l'abscissa.
     *  @param ord double, l'ordenada.
     */
    public Punt(double abs, double ord) {
        x = abs; y = ord;        
    } 
    
    /** Crea un punt estàndard, i.e., el (0.0, 0.0). */
    public Punt() { this(0.0, 0.0); }     
    
    /** Crea un punt amb les mateixes coordenades que 
     *  un altre Punt p donat. 
     *  @param p Punt.
     */
    public Punt(Punt p) { this(p.x, p.y); }
    
    /** Torna l'abscissa del Punt.  
     *  @return double, l'abscissa.
     */
    public double getX() { return x; } 
    
    /** Torna l'ordenada del Punt.  
     *  @return double, l'ordenada.  
     */
    public double getY() { return y; }
    
    /** Actualitza l'abscissa del Punt.  
     *  @param px double, el nou valor de l'abscissa. 
     */
    public void setX(double px) { x = px; }
    
    /** Actualitza l'ordenada del Punt.  
     *  @param py double, el nou valor de l'ordenada.   
     */
    public void setY(double py) { y = py; }
    
    /** Desplaça el Punt, incrementant l'abscissa i l'ordenada
     *  en dos valors donats. 
     *  @param px double, l'increment de l'abscissa.
     *  @param py double, l'increment de l'ordenada.
     */
    public void moure(double px, double py) { 
        x += px; 
        y += py; 
    }  
    
    /* Mètode privat que torna un valor enter aleatori en  
       el rang [0, (2 * distància del punt a l'origen)]. */
    private int aleatori() { 
        return (int) (Math.random() * (2 * distOrigen() + 1)); 
    } 
    
    /** Desplaça el Punt a unes coordenades aleatories. */   
    public void moureAleat() { 
        x += aleatori(); 
        y += aleatori(); 
    }
    
    /** Torna la distància del Punt a l'origen de coordenades. 
     *  @return double, la distància.
     */  
    public double distOrigen() {         
        return Math.sqrt(x * x + y * y); 
    }
        
    /**
     * Torna la distància entre un Punt p donat i el Punt actual.
     * @param p Punt.
     * @return double, la distància.
     */  
    public double distancia(Punt p) { 
        double a = p.x - this.x; 
        double o = p.y - this.y;
        return Math.sqrt(a * a + o * o); 
    }
    
    /** Torna un String que representa el Punt en el seu 
     *  típic format matemàtic, i.e. (abscissa, ordenada) 
     *  @return String, el resultat.
     */
    public String toString() { 
        return "(" + this.x + ", " + this.y + ")"; 
    }
     
    /** Torna la zona del pla on es troba el Punt  
     *  NOTA: el valor de retorn d'aquest mètode és la CONSTANT
     *        que representa la posició en el pla d'un punt. 
     *        Per exemple, si el punt està sobre l'eix d'abcisses,
     *        el valor de retorn és EIX_ABSCISSES
     */
    public int posicioEnPla() {
        if (x == 0) {
            if (y == 0) { return CENTRE_COORDENADES; }
            else { return EIX_ORDENADES; }
        } else {
            if (y == 0) { return EIX_ABSCISSES; }
            else { return QUADRANTS; }
        }
    }
}

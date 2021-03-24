/** 
 * Clase Punto: define un punto en un espacio bidimensional  
 * real, con la funcionalidad que se indica a continuacion.
 * Modificación de la clase Punto usada en el ejercicio 
 * La clase Cuadrado que usa Punto
 * @author IIP
 * @version 2015-2016
 */
public class Punto {
    
    // Se añaden los siguientes atributos (constantes) para 
    // representar las zonas del plano donde se puede encontrar 
    // un Punto. Estas constantes deben emplearse en la imple- 
    // mentación del nuevo método de la clase, posicionEnPlano
    public static final int PRIMER_CUADRANTE  = 1;
    public static final int SEGUNDO_CUADRANTE = 2; 
    public static final int TERCER_CUADRANTE  = 3;
    public static final int CUARTO_CUADRANTE  = 4;
    public static final int EJE_ABSCISAS  = 5;
    public static final int EJE_ORDENADAS = 6;
    public static final int CENTRO_COORDENADAS = 7;

    private double x; // atributo que representa la abscisa
    private double y; // atributo que representa la ordenada
    
    /** Crea un punto (abs, ord)
     *  @param abs double abscisa
     *  @param ord double ordenada
     */
    public Punto(double abs, double ord) { 
        x = abs; 
        y = ord; 
    }    

    /** Crea un punto estándar, i.e. el (0.0, 0.0) */
    public Punto() { 
        this(0.0, 0.0); 
    }

    /** Devuelve la abscisa de un punto 
     *  @return double, la abscisa  
     */
    public double getX() { return x; }

    /** Devuelve la ordenada de un punto 
     *  @return double, la ordenada  
     */
    public double getY() { return y; }
    
    /** Actualiza a nuevo el valor de la abscisa de un punto 
     *  @param nuevo double  
     */
    public void setX(double nuevo) { x = nuevo; }

    /** Actualiza a nuevo el valor de la ordenada de un punto 
     *  @param nuevo double  
     */
    public void setY(double nuevo) { y = nuevo; }
   
    /** Desplaza un punto, incrementando sus coordenadas 
     *  en px y py respectivamente 
     *  @param px double incremento de la abscisa
     *  @param py double incremento de la ordenada
     */
    public void mover(double px, double py) { 
        x += px; 
        y += py; 
    }

    // Metodo privado que devuelve un valor real aleatorio en
    // el rango [0.0, Math.sqrt(x * x + y * y)]
    private int aleatorio() { 
        return (int) (Math.random() * (distOrigen() + 1));
    }

    /** Desplaza un punto aleatoriamente, incrementando 
     *  sus coordenadas en un valor aleatorio 
     */
    public void moverAleatorio() { mover(aleatorio(), aleatorio()); }
   
    /** Devuelve la distancia de un punto a otro 
     *  @param p Punto
     *  @return double, la distancia entre los dos puntos
     */
    public double distancia(Punto otro)  { 
        double abs = otro.x - this.x;
        double ord = otro.y - this.y;
        return Math.sqrt(abs * abs + ord * ord); 
    }
   
    /** Devuelve la distancia de un punto al origen 
     *  @return double, la distancia al origen  
     */
    public double distOrigen() { return Math.sqrt(x * x + y * y); }
    
    /** Devuelve un String que representa un punto en su 
     *  tipico formato matematico, i.e. (abscisa, ordenada) 
     *  @return String, el resultado
     */
    public String toString() { 
        return "(" + this.x + ", " + this.y + ")"; 
    }
    
    /** Devuelve la zona del plano donde se encuentra un punto  
    *   NOTA: el valor de retorno de este método es la CONSTANTE
    *         que representa la posición en el plano de un punto. 
    *         Por ejemplo, si el punto está sobre el eje de abcisas,
    *         el valor de retorno es EJE_ABSCISAS
    */
    // PISTA: completar el análisis por casos del Ejemplo 8.1  
    // del libro de la asignatura, pág. 168. También en la 
    // transparencia nº 16 de los apuntes del Tema 5, en PoliformaT
    public int posicionEnPlano() {
         int res = 0;
         
         if (x == 0) {
             if(y == 0) { res = CENTRO_COORDENADAS; }
             else { res = EJE_ORDENADAS; }
            } else {
             if(y == 0) { res = EJE_ABSCISAS; }
             else if(x > 0) {
                 if(y > 0) { res = PRIMER_CUADRANTE; }
                 else { res = CUARTO_CUADRANTE; }
             } else if(x < 0) {
                 if(y > 0) {res = SEGUNDO_CUADRANTE; }
                 else {res = TERCER_CUADRANTE; }
            }    
             
          }  
          return res;
     
    }
}
/**
 * La clase Jugada representa una eleccion
 * del Juego "Piedra, Papel o Tijeras".
 *
 * @author profesores IIP
 * @version Octubre-2015
 * 
 */
public class Jugada { 
    
    public static final int PIEDRA = 1;
    public static final int PAPEL  = 2;
    public static final int TIJERA = 3;
    
    private int eleccion; 
    
    /**
     * Construye una jugada con una elección aleatoria entre los tres valores 
     * posibles: PIEDRA, PAPEL o TIJERA.
     */ 
    public Jugada() {  
        eleccion = (int) (Math.random() * 3 + 1); 
    }
    
    /**
     * Construye una jugada a partir del String e que se le pasa como parámetro.
     * Si el valor del parámetro no es ni PIEDRA, ni PAPEL ni TIJERA se asume 
     * que es PIEDRA.
     * @param e String
     */
    public Jugada(String e) {
        eleccion = PIEDRA;
        if (e.equals("PAPEL")) { eleccion = PAPEL; }
        else if (e.equals("TIJERA")) { eleccion = TIJERA; }
    }
    
    /**
     * Devuelve el valor seleccionado en la jugada.
     * @return int
     */
    public int getEleccion() { return eleccion; }

    /**  
     * Devuelve la elección de la jugada como un String.
     * @return String
     */
    public String getEleccionSt() {
        String res = ""; 
        if (eleccion == PIEDRA) { res = "PIEDRA"; }
        else if (eleccion == PAPEL) { res = "PAPEL"; }
        else if (eleccion == TIJERA) { res = "TIJERA"; }
        return res;
    }  
    /**
    * Compara si una jugada (this) gana a otra jugada. 
    * En concreto, devuelve: 
    *    0  si una (this) y otra empatan; 
    *    -1 si una (this) gana a la otra; 
    *    +1 si una (this) pierde con la otra.
    * @param otra Jugada
    * @return int 
    */
    public int ganaA(Jugada otra) {
        int res = -1;
        if (this.getEleccion() == otra.getEleccion()) {res = 0;}
           else if(this.getEleccion() == 1 & otra.getEleccion() == 3 
                   || this.getEleccion() == 3 & otra.getEleccion() == 2 
                   || this.getEleccion() == 2 & otra.getEleccion() == 1) {res = 1; }
        else {res = -1; }  
        
        return res;      
      }
  
} 
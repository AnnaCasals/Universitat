import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * ComparaTextos 
 * Classe - comandament de sistema, que retorna la unio o 
 * interseccio de les paraules de cert text.
 *
 * @author (PRG. ETSINF. UPV)
 * @version (Curs 2016/17)
 */
public class ComparaTextos {
    
    private final static String US = 
        "Us: ComparaTextos [-i|-u] nomFitx1 nomFitx2"; 
    private final static String ERR1 = "Mal acces al fitxer: ";
        
    /**
     * Arguments:
     * 1) "-u" o "-i" per a unio o interseccio respectivament.
     * 2) Fitxer de text 1 d'entrada.
     * 3) Fitxer de text 2 d'entrada.
     * 
     * Resultat en l'eixida estandard.
     */
    public static void main(String[] args) {
        
        boolean err = args.length != 3 
            || !(args[0].equals("-u") || args[0].equals("-i"));
        
        if (err) { System.out.println(US); System.exit(-1); } 
        
        String n1 = args[1];
        String n2 = args[2];
                
        switch (args[0]) {
            case "-u": 
                unio(n1, n2); break;
            case "-i": 
                interseccio(n1, n2); break;
            default: 
                System.out.println(US); System.exit(-1);
        }        
    } // del main
        
    /**
     * Escriu en l'eixida estandard el resultat de la unio
     * dels conjunts de paraules dels fitxers de text, els
     * noms dels quals estan en, nF1 i nF2.
     * @param nF1 String, nom del primer fitxer.
     * @param nF2 String, nom del segon fitxer.
     */
    public static void unio(String nF1, String nF2) {
        // A completar
    }
    
    /**
     * Escriu en l'eixida estandard el resultat de la interseccio
     * dels conjunts de paraules dels fitxers de text els
     * noms dels quals estan en nF1 i nF2.
     * @param nF1 String, nom del primer fitxer.
     * @param nF2 String, nom del segon fitxer.
     */
    public static void interseccio(String nF1, String nF2) {
        // A completar
    }
    
    /**
     * Retorna el ConjuntString de les paraules llegides del 
     * Scanner s, segons els separadors donats per defecte en 
     * ParseString (ParseString.SEPARADORS).
     * @param s Scanner.
     * @return el conjunt de paraules llegides del Scanner s.
     */
    private static ConjuntString lecturaConjunt(Scanner s) {
        // A completar
        return null;
    }
    
}

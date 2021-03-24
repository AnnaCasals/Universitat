package prac5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * TextComparing 
 * Classe - comandament de sistema, que torna la unio o interseccio
 * de les paraules de certs textos.
 *
 * @author (PRG. ETSINF. UPV)
 * @version (Curs 2017/18)
 */
public class TextComparing {    
    private final static String USAGE = 
        "Us: TextComparing [-i|-u] nomFich1 nomFich2"; 
    private final static String ERR1 = "Mal acces al fitxer: ";
    private final static String DELIMITERS = 
                      "[\\p{Space}\\p{Punct}\\p{Digit}¡¿]+";
        
    /**
     * Arguments:
     * 1) "-u" o "-i" per a unio o interseccio, respectivament.
     * 2) Fitxer de text 1 d'entrada.
     * 3) Fitxer de text 2 d'entrada.
     * 
     * Resultat en l'eixida estandard.
     */
    public static void main(String[] args) {        
        boolean err = args.length != 3 
            || !(args[0].equals("-u") || args[0].equals("-i"));
        
        if (err) { System.out.println(USAGE); } 
        else { compare(args[1], args[2], args[0]); }
    }
    
    /**
     * Escriu en l’eixida estandard el resultat de comparar els conjunts
     * de paraules dels fitxers de text els noms dels quals estan en nF1
     * i nF2. Si l’opcio es "-i", escriu la interseccio de tots dos
     * conjunts, si es "-u", escriu la unio.
     * @param nF1 String, nom del primer fitxer.
     * @param nF2 String, nom del segon fitxer.
     * @param option String.
     */
    public static void compare(String nF1, String nF2, String option) {
        // A COMPLETAR    
    }
   
    /**
     * Retorna el SetString de les paraules llegides de s,
     * segons els separadors donats, per defecte, en DELIMITERS.
     * @param s Scanner.
     * @return el conjunt de paraules llegides de s.
     */
//     private static SetString setReading(Scanner s) {            
//         A COMPLETAR
//     }    
}

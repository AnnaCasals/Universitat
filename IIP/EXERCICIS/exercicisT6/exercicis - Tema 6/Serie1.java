import java.util.Scanner;
/**
 * Classe Serie1: calcula la suma d'una progressió aritmètica 
 * en la que el primer terme és 7 i de diferència 2: 
 * a_1 == 7, a_i == a_(i-1) + 2, i>1. 
 * S(n)== a_1 + a_2 + . . . + a_n.
 * 
 * @author IIP 
 * @version Curs 2015-16
 */
public class Serie1 {
    
    public static void main(String[] args) { 
        Scanner tec = new Scanner(System.in);
        int n = Lectura.llegirIntPos("Escriu un número enter positiu: ", tec);
        System.out.printf("Suma dels %d termes = %d\n", n, suma(n));        
    } 
    
    /** Torna la suma dels n primers termes de la sèrie
     *  Precondició; n>=1 
     */
    public static int suma(int n) {
        // suma: per a acumular els termes sumats fins ara
        // term: últim terme calculat que s'ha sumat a suma i,
        // a partir del qual, es calcula el nou terme a sumar
        // i: índex del següent terme a calcular
        int suma = 7, term = 7;;
        for (int i = 2; i <= n; i++) {
            term = term + i;
            suma = suma + term;
        }
        return suma;
    }

    /** Torna el terme n-èsim de la sèrie 
     *  Precondició: n>=1 
     */
    public static int terme(int n) {
        int term = 7; // valor de l’últim terme calculat
        int i = 2;    // índex del següent terme a calcular
        while (i <= n) { 
            term = term + i;
            i++;    
        }
        return term;
    }

}

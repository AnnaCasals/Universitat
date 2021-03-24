/**
 * Classe Traces: mètodes amb bucles niuats
 * 
 * @author IIP 
 * @version Curs 2015-16
 */
public class Traces {

    /** Què mostra per pantalla? */
    public static void traza1() {
        int nfil = 4, ncol = 3;
        for (int i = 1; i <= nfil; i++) {
            for (int j = 1; j <= ncol; j++) {
                System.out.print(i + "-" + j + "  ");
            }
            System.out.println();
        }
    }
    
    /** Què mostra per pantalla? */
    public static void traza2(int n) {
        for (int i = 0; i <= n; i++) {
            // Seqüència de Z de longitud i:
            for (int j = 1; j <= i; j++) { System.out.print('Z'); }
            // Seqüència de A de longitud n:
            for (int j = 1; j <= n; j++) { System.out.print('A'); }
            // Seqüència de Z de longitud n-i:
            for (int j = 1; j <= n - i; j++) { System.out.print('Z'); }
            System.out.println();
        }
    }
}

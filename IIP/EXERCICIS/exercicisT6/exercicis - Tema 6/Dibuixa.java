/**
 * Classe Dibuixa: classe d'utilitats amb mètodes per a
 * dibuixar figures geomètriques
 * 
 * @author IIP 
 * @version Curs 2015-16
 */
public class Dibuixa {
    
    /** Mostra per pantalla un rectangle de 
     *  base i altura donades utilitzant *
     */
    public static void rectangle(int base, int altura) {
        for (int i = 0; i < altura; i++) {
            for (int j = 0; j < base; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /** Mostra per pantalla un triangle rectangle de 
     *  base donada utilitzant *
     */
    public static void triangleRec(int base) {
        
    }
    
    /** Mostra per pantalla, donat un enter n>=0, una zeta 
     *  utilitzant el caràcter 'Z' en n línies
     */
    public static void zeta(int n) {
        
    }
}

import java.util.Scanner;
/**
 * Class Lectura: classe d'utilitats amb mètodes 
 * per a lectura validada
 * @author IIP 
 * @version Curs 2015-16
 */
public class Lectura {
    /** Torna un valor enter positiu llegit des de tec 
     *  segons la petició expressada en el mitssage msg. 
     */
    public static int llegirIntPos(String msg, Scanner tec) {
        int n;
        do {
            System.out.print(msg);
            n = tec.nextInt();
        } while (n < 0); 
        return n;
    }
    
    /** Torna un valor enter comprès entre x i y, llegit des de tec 
     *  segons la petició expressada en el mitssage msg.  
     *  Precondición: x <= y
     */
    public static int llegirIntEntre(String msg, Scanner tec, int x, int y) {
        /* COMPLETAR */
    } 
     
}

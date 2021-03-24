import java.util.Scanner;
/**
 * Clase TestInstant. 
 * 
 * @author (IIP. Grau en Informatica. ETSINF, UPV) 
 * @version (Curs 2016-17)
 */
public class TestInstant {
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        System.out.println("Lectura de teclat d'una hora.");
        System.out.print("   -> Introdueix les hores (entre 0 i 23): ");
        int h = teclat.nextInt();
        System.out.print("   -> Introdueix els minuts (entre 0 i 59): ");
        int m = teclat.nextInt();
        Instant hora = new Instant(h,m);
        if((h >= 0 && h < 24) && (m >= 0 && m < 60)) {
            hora = hora;
        } else  { hora = new Instant(); }
        System.out.println("Hora introduida: " + hora.toString()); 
        hora.decrementar1Min();
        int a = hora.getHores();
        int b = hora.getMinuts();
        Instant hs = new Instant(a, b);
        System.out.println("Després: " + hs.toString());
    }
}

import java.util.*;
public class BorsaValors {
    public static Accio mesVolatil(Accio a, Accio b) {
        double m = a.getMinim();
        double n = a.getMaxim();
        double s = b.getMinim();
        double e = b.getMaxim();
        double va = ((n - m) * 100) / m;
        double vb = ((e - s) * 100) /s;
        if(va > vb) { return a; }
        else { return b; }
    }
    
    public static double intervalAleatori(double a, double b) {
        double m1 = Math.min(a, b);
        double m2 = Math.max(a, b);
        return Math.random() + (m2 - m1) + m1;
    }    
   
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in).useLocale(Locale.US);
        
        // 1
        Accio a = new Accio("Iberdrola", 12.30);
        System.out.println("1a Acció: " + a);
        
        // 2
        System.out.print("Nom de l'empresa per  a l'acció 2: ");
        String nom = teclat.nextLine();
        double min = intervalAleatori(1, 100);
        double max = intervalAleatori(min, 100);
        double obe = intervalAleatori(min, max);
        Accio b = new Accio(nom, obe, min, max);
        System.out.println("Acció 2: " + b);
        
        // 3
        System.out.print("Valor actual per a l'acció 1: ");
        double act1 = teclat.nextDouble();
        a.setActual(act1);
        if(a.capAMunt()) { System.out.println("Està donant beneficis " + a); }
        else { System.out.println("No està donant beneficis " + a); }
        
        // 4
        System.out.println("La acció més volàtil és: " + mesVolatil(a, b));
    }
}

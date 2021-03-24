
import java.util.*;

/**public class TestAstre {
    public void main(String[] args) {
        Scanner teclat = new Scanner(System.in).useLocale(Locale.US);
        Astre a1 = new Astre("Alfa Centauri", Astre.ESTEL, 4.6, 4.3);
        System.out.println(a1);
        
        System.out.println("Dona-li un nom al astre: ");
        String n = teclat.nextLine();
        System.out.println("Elegeix un tipus (estel: 0, nebulosa: 1, galàxia: 2). ");
        int t = teclat.nextInt();
        System.out.println("Brillantor: ");
        double b = teclat.nextDouble();
        System.out.println("Distància: ");
        double d = teclat.nextDouble();
        Astre a2 = new Astre(n, t, b, d);
        System.out.println("L'astre es pot veure" + a2.visibleAmb());
        
        int brillant = a1.mesBrillant(a2);
        switch(brillant) {
            case 0: 
            System.out.println("Astre" + a1 + "brilla igual que el astre" + a2);
            break;
            case 1:
            System.out.println("Astre" + a1 + " més brillant que el astre" + a2);
            break;
            case -1: 
            System.out.println("Astre" + a2 + "més brillant que el astre" + a1);
        }
    }
} */
public class TestAstre {
    public static void main(String[] args) {
         Scanner teclat = new Scanner(System.in).useLocale(Locale.US);
         Astre uno = new Astre("Alfa Centauri", Astre.ESTEL, 4.6, 4.3);
         System.out.println(uno);
         System.out.println("\nIntrodueix les dades d'un astre");
         System.out.print("Nom: "); 
         String n = teclat.nextLine();
         System.out.print("Tipus (0: Estel, 1: Nebulosa, 2: Galàxia): ");
         int t = teclat.nextInt();
         System.out.print("Brillantor: "); 
         double b = teclat.nextDouble();
         System.out.print("Distància: "); 
         double d = teclat.nextDouble();
         Astre dos = new Astre(n,t,b,d);
         System.out.println(dos + " és observable " + dos.visibleAmb() + "\n");
         int brillaMes = uno.mesBrillant(dos);
         switch(brillaMes) {
             case 0: System.out.println(uno + " i " + dos + " brillen igual"); break;
             case 1: System.out.println(uno + " brilla més que " + dos); break;
             case -1: System.out.println(dos + " brilla mées que " + uno); 
         }
    }
}


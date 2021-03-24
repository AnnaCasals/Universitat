/**
 * Classe TestPunt: classe programa que prova la classe Punt.
 * En particular, els mètodes equals i toString.
 * 
 * @author IIP 
 * @version 2016-17
 */
public class TestPunt {

    public static void main(String[] args) {
        Punt a = new Punt(2.5, 3.0);   
        Punt b = new Punt(4.0, 5.0);     
               
        // toString
        System.out.println("El punt a: " + a.toString() 
                           + " i el punt b: " + b.toString()); 
        // De manera equivalent
        // System.out.println("El punt a: " + a + " i el punt b: " + b); 
        
        // Comparació amb equals o amb ==
        System.out.println("Comparació amb equals o amb ==");
        System.out.println("  Resultat de a.equals(b): " + a.equals(b)); 
        System.out.println("  Resultat de a == b: " + (a == b));
    
        b = a;
        System.out.println("\nDesprés de l'assignació: b = a; ");
        System.out.println("  El punt a: " + a + " i el punt b: " + b); 
        System.out.println("  Resultat de a.equals(b): " + a.equals(b));
        System.out.println("  Resultat de a == b: " + (a == b));   
    }
}

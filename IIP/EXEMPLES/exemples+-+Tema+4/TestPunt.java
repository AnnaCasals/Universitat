/**
 * Classe TestPunt: classe programa que prova la classe Punt.
 * En particular, els m�todes equals i toString.
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
        
        // Comparaci� amb equals o amb ==
        System.out.println("Comparaci� amb equals o amb ==");
        System.out.println("  Resultat de a.equals(b): " + a.equals(b)); 
        System.out.println("  Resultat de a == b: " + (a == b));
    
        b = a;
        System.out.println("\nDespr�s de l'assignaci�: b = a; ");
        System.out.println("  El punt a: " + a + " i el punt b: " + b); 
        System.out.println("  Resultat de a.equals(b): " + a.equals(b));
        System.out.println("  Resultat de a == b: " + (a == b));   
    }
}

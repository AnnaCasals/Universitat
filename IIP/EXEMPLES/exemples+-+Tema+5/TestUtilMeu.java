import java.util.Locale; 
import java.util.Scanner;
/**
 * Classe TestUtilMeu: classe de prova dels exemples
 * del Tema 5
 * 
 * @author IIP
 * @version Curs 2016-17
 */
public class TestUtilMeu {

    public static void main(String[] args) { 
        Scanner teclat = new Scanner(System.in).useLocale(Locale.US);
        System.out.print("Introdueix dos valors reals: ");
        double num1 = teclat.nextDouble();
        double num2 = teclat.nextDouble();
        double max = UtilMeu.max(num1, num2);
        System.out.printf(Locale.US, "El màxim és %4.2f\n", max);        
    }
        
}

import java.util.Scanner;
/**
 * Classe FactorialMeu: exercici no presencial de la sessió 2
 * 
 * @author IIP 
 * @version Curs 2015-16
 */
public class FactorialMeu {

    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        int num;
        System.out.print("Introdueix el número: ");
        num = teclat.nextInt();
        System.out.printf("El factorial de %d és %d\n", num, factorial(num));
    }
        
    /** Calcula el factorial d'un número n>=0
     */
    public static int factorial(int n) {
        int fact = 1;
        /* COMPLETAR */
        return fact;
    }

}

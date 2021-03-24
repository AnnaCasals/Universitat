import java.util.Scanner;
/**
 * Classe TaulaDeMultiplicar
 * 
 * @author IIP 
 * @version Curs 2015-16
 */
public class TaulaDeMultiplicar {

    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        System.out.print("Dis-me un número positiu: ");
        int num = teclat.nextInt();
        if (num > 0) {
            mostrarTaulaDel(num);
        } else { System.out.println("El número no és vàlid"); }
    }
    
    /** Mostra per pantalla la taula de multiplicar del n, 
     *  amb n positiu 
     */
    public static void mostrarTaulaDel(int n) { 
        System.out.printf("Taula del %2d\n", n);
        for (int i = 1; i <= 10; i++) { 
            System.out.printf("%2d x %2d = %2d\n", n, i, n * i); 
        }
    }
 
}

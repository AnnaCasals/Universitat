import java.util.Scanner;
/**
 * Classe TaulaDeMultiplicar2
 * 
 * @author IIP 
 * @version Curs 2015-16
 */
public class TaulaDeMultiplicar2 {

    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        int num;
        do {
            System.out.print("Dis-me un número positiu: ");
            num = teclat.nextInt();
            if (num <= 0) { 
                System.out.println("El número no és vàlid"); 
            }
        } while (num <= 0);       
        mostrarTaulaDel(num);
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
    
    /** Mostra per pantalla les taules de multiplicar
     *  de l'1 al 9, una a continuació de l'altra.
     */ 
    public static void mostrarTaules() {
        for (int i = 1; i <= 9; i++) {
            mostrarTaulaDel(i);
        }
        
        // Sense cridar al mètode mostrarTaulaDel
//         for (int i = 1; i <= 9; i++) {
//             System.out.printf("Taula del %2d\n", i);
//             for (int j = 1; j <= 10; j++) { 
//                System.out.printf("%2d x %2d es %2d\n", i, j, i * j); 
//             }    
//         }
    }
}
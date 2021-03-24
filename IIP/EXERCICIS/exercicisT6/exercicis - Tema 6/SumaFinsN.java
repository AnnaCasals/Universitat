import java.util.Scanner;
/**
 * Clase SumaFinsN: exercici de les sessions 1 i 3
 * 
 * @author IIP 
 * @version Curs 2015-16
 */
public class SumaFinsN {

    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        int num;
        do {
            System.out.print("Introdueix un número (>= 0): ");
            num = teclat.nextInt();
        } while (num < 0);
        // int num = Lectura.llegirIntPos("Introdueix un número (>= 0): ", teclat);
        System.out.printf("La suma dels primers números naturals "  
                           + "fins %d és %d\n", num, sumaFins(num));
    }
        
    /** Calcula la suma dels n primers números naturals 
     *  Precondició: n>=0
     */
    public static int sumaFins(int n) {
        // Primera versió: suma ascendent 1+2+3+4+...+(n-2)+(n-1)+n
        int suma = 0,   // acumula el resultat de les successives sumes 
            k = 1;      // indica el nº que es va a sumar a suma 
        while (      ) {
    
        }
        
        // Segona versió: suma ascendent 1+2+3+4+...+(n-2)+(n-1)+n
//         int suma = 0, 	// acumula el resultat de les successives sumes 
//             k = 0;	 	// indica el darrer nº que s’ha sumat a suma 
//         while (      ) {
//     
//         }

        // Primera versió: suma descendent n+(n-1)+(n-2)+...+4+3+2+1
//         int suma = 0, 	// acumula el resultat de les successives sumes 
//             k = n;	    // indica el nº que es va a sumar a suma 
//         while (      ) {
//     
//         }

        // Segona versió: suma descendent n+(n-1)+(n-2)+...+4+3+2+1
//         int suma = n, 	// acumula el resultat de les successives sumes 
//             k = n;	    // indica el darrer nº que s’ha sumat a suma 
//         while (      ) {   
// 
//         }

        return suma;
    }

}

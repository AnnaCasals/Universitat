import java.util.Scanner;
/**
 * Classe TestLectura: classe programa que prova 
 * un mètode de la classe Lectura
 * @author IIP
 * @version Curs 2015-16
 */
public class TestLectura {
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in); 
        int valor = Lectura.llegirIntEntre("Valor entre 1 i 6: ", tec, 1, 6);
        System.out.println("Llegit:" + valor);
        
        // Sol.licita del teclat l'any actual, com 
        // un valor comprès entre 1900 i 2015.

        // Sol.licita del teclat un any en el futur (màxim 3000)
        
        // Mostra per pantalla la diferència entre els dos anys.

    }
    
}

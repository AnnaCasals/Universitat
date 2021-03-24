import java.util.Locale;
import java.util.Scanner;
/**
 * Classe MenuPunt: exemple de gestió d'un menú
 * 
 * @author IIP
 * @version Curs 2016-17
 */
public class MenuPunt {
    
    /** Torna un enter, llegit des de l'entrada estàndard (teclat), 
     *  que indica el número de l'opció triada per l'usuari d'entre 
     *  les tres possibles d'un menú mostrat en l'eixida estàndard 
     *  (pantalla).
     *  @param t Scanner, l'entrada estàndard (teclat).
     *  @return int, el número de l'opció del menú triada.
     */
    private static int menu(Scanner t) {
        System.out.println(" MENÚ");
        System.out.println("1. Distància a l'origen d'un punt");
        System.out.println("2. Moure un punt aleatòriament");
        System.out.println("3. Dades d'un punt");
        System.out.print("\nTria una opció: ");
        int opc = t.nextInt();        
        return opc;
    }

    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        // Crear un Punt p de coordenades (1.5, 3.0)
        Punt p = new Punt(1.5, 3.0);  
        // Cridar al mètode menu
        int opcio = menu(tec);
        // Utilitzar una instrucció switch:
        switch (opcio) {
            case 1: // distància a l'origen del punt p
                double d = p.distOrigen();
                System.out.printf(Locale.US, "Distància = %.2f\n", d);
                break;
            case 2: // moure el punt p aleatòriament
                p.moureAleat();
                System.out.println("Nou punt = " + p.toString());
                break;
            case 3: // dades del punt p
                System.out.println(p.toString());
                // equivalentment:
                // System.out.println(p);
                break;
            default: 
                System.out.println("Opció no vàlida");
        }
    } 
    
}

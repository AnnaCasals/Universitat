import java.util.*;
/**
 * Write a description of class GestorTermostat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GestorTermostat {
    public static String consell(Termostat t) {
        String consell = " ";
        int graus = t.diferenciaAmbIdeal();
        if(graus == 0) { 
            consell = "La temperatura és adequada"; 
        } else {
            consell = "Graus a ";
            if(t.getMode() == Termostat.FRED) {
                consell += "augmentar: ";
            } else {
                consell += "disminuir: "; 
            }
            consell += graus;   
        }
        return consell;    
    }
    
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in).useLocale(Locale.US);
        System.out.println("Introdueix les dades per al termostat" );
        System.out.print(" Mode Termostat(0: Fred, 1: Calor): ");
        int m = teclat.nextInt();
        System.out.print("Temperatura Confort: ");
        int tC = teclat.nextInt();
        System.out.print("Temperatura Actual: ");
        double tA = teclat.nextDouble();
        Termostat t = new Termostat(m, "dormitori ppal",tC, tA);
        System.out.println("El termòstat creat és: " + t.toString());
        System.out.println("Consell d'eficiència energètica: " + consell(t));
    }
}

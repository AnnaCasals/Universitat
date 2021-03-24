
/**
* Classe JocCartes per a provar la funcionalitat de la classe Carta.
*
* @author IIP
* @version Curs 2011/12
*/
import java.util.*;

public class JocCartes {
    public static int guanya(Carta c1, Carta c2, int triomf) {
        int guanyadora = 1;
        if (c1.equals(c2)) { guanyadora = 0; }
        else if (c1.getPal()==c2.getPal()) {
            if(c1.getValor() == 1 ||
            (c2.getValor() != 1 && c1.getValor() > c2.getValor()) ) { guanyadora = -1; }
        }
        else if(c1.getPal() == triomf || c2.getPal() != triomf) { guanyadora = -1; }
        return guanyadora;
    }
    
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        // Crear una Carta solicitant el pal i el valor a l'usuari des de teclat
        System.out.print("Introdueix el pal (0 = ORS, 1 = COPES, 2 = ESPASES i 3 = BASTOS): ");
        int pal = tec.nextInt();
        System.out.print("Introdueix el valor (enter entre 1 i 12): ");
        int valor = tec.nextInt();
        Carta c1 = new Carta(pal,valor);
        System.out.println("Carta 1: " + c1.toString());
        // Crear una Carta aleatoria
        Carta c2 = new Carta();
        System.out.println("Carta 2: " + c2.toString());
        // Generar aleatoriament el pal de triomf
        int triomf = (int)(Math.random()*4);
        System.out.print("El pal de triomf és ");
        switch(triomf){
            case Carta.ORS: System.out.println("ors"); break;
            case Carta.COPES: System.out.println("copes"); break;
            case Carta.ESPASES: System.out.println("espases"); break;
            case Carta.BASTOS: System.out.println("bastos");
        }
       // Indicar la carta guanyadora
       int g = guanya(c1,c2,triomf);
       switch(g) {
           case -1: System.out.println("Guanya " + c1); break;
           case 1: System.out.println("Guanya " + c2); break;
           default: System.out.println("Les cartes són iguals");
       }
    }
    
}
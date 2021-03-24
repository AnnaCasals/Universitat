/**
 * Classe TestIfsPunt: exemples d'instrucció if...else... niuats
 * amb objectes de tipus Punt (Tema 5)
 * 
 * @author IIP
 * @version Curs 2016-17
 */
public class TestIfsPunt {
    
    public static void main(String[] args) {
        Punt p1 = new Punt(4, 5); 
		Punt p2 = new Punt();
        final String MSG_DIST_ORIG = " distància de l'origen ";
        double dOp1 = p1.distOrigen(); 
		double dOp2 = p2.distOrigen();  
        if (dOp1 > dOp2) {
            System.out.println("p1 està a major" + MSG_DIST_ORIG + "que p2");  
        } else if (dOp1 < dOp2) {
            System.out.println("p2 està a major" + MSG_DIST_ORIG + "que p1");
        } else {
            System.out.println("p1 i p2 estan a igual" + MSG_DIST_ORIG);
        }
        
        double pos = p1.posicioEnPla();
        System.out.print("El punt està a ");
        if (pos == Punt.CENTRE_COORDENADES) {
            System.out.println("l'origen de coord. (0,0)"); 
        } else if (pos == Punt.EIX_ORDENADES) {         
            System.out.println("l'eix d’'ordenades Y"); 
        } else if (pos == Punt.EIX_ABSCISSES) { 
            System.out.println("l'eix d'abscisses X"); 
        } else { System.out.println("qualsevol dels 4 quadrants"); }
    }
    
}

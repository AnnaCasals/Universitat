/**
 * Classe ProgramaTri: programa que mostra per pantalla el perimetre   
 * d'un triangle definit per els seus 3 vertex, tres punts donats d'un 
 * espai bidimensional Real.
 * 
 * NOTA: el perimetre d'un triangle es la suma dels seus 3 costats, 
 * que se determinen a partir dels seus 3 vertex.
 * @author IIP
 * @version 2016-17
 */
public class ProgramaTri {

    public static void main(String[] args) {
        Punt p1 = new Punt(2.5, 3);         
        Punt p2 = new Punt(2.5, -1.2);        
        Punt p3 = new Punt(-1.5, 1.4);    
        double perimetre = perimetre(p1, p2, p3);
        System.out.println("Perímetre: " + perimetre);    
    }
    
    private static double perimetre(Punt p1, Punt p2, Punt p3) {
        double costat12 = p1.distancia(p2);
        double costat23 = p2.distancia(p3);
        double costat13 = p1.distancia(p3);
        return costat12 + costat23 + costat13;  
    }
    
}

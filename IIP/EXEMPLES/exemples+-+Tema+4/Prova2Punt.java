/**
 * Class Prova2Punt: clase programa que prova classe Punt.
 * Utilitzat en les transpes per veure l'invocació de mètodes
 * dinàmics.
 * @author IIP 
 * @version 2016-17
 */
public class Prova2Punt {

    public static void main(String[] args) {
        Punt p = new Punt();
        int x = 3;
        p.moure(x, x + 1);
        double d = 3 * p.distOrigen();
    }
}

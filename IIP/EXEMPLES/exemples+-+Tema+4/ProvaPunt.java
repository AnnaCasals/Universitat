/**
 * Classe ProvaPunt: classe programa que prova la classe Punt.
 * S'utilitza en les transpes per veure els conceptes d'objecte 
 * en curs i refer�ncia this per a m�todes din�mics.
 * @author IIP 
 * @version 2016-17
 */
public class ProvaPunt {

    public static void main(String[] args) {
        Punt a = new Punt(1.5, 1.5);
        Punt b = new Punt();
        double dB = b.distOrigen();
        double dA = a.distOrigen();
    }
    
}

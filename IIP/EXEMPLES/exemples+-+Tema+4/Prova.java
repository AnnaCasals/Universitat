/**
 * Classe Prova: classe programa que prova la classe Punt.
 * Per fer la tra�a amb el depurador de BlueJ, estableix un 
 * punt de ruptura en la l�nia on s�invoca al m�tode distancia.
 * 
 * @author IIP 
 * @version 2016-17
 */
public class Prova {
    public static void main(String[] args) {
        double x = 0.0;
        Punt q1 = new Punt(3.0, 4.0);
        Punt q2 = new Punt();
        x = q2.distancia(q1); 
        System.out.println(x);
    }    
}

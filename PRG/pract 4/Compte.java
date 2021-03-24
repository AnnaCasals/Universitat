/**
 * Classe Compte per a representar un compte bancari.
 * @author PRG 
 * @version Curs 2016/17
 */
public class Compte {
    private double saldo;
    private int numCompte;

    /**
     * Constructor que, donats un n�mero de compte i un saldo inicial,
     * crea un compte. 
     * @param numCompte int que indica el n�mero de compte associat a
     * aquest compte. Ha de ser un enter amb 5 d�gits.
     * @param saldoInicial double que indica el saldo inicial del compte.
     *                Ha de ser un valor real >=0.
     */
    public Compte(int numero, double saldoInicial) {        
        numCompte = numero;
        saldo = saldoInicial;
    }

    /**
     * Permet ingressar diners en el compte.
     * @param quantitat double que indica la quantitat a ingressar.
     *                 Ha de ser un valor real >=0.
     */    
    public void ingressar(double quantitat) { saldo += quantitat; }

    /**
     * Permet retirar diners del compte.
     * @param quantitat double que indica la quantitat a retirar.
     *                 Ha de ser un valor real >=0 i <=saldo.
     */ 
    public void retirar(double quantitat) { saldo -= quantitat; }

    /**
     * Torna el saldo actual del compte.
     * @return double, el saldo actual.
     */
    public double getSaldo() { return saldo; }

    /**
     * Torna el número de compte del compte.
     * @return int, el número de compte.
     */
    public int getNumCompte() { return numCompte; }

    /**
     * Torna una String representant el compte en el format següent, 
     * per exemple, 12345 100.52 on 12345 és el número de compte i 
     * 100.52 és el seu saldo.
     * @return String.
     */
    public String toString() {
        return numCompte + " " + saldo;
    }
}

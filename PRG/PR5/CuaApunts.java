import java.io.Serializable;
import java.util.NoSuchElementException;
/**
 * CuaIntEnla: Cua enllaçada de valors de tipus int.
 *
 * @author PRG
 * @version Curs 2015/16
 */
public class CuaApunts implements Serializable {

    private NodeApunt primer, ultim; // referencies al primer i ultim element
                                   // de la cua (punts d'acces a la cua)
    private int talla;  // numero d'elements de la cua

    /**
     * Constructor d'una cua buida.
     */
    public CuaApunts() {
        primer = null;
        ultim = null;
        talla = 0;
    }

    /**
     * Comprova si la cua esta o no buida.
     * @return boolean, true si la cua esta buida i false en cas contrari.
     */
    public boolean esBuida() { return (primer == null); }

    /**
     * Encua un nou element en la cua.
     * @param x int a encuar en la cua.
     */
    public void encuar(Apunt x) {
        NodeApunt nou = new NodeApunt(x);
        if (ultim != null) {
            ultim.seguent = nou;
        }
        else { primer = nou; }
        ultim = nou;
        talla++;
    }

    /**
     * Torna la dada de l'element primer de la cua.
     * @throws NoSuchElementException si la cua esta buida.
     * @return int, dada de l'element primer de la cua.
     */
    public Apunt primer() {
        if (this.esBuida()) {
            throw new NoSuchElementException("Cua buida");
        }
        return primer.dada;
    }

    /**
     * Consulta i desencua el primer de la cua.
     * @throws NoSuchElementException si la cua esta buida.
     * @return int, dada de l'element primer desencuat de la cua.
     */
    public Apunt desencuar() {
        if (talla == 0) {
            throw new NoSuchElementException("Cua buida");
        }
        Apunt x = primer.dada;
        primer = primer.seguent;
        if (primer == null) { ultim = null; }
        talla--;
        return x;
    }

    /**
     * Torna el numero d'elements de la cua.
     * @return int, numero d'elements de la cua.
     */
    public int talla() { return talla; }

    /**
     * Torna una String formada pels valors de la cua.
     * @return String amb les dades de la cua.
     */
    public String toString() {
        String s = "";
        NodeApunt p = primer;
        while (p != null) {
            s += String.format("%4s\n", p.dada);
            p = p.seguent;
        }
        return s;
    }   
    
    public Apunt[] toArray(){
        Apunt[] aux = new Apunt[talla];
        int k = 0;
        for (NodeApunt p = primer; p != null; p = p.seguent){
            aux[k++] = p.dada;
        }
        return aux;    
    }

}

package linear;

import java.util.NoSuchElementException;
/**
 * ListPIIntLinked: Implementació enllaçada de l'estructura de dades 
 * lineal Llista amb punt d'interès d'enters.
 * 
 * @author PRG
 * @version Curs 2017/18
 */
public class ListPIIntLinked {    
    private NodeInt first, pI, prevPI; // referències al first, al PI 
                                         // i a l'anterior de la llista   
    private int size;       // número d'elements de la llista
    
    /**
     * Crea una llista buida.
     */
    public ListPIIntLinked() {
        first = null;
        pI = null;
        prevPI = null;
        size = 0;
    }

    /**
     * Comprova si la llista actual està o no buida.
     * @return boolean, true si la llista està buida i false en cas contrari.
     */
    public boolean empty() { 
        return size == 0;   // Alternativament: return first == null;
    }
    
    /**
     * Comprova si el punt d'interès està al final de la llista actual.
     * @return boolean, true si el PI està al final de la llista i false 
     * en cas contrari.
     */
    public boolean isEnd() { return pI == null; }
    
    /**
     * Torna el número d'elements de la llista actual.
     * @return int, número d'elements de la llista actual.
     */
    public int size() { return size; }      

    /**
     * Situa el punt d'interès en la primera posició de la llista actual.
     */
    public void begin() { 
        pI = first; 
        prevPI = null; 
    }

    /**
     * Desplaça el PI una posició cap a la dreta. 
     * @throws NoSuchElementException si el PI es troba al final de la llista.
     */
    public void next() { 
        if (pI == null) { 
            throw new NoSuchElementException("Point of interest at the end");
        }
        prevPI = pI; 
        pI = pI.next;
    }
    
    /**
     * Torna l'element en el PI. 
     * @throws NoSuchElementException si el PI es troba al final de la llista.
     * @return int, element en el PI de la llista.
     */
    public int get() { 
        if (pI == null) { 
            throw new NoSuchElementException("Point of interest at the end");
        }
        return pI.data; 
    }   

    /**
     * Insereix un nou node amb l'element x en la posició anterior al PI. 
     * Si el cursor està a l’inici, el nou node serà el first de la 
     * llista. En qualsevol altre cas, el nou node s’insereix entre el 
     * node cursor i el seu node predecessor.
     * @param x, element a afegir en la llista.
     */
    public void insert(int x) {
        if (pI == first) { 
            first = new NodeInt(x, pI); 
            prevPI = first; 
        } 
        else { 
            prevPI.next = new NodeInt(x, pI); 
            prevPI = prevPI.next; 
        } 
        size++;
    }
    
    /**
     * Torna i elimina de la llista l'element en el PI. 
     * Si el cursor està a l’inici, first s’actualitza al seu node 
     * següent. En qualevol altre cas, els nodes anterior i posterior 
     * al node cursor queden enllaçats.
     * @throws NoSuchElementException si el PI es troba al final de la llista.
     * @return int, element en el PI de la llista.
     */
    public int remove() {
        if (pI == null) { 
            throw new NoSuchElementException("Point of interest at the end");
        }
        int x = pI.data; 
        if (pI == first) { first = first.next; }
        else { prevPI.next = pI.next; }
        pI = pI.next; 
        size--; 
        return x;
    }
  
    /**
     * Comprova si la llista actual és igual o no a una llista donada.
     * Dues llistes són iguals si són iguals tots els seus elements 
     * i en el mateix ordre.
     * @param o Object que representa la llista a comparar.
     * @return boolean, true si són iguals i false en cas contrari.
     */
    public boolean equals(Object o) {
        boolean answer = false;
        if (o instanceof ListPIIntLinked) {
            ListPIIntLinked other = (ListPIIntLinked) o;
            NodeInt b = other.first;
            NodeInt a = this.first;
            answer = (this.size == other.size);
            while (a != null && answer) {
                answer = (a.data == b.data);
                a = a.next; b = b.next;
            }       
        }
        return answer;
    }
    
    /**
     * Torna un String amb els elements de la llista actual.
     * @return String amb les dades de la llista.
     */     
    public String toString() {
        String s = "";
        NodeInt p = first;
        while (p != null) {
            if (p == pI)   { s += " [" + p.data + "]"; }
            else           { s += " " + p.data; }
            p = p.next;
            if (p != null) { s += ","; }
        }
        return s;
    }
    
    /*************** MÈTODES DELS EXEMPLES ******************************/   
    /**
     * Mètode privat auxiliar que busca la primera ocurrència de x 
     * des del node aux en endavant; si el troba, mou el PI al node 
     * que conté a x. Si no apareix, el PI no es mou.
     * @param aux NodeInt a partir del qual es fa la cerca
     * @param x int a buscar
     * @return boolean true si el troba i false en cas contrari.
     */
    private boolean buscar(NodeInt aux, int x) { 
        NodeInt ant = null;
        if (aux == this.pI) { ant = this.prevPI; }
        while (aux != null && aux.data != x) {
            ant = aux;
            aux = aux.next;
        }
        boolean res = false;
        if (aux != null) {
            this.pI = aux;
            this.prevPI = ant;
            res = true;
        }
        return res;
    }
    
    /**
     * Busca la primera ocurrència de x des del primer node de la llista; 
     * si el troba, mou el PI al node que conté a x. Si no apareix, el PI 
     * no es mou.
     * @param x int a buscar
     * @return boolean true si el troba i false en cas contrari.
     */
    public boolean buscarInici(int x) { return buscar(first, x); } 
    
    /**
     * Busca la primera ocurrència de x des del node del PI (inclusivament) 
     * de la llista; si el troba, mou el PI al node que conté a x. Si no 
     * apareix, el PI no es mou.
     * @param x int a buscar
     * @return boolean true si el troba i false en cas contrari.
     */
    public boolean buscarSeguent(int x) { return buscar(pI, x); }    
}

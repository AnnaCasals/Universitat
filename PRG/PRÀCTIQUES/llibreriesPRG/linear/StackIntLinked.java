package linear;

import java.util.NoSuchElementException;
/**
 * StackIntLinked: Implementació enllaçada de l'estructura de dades 
 * lineal Pila d'enters.
 * 
 * @author PRG
 * @version Curs 2017/18
 */
public class StackIntLinked {
    private NodeInt top;  // referència al top de la pila (punt d'accés)
    private int size;     // número d'elements de la pila

    /**
     * Crea una pila buida.
     */
    public StackIntLinked() {
        top = null;
        size = 0;
    }

    /**
     * Empila un nou element en la pila. 
     * @param x, int a empilar en la pila actual.
     */
    public void push(int x) {
        top = new NodeInt(x, top);
        size++;
    }

    /**
     * Torna i desempila el top de la pila.
     * @throws NoSuchElementException si la pila està buida.
     * @return int, dada de l'element top desempilat de la pila actual.
     */
    public int pop() {
        if (top == null) {
            throw new NoSuchElementException("Empty stack");
        }
        int x = top.data;
        top = top.next;
        size--;
        return x;
    }

    /**
     * Torna la dada de l'element top de la pila actual.
     * @throws NoSuchElementException si la pila està buida. 
     * @return int, dada de l'element top de la pila actual.
     */
    public int peek() { 
        if (top == null) { 
            throw new NoSuchElementException("Empty stack");
        }
        return top.data; 
    }

    /**
     * Comprova si la pila actual està o no buida. 
     * @return boolean, true si la pila està buida i false en cas contrari.
     */
    public boolean empty() { 
        return (top == null);  // o return (size == 0);
    }
    
    /**
     * Torna el número d'elements de la pila actual.
     * @return int, número d'elements de la pila actual.
     */
    public int size() { return size; }
    
    /**
     * Comprova si la pila actual és igual o no a una pila donada.
     * @param o Object que representa la pila a comparar.
     * @return boolean, true si són iguals i false en cas contrari.
     */
    public boolean equals(Object o) {
        boolean igual = false;
        if (o instanceof StackIntLinked) {
            StackIntLinked p = (StackIntLinked) o;
            if(this.size() != p.size()) {return false; }
            else{
                while(top != null) {
                    if(this.top.data == p.top.data) {
                        this.pop(); p.pop();
                    } else {return false; }
                }
                igual = true;
            }
        }
        return igual;
    }
    
    /**
     * Torna una String formada pels valors de la pila actual.
     * @return String amb les dades de la pila.
     */
    public String toString() {
        String res = "";
        for (NodeInt i = top; i != null; i = i.next) {
            res += i.data + "\n";
        }
        return res;
    }
}

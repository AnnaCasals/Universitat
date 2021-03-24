package linear;

/**
 * Classe NodeInt: Representació d'una estructura que associa 
 * una dada (de tipus int) i l'enllaç a la dada següent.
 * 
 * @author PRG
 * @version Curs 2017/18
 */
class NodeInt {
    protected int data;        // dada del node
    protected NodeInt next;    // enllaç al següent node
    
    /** Constructor A: crea un node amb una dada d i que no té següent. 
     *  @param d int que representa la dada del nou node.
     */ 
    NodeInt(int d) { 
        data = d; 
        next = null; 
        // de manera equivalent: this(d, null);
    } 
    
    /** Constructor B: crea un node amb una dada d, enllaçat a un node 
     *  preexistent s. 
     *  @param d int que representa la dada del nou node.
     *  @param s NodeInt amb el qual enllaçar el nou node.
     */ 
    NodeInt(int d, NodeInt s) { 
        data = d; 
        next = s; 
    }   
}

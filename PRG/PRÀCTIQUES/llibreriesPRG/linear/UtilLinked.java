package linear;

/**
 * Classe UtilLinked: classe d'utilitats que conté operacions amb
 * seqüències enllaçades.
 * 
 * @author PRG 
 * @version Curs 2017/18
 */
public class UtilLinked {
    
    /** No hi ha objectes d'aquesta classe. */ 
    private UtilLinked() { }
    
    /**
     * Satura les dades d'una seqüència donada a un valor màxim.
     * @param sec NodeInt seqüència origen.
     * @param maxim int a saturar. 
     */
    public static void saturar(NodeInt sec, int maxim) {
        NodeInt aux = sec; 
        while (aux != null) { 
            if (aux.data > maxim) { aux.data = maxim; }
            aux = aux.next; 
        }
    }
            
    /**
     * Torna el màxim d'una seqüència donada amb, al menys, un node.
     * @param sec NodeInt seqüència original.
     * @return int valor màxim de la seqüència.
     */
    public static int maxim(NodeInt sec) {
        int max = sec.data;
        NodeInt aux = sec;
        while(aux != null) {
			if(max < aux.data) { max = aux.data; }
			aux = aux.next;
        }
        return max;
    }
    
    /** Torna el nombre d'elements de la seqüència sec.
     *  @param sec NodeInt seqüència origen.
     *  @return int nombre d'elements de sec.
     */
    public static int talla(NodeInt sec) {
        int res = 0;
        NodeInt aux = sec;
		while(aux != null) {
			res++;
			aux = aux.next;
		}
        return res;
    }
    
    /** Torna en un array del tamany just els elements de la seqüència sec.
     *  @param sec NodeInt seqüència origen.
     *  @return int[] array amb els elements de sec.
     */
    public static int[] toArray(NodeInt sec) {
        int[] res = new int[talla(sec)];
        NodeInt aux = sec;
		int i = 0;
		while(aux != null ) {
			res[i] = aux.data;
			i++;
			aux = aux.next;
		}
        return res;
    }
    
    /** Torna en una seqüència els elements d'un array a.
     *  @param a array d'enters seqüència origen.
     *  @return NodeInt seqüència amb els elements de l'array a.
     */
    public static NodeInt toSeq(int[] a) {
        NodeInt sec = null, aux = null;
		sec = new NodeInt(a[0]);
		aux = sec;
        int i = 1;
		while(i < a.length) {
			aux.data = a[i];
			i++;
			aux = aux.next;
		}
        return sec;
    }
    
    /**
     * Torna la posició de la primera ocurrència d'un valor d en 
     * una seqüència donada sec.
     * @param sec NodeInt seqüència origen.
     * @param d int a buscar. 
     * @return int posició que ocupa d en la seqüència o -1 si no està.
     */
    public static int buscar(NodeInt sec, int d) {
        NodeInt aux = sec;
        int i = -1;
        while(aux != null && aux.data != d) {
            i++;
            aux = aux.next;
            if(aux.next == null) {
                i = -1;
            }
        }
        return i; 
    }
    
    /**
     * Donada una seqüència, insereix la dada d en la posició i, 
     * sempre que 0<=i<=n.
     * @param sec NodeInt seqüència origen.
     * @param d int a inserir. 
     * @param i int posició on inserir 0<=i<=n.
     * @return NodeInt seqüència resultat.
     */
    public static NodeInt inserir(NodeInt sec, int d, int i) {
        if (i == 0) { sec = new NodeInt(d, sec); }
        else { 
            NodeInt aux = sec; 
            int k = 0;
            while (aux != null && k < i - 1) {
                aux = aux.next; 
                k++;
            }
            if (aux != null) { // Èxit en la cerca 
                aux.next = new NodeInt(d, aux.next);
            }
        }    
        return sec;
    }
    
    /**
     * Donada una seqüència, insereix recursivament la dada d en la 
     * posició i, sempre que 0<=i<=n.
     * Es distingeixen els dos casos següents:
     * - Seqüència amb n = 0 nodes, sec==null. S'insereix en cap de sec, 
     *   només si i==0.
     * - Seqüència amb n > 0 nodes. Si i==0, s'insereix en cap de sec, 
     *   sino el problema es redueix a inserir en la posició i-1 de la 
     *   subseqüència sec.next.
     * @param sec NodeInt seqüència origen.
     * @param d int a inserir. 
     * @param i int posició on inserir 0<=i<=n.
     * @return NodeInt seqüència resultat.
     */
    public static NodeInt inserirRec(NodeInt sec, int d, int i) {
        if (sec == null) {
            if (i == 0) { sec = new NodeInt(d); }
        }
        else {
            if (i == 0) { sec = new NodeInt(d, sec); }
            else { sec.next = inserirRec(sec.next, d, i - 1); }
        }
        return sec;
    }
    
    /**
     * Donada una seqüència tal que les seues dades estan ordenades 
     * de menor a major, insereix la dada d mantenint l'ordenació.
     * @param sec NodeInt seqüència origen.
     * @param d int a inserir. 
     * @return NodeInt seqüència resultat.
     */
    public static NodeInt inserirOrd(NodeInt sec, int d) {
        NodeInt aux = sec, ant = null; // el primer node no té 
                                       // anterior definit 
        while (aux != null && aux.data < d) { 
            ant = aux; 
            aux = aux.next; 
        } 
        
        // Acabada la cerca: 
        // Cas a) aux==sec, sec està buida o 
        //        totes les seues dades són >=d. 
        // Cas b) aux!=sec (o ant!=null), 
        //        no totes les seues dades són >=d. 
        // La inserció darrere de ant situa el nou node 
        // a continuació de totes les dades <d.
        if (aux == sec) { sec = new NodeInt(d, sec); } // Cas a) 
        else { ant.next = new NodeInt(d, aux); } // Cas b)
        return sec;
    }
    
    /**
     * Donada una seqüència tal que les seues dades estan ordenades 
     * de menor a major, insereix recursivament la dada d mantenint 
     * l'ordenació. Es distingeixen els dos casos següents:
     * - Seqüència amb n = 0 nodes, sec==null. S'insereix en cap de sec. 
     *   La dada d és el primer que s'insereix en sec.
     * - Seqüència amb n > 0 nodes. Si sec.data>=d, s'insereix en cap 
     *   de sec, sino el problema es redueix a inserir ordenadament en 
     *   la subseqüència sec.next. 
     * @param sec NodeInt seqüència origen.
     * @param d int a inserir. 
     * @return NodeInt seqüència resultat.
     */
    public static NodeInt inserirOrdRec(NodeInt sec, int d) {
        if(sec == null) {
            sec = new NodeInt(d, sec);
        } else if(sec.data >= d){
            sec.next = inserirOrdRec(sec.next, d);
        }
        return sec;
    }
    
    /**
     * Donada una seqüència enllaçada, esborra, si existeix, la primera 
     * ocurrencia d'una dada d. Si aquest element no apareix, no es fa res.
     * @param sec NodeInt seqüència origen.
     * @param d int a esborrar. 
     * @return NodeInt seqüència resultat.
     */
    public static NodeInt esborrar(NodeInt sec, int d) {
        NodeInt aux = sec, ant = null;
        while (aux != null && aux.data != d) {
            ant = aux;
            aux = aux.next;
        }
        if (aux != null) { // Èxit en la cerca
            if (ant == null) { // o aux == sec -aux és el primer node-
                sec = aux.next;
            }
            else { ant.next = aux.next; }
        }
        // El paràmetre sec pot haver canviat, 
        // cal tornar el seu valor:
        return sec;
    }
    
    /**
     * Donada una seqüència enllaçada, esborra recursivament, 
     * si existeix, la primera ocurrencia d'una dada d. 
     * Si aquest element no apareix, no es fa res.
     * Es distingeixen els dos casos següents:
     * - Seqüència amb n = 0 nodes, sec==null. La dada d no està  
     *   en sec, no es fa cap esborrament.
     * - Seqüència amb n > 0 nodes. Si es troba d en cap (primera 
     *   ocurrència de d en la seqüència), s'esborra el primer node
     *   de sec; sino el problema es redueix a esborrar la primera 
     *   ocurrència de d en la subseqüència sec.next.  
     * @param sec NodeInt seqüència origen.
     * @param d int a esborrar. 
     * @return NodeInt seqüència resultat.
     */
    public static NodeInt esborrarRec(NodeInt sec, int d) {
        if (sec != null) {
            if (sec.data == d) { sec = sec.next; }
            else { sec.next = esborrarRec(sec.next, d); }
        }
        return sec;
    }    
    
    /**
     * Donada una seqüència enllaçada, esborra els elements menors 
     * que un umbral donat. 
     * @param sec NodeInt seqüència origen.
     * @param umbral int a comparar. 
     * @return NodeInt seqüència resultat.
     */
    public static NodeInt esborrarMenors(NodeInt sec, int umbral) { 
        NodeInt aux = sec, ant = null; 
        while (aux != null) { 
            if (aux.data < umbral) { // node a esborrar 
                if (aux == sec) { sec = sec.next; }
                else { ant.next = aux.next; }
                // ant no s’actualitza 
            } 
            else { ant = aux; }
            aux = aux.next; 
        } 
        // El paràmetre sec pot haver canviat, 
        // cal tornar el seu valor: 
        return sec;
    }
    
    /**
     * Donada una seqüència enllaçada, esborra recursivament 
     * els elements menors que un umbral donat. 
     * Es distingeixen els dos casos següents:
     * - Seqüència amb n = 0 nodes, sec==null. No hi ha dades 
     *   en sec, no es fa cap esborrament.
     * - Seqüència amb n > 0 nodes. S'esborren recursivament 
     *   els elements menors que umbral en la subseqüència 
     *   sec.next. Si l'element en el cap es menor que umbral, 
     *   s'esborra; sino dit element s'enllaça amb la subseqüència 
     *   resultat de l'esborrament. 
     * @param sec NodeInt seqüència origen.
     * @param umbral int a comparar. 
     * @return NodeInt seqüència resultat.
     */
    public static NodeInt esborrarMenorsRec(NodeInt sec, int umbral) { 
        if (sec != null) {
            NodeInt result = esborrarMenorsRec(sec.next, umbral);
            if (sec.data < umbral) { sec = result; }
            else { sec.next = result; }
        }
//         // O també:
//         if (sec != null) {
//             if (sec.data < umbral) { 
//                 sec = sec.next; 
//                 sec = esborrarMenorsRec(sec, umbral);
//             }
//             else {sec.next = esborrarMenorsRec(sec.next, umbral); }
//         }
        return sec;        
    }
    
    /**
     * Desplaça tots els elements d'una seqüència donada, 
     * una posició cap a la dreta. 
     * L'últim element passarà a ser el primer.
     * @param sec NodeInt seqüència a desplaçar.
     * @return NodeInt seqüència desplaçada.
     */
    public static NodeInt moureADreta(NodeInt sec) {
        if (sec != null && sec.next != null) { // hi ha, al menys, 2 nodes
            /* COMPLETAR */
        }
        return sec;
    }
    
    /**
     * Desplaça tots els elements d'una seqüència donada, 
     * una posició cap a l'esquerra. 
     * El primer element passarà a ser l'últim.
     * @param sec NodeInt seqüència a desplaçar.
     * @return NodeInt seqüència desplaçada.
     */
    public static NodeInt moureAEsq(NodeInt sec) {
        if (sec != null && sec.next != null) { // hi ha, al menys, 2 nodes
            /* COMPLETAR */
        }
        return sec;
    }
    
    /**
     * Inverteix l'ordre dels elements d'una seqüència donada 
     * (amb cost lineal).
     * @param sec NodeInt seqüència a invertir.
     * @return NodeInt seqüència invertida.
     */
    public static NodeInt invertir(NodeInt sec) {
        /* COMPLETAR */
        return sec;
    }
    
    /** 
     * Torna una seqüència enllaçada amb els elements menors que e,
     * i en el mateix ordre que apareixen en una seqüència donada sec.
     * El cost serà lineal amb la longitud de sec.
     * @param sec NodeInt seqüència origen.
     * @param e int a comparar.
     * @return NodeInt seqüència enllaçada amb els elements menors que e, 
     *         en el mateix ordre que apareixen en la seqüència original.
     */ 
    public static NodeInt menorsQue(NodeInt sec, int e) {
        NodeInt aux = sec, nova = null, ultim = null;
        /* COMPLETAR */
        return nova;
    }
}

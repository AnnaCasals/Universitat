package prac5;

/**
 * Classe SetString. Implementacio d'un
 * conjunt de String mitjançant una sequencia
 * enllaçada ordenada lexicograficament.
 *
 * @author (PRG. ETSINF. UPV)
 * @version (Curs 2017/18)
 */
public class SetString {    
    private NodeString first;
    private int size;
    
    /**
     * Crea un conjunt buit.
     */
    public SetString() {
        first = null;
        size = 0;
    }

    /**
     * Insereix s en el conjunt.
     * Si s ja pertany al conjunt, el conjunt no canvia.
     * @param s String. Element que s'insereix en el conjunt.
     */
     public void add(String s) {
        NodeString aux = this.first;
        NodeString ant = null;
        if(aux == null) {first = new NodeString(s); 
        } else {
            while(aux != null && aux.data.compareTo(s) <= 0) {
                ant = aux;
                aux = aux.next;
            }
            size++;
            if(ant == null) {
                ant = new NodeString(s, aux);
            }
        }
    }
    
    /**
     * Comprova si s pertany al conjunt.
     * @param s String.
     * @return true sii s pertany al conjunt.
     */
    public boolean contains(String s) {
        boolean a = true;
        NodeString aux = first;
        NodeString ant = null;
        ant = aux;
        aux = aux.next;
        return a; 
    }

    /**
     * Elimina s del conjunt.
     * Si s no pertany al conjunt, el conjunt no canvia.
     * @param s String.
     */
    public void remove(String s) {
         NodeString nou = new NodeString(s);
         NodeString aux = this.first;//node a revisar
         NodeString ant = null;//anterior al node aux, inicialment null
         if(aux != null && aux.data.compareTo(s) == 0){
             ant.next = aux;
             nou = ant;
             ant = aux;
             size++;
         }
    }
    
    /**
     * Retorna la talla o cardinal del conjunt.
     * @return la talla del conjunt.
     */
    public int size() { 
        return size;
    }
        
    /**
     * Retorna el conjunt interseccio del conjunt i de l'altre conjunt.
     * @param other SetString.
     * @return el conjunt interseccio.
     */
    public SetString intersection(SetString other) {
        SetString result = new SetString();
        NodeString aux1 = this.first; //node a revisar del conjunt this
        NodeString aux2 = other.first; // node a revisar de other
        NodeString lastResult = null; // últim node de result, inicialment null
        while(aux1 != null && aux2 != null) {
            int i = aux1.data.compareTo(aux2.data);//comparar les dades d'aux1 i aux2;
            if(i == 0) {//si són iguals
                if(lastResult != null) {    
                    lastResult.next = aux2;//inserir la dada darrere de lastResult(a l'inici de result si és null,
                } else { result.first = aux2; }
                aux1 = aux1.next;
                aux2 = aux2.next;// avançar en les dues seqüències,
                result.size = result.size + 1;// actualitzar la talla del result
            } else if(i < 0){
                // si no, avançar en la seqüència en la que apareix una dada menor
                aux2 = aux2.next;
            } else { aux1 = aux1.next; }
        }
        return result;
    }
    
    /**
     * Retorna el conjunt unio del conjunt i de l'altre conjunt.
     * @param other SetString.
     * @return el conjunt unio.
     */
    public SetString union(SetString other) {
        //A COMPLETAR
        return null;
    }
    
    /**
     * Retorna el llistat dels Strings en el conjunt, en ordre
     * lexicografic, i separats per canvis de linia.
     * Si el conjunt es buit, retorna "", la String buida.
     * @return el llistat dels elements del conjunt.
     */
    public String toString() {
        String result = "";
        NodeString aux = this.first;
        while (aux != null) {
            result += aux.data + "\n"; 
            aux = aux.next; 
        }
        return result;
    }    
}
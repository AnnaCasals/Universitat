/**
 * Classe ConjuntString. Implementacio d'un
 * conjunt de String mitjancant una sequencia
 * enllasada ordenada lexicograficament.
 *
 * @author (PRG. ETSINF. UPV)
 * @version (Curs 2016/17)
 */
public class ConjuntString {
    
    private NodeString primer;
    private int talla;
    
    /**
     * Crea un conjunt buit.
     */
    public ConjuntString() {
        primer = null;
        talla = 0;
    }

    /**
     * Insereix s en el conjunt.
     * Si s ja pertany al conjunt, aquest no canvia.
     *
     * @param s String. Element que s'insereix en el conjunt.
     */
    
    public void inserir(String s) {
        NodeString nou = new NodeString(s);
        NodeString aux = this.primer;
        NodeString ant = null;
        while(aux != null && aux.dada.compareTo(s) >= 0){
            ant = aux;
            aux = ant.seguent;
        }
        nou.seguent = aux;
        ant.seguent = nou;
        talla++;
        
    }
    
    
    /**
     * Comprova si s pertany al conjunt.
     *
     * @param s String.
     * @return true sii s pertany al conjunt.
     */
    public boolean pertany(String s) {
       boolean a = true;
       NodeString aux = primer;
       
           NodeString ant = null;
           ant = aux;
           aux = aux.seguent;
       
       return a; 
    }
       
    /**
     * Elimina s del conjunt.
     * Si s no pertany al conjunt, el conjunt no canvia.
     *
     * @param s String.
     */
    public void eliminar(String s) {
        NodeString nou = new NodeString(s);
        NodeString aux = this.primer;//node a revisar
        NodeString ant = null;//anterior al node aux, inicialment null
        if(aux != null && aux.dada.compareTo(s) == 0){
            ant.seguent = aux;
            nou = ant;
            ant = aux;
            talla++;
              // A completar
            }
        
    }
    
    /**
     * Retorna la talla o cardinal del conjunt.
     * @return la talla del conjunt.
     */
    public int talla() { 
        return talla;   
    }
    
    
    /**
     * Retorna el conjunt interseccio del conjunt i d'altre.
     *
     * @param altre ConjuntString.
     * @return el conjunt interseccio.
     */
    public ConjuntString interseccio(ConjuntString altre) {
        // A completar
        return null;
    }
    /**
     * Retorna el conjunt unio del conjunt i d'altre.
     *
     * @param altre ConjuntString.
     * @return el conjunt unio.
     */
    public ConjuntString unio(ConjuntString altre) {
        // A completar
        return null;
    }
    
        
    /**
     * Retorna el llistat de les Strings en el conjunt, en ordre
     * lexicografic, i separats per canvis de linia.
     * Si el conjunt es buit retorna "", la String buida.
     *
     * @return llistat dels elements del conjunt.
     */
    public String toString() {
        String result = "";
        NodeString aux = this.primer;
        while (aux != null) {
            result += aux.dada + "\n"; 
            aux = aux.seguent; 
        }
        return result;
    }
    
}

/**
 * Classe BonoMetro: representa el títol de transport 
 * amb el que se pot viatjar al metro.
 * 
 * @author IIP 
 * @version Curs 2016-17
 */
public class BonoMetro {
    /** Quantitat per defecte de recàrrega */ 
    public static final int BONO_10 = 10;
    // Un BonoMetro TÉ UN ...
    private int numTiquets;

    /** Crea un BonoMetro amb un nombre de tiquets o viatges donat. 
     *  @param n int, el nombre de tiquets.  
     */
    public BonoMetro(int n) { numTiquets = n; }
    
    /** Crea un BonoMetro, per defecte, amb 10 tiquets. */
    public BonoMetro() { this(BONO_10); }

    /** Torna el número de tiquets o viatges disponibles. 
     *  @return int, el nombre de tiquets disponibles.  
     */
    public int getNumTiquets() { return numTiquets; }

    /** Carrega el bonometro amb una quantitat donada de viatges.
     *  @param quantitat int, la quantitat de viatges.
     */
    public void recarregar(int quantitat) { numTiquets += quantitat; }

    /** Torna un String amb la informació del bonometro, 
     *  en el format "Bono amb xxx tiquets".
     *  @return String.  
     */
    public String toString() { 
        return "Bono amb " + numTiquets + " viatges"; 
    }

    /** Si queden viatges, actualitza el nombre de tiquets 
     *  i torna el missatge "Bono amb xxx tiquets". Si no queden 
     *  viatges torna el missatge "Bono esgotat. Recàrrega'l JA!" 
     *  @return String.    
     */
    public String picar() {
        if (numTiquets > 0) {
            numTiquets--;
            return this.toString();  
        }
        else { return "Bono esgotat. Recàrrega’l JA!"; }
    }    
}

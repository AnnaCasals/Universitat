import java.io.Serializable;
/**
 * Classe NodeInt. Representa cadascun dels nodes 
 * d'una sequencia enllaçada de valors de tipus int.
 * @author PRG
 * @version Curs 2015/16
 */
class NodeApunt implements Serializable {
    Apunt dada;
    NodeApunt seguent;

    /** Constructor que permet crear un node amb un int i un node seguent.
     *  @param d int que conte el node.
     *  @param seguent Referencia al seguent node de la llista.
     */
    NodeApunt(Apunt d, NodeApunt seg) {
        this.dada = d;
        this.seguent = seg;
    }

    /** Constructor que permet crear un node amb un int i
     *  el seu node seguent es null.
     *  @param d int que conte el node.
     */
    NodeApunt(Apunt d) {
        this(d, null);
    }
}

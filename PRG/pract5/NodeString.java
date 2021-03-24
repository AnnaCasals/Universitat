
/**
 * Write a description of class NodeString here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NodeString {
   public String dada;
   public NodeString seguent;
   
   public NodeString(String d){
       dada = d;
       seguent = null;
   }
    
   public NodeString(String d, NodeString s) {
        dada = d;
        seguent = s;
   }
}

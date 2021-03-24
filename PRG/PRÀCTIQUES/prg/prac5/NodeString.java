package prac5;


/**
 * Escriviu aquí una descripcìó de la classe NodeString
 * 
 * @author (el vostre nom) 
 * @version (un número de versió o la data)
 */
public class NodeString {
    public String data;
    public NodeString next;
   
    public NodeString(String d){
        data = d;
        next = null;
    }
    
    public NodeString(String d, NodeString s) {
         data = d;
         next = s;
    }
}

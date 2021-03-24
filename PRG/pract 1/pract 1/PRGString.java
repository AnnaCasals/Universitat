
/**
 * Write a description of class PRGString here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PRGString {
    public static boolean esPrefixe(String a, String b) { 
        if (a.length() == 0) { return true; }
        else if(a.length() > b.length()) { return false; }
        else if(a.charAt(0) == b.charAt(0)) {
            return esPrefixe(a.substring(1, a.length()), b.substring(1, b.length()));
        } else { return false; }
    
    }
    
    public static boolean esPrefixe2(String a, String b){
        if (a.length() > b.length()) return false;
        else {
            int pos;
            for(pos = 0; pos < a.length() && a.charAt(pos) == b.charAt(pos); pos++);
            return pos == a.length();
        }
    }
    
    public static boolean esSubcadena(String a, String b){
        if (a.length() > b.length()) return false;
        else if (esPrefixe(a, b)) return true;
        else return esSubcadena(a, b.substring(1, b.length()));
    }
    
    /**public static boolean esPalindrom(String a) {

         if (a.length() == 0 || a.length() == 1)  { return true; }
         else if (a.charAt(0)  == a.charAt(0, a.length() - 1)) {
             a = a.
             return esPalindrom(a.substring(1, a.length()-1));
         } else { return false; }
        }*/
    }


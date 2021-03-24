package prac2;

/**
 * Escriviu aquí una descripcìó de la classe Test
 * 
 * @author (el vostre nom) 
 * @version (un número de versió o la data)
 */
public class Test {

    public static void main(String[] argsB){
        String a = "";
        String b = "re";
        String c = "123";
        String d = "recursion";
        String e = "percusion";
        String f = "remursi";
        String g = "metre";
        String h = "treball";
        
        if (PRGString.isPrefix(a, b) && PRGString.isPrefix(a, a) && PRGString.isPrefix(b, d) 
        && PRGString.isPrefix(d, d) && !PRGString.isPrefix(c, d) && !PRGString.isPrefix(d, b)
        && !PRGString.isPrefix(e, d) && !PRGString.isPrefix(f, d)) {
            System.out.println("El mètode isString va CORRECTAMENT");
        } else { System.out.println("Hi ha alguna ERRADA en el mètode isString"); }
        
        if(PRGString.isSubstring(a, b) && PRGString.isSubstring(b, d) && PRGString.isSubstring(b, g)
        && PRGString.isSubstring(b, g) && PRGString.isSubstring(b, h) && !PRGString.isSubstring(b, c)
        && !PRGString.isSubstring(b, e)) { System.out.println("El mètode isSubstring va CORRECTAMENT");
        } else { System.out.println("Hi ha alguna ERRADA en el mètode isSubstring"); }
    }
}

/**
 * Classe Menjar: representa un menjar amb les seues calories
 * i el seu temps de preparació en minuts.
 * 
 * @author IIP 
 * @version Curs 2016/17
 */
public class Menjar {
    // Un Menjar TÉ ...
    private double calories;
    private int minutsPrep;

    /**
     * Crea un Menjar amb un nombre de calories i
     * minuts de preparació donats.
     * @param c double, les calories.
     * @param m int, els minuts de preparació.
     */
    public Menjar(double c, int m) {
        calories = c; minutsPrep = m;
    }

    /** Torna les calories del Menjar.
     *  @return double, les calories.
     */
    public double getCalories() { return calories; }
    
    /** Torna els minuts de preparació del Menjar. 
     *  @return int, els minuts.  
     */
    public int getMinutsPrep() { return minutsPrep; }
    
    /** Actualitza les calories del Menjar a c. 
     *  @param c double, les noves calories.  
     */
    public void setCalories(double c) { calories = c; }
    
    /** Actualitza els minuts de preparació del Menjar a m.
     *  @param m int, els nous minuts de preparació.  
     */
    public void setMinutsPrep(int m) { minutsPrep = m; }
    
    /** Torna un String amb la informació del menjar,
     *  en el format:
     *  "Menjar amb ccc cal. i mmm min. de preparació" 
     *  @return String.
     */
    public String toString() {
        return "Menjar amb " + calories + " cal. i " 
            + minutsPrep + " min. de preparació";
    }
    
    /**
     * Torna un número negatiu si el Menjar és més sà 
     * que un altre, un zero si són igual de sans i
     * un número positiu si el més sà és l'altre.
	 * Un menjar és més sà que un altre si aporta menys 
	 * calories que l’altre i, a igualtat de calories, 
	 * si se prepara en un temps menor que l’altre.
     * @param altre Menjar a comparar.
     * @return int.
     */
    public int compareTo(Menjar altre) {
        // Primera versió
        // int res = 0;
        // if (calories < altre.calories) { res = -1; }
        // else if (calories > altre.calories) { res = 1; }
        // else if (minutsPrep < altre.minutsPrep) { res = -1; }
        // else if (minutsPrep > altre.minutsPrep) { res = 1; }
        // return res;        
      
        // Segona versió
        // int res = minutsPrep - altre.minutsPrep;
        // if (calories < altre.calories) { res = -1; }
        // else if (calories > altre.calories) { res = 1; }
        // return res;
        
        // Tercera versió:
        double difCalories = Math.signum(calories - altre.calories);
        int res = minutsPrep - altre.minutsPrep;
        if (difCalories != 0) { res = (int) difCalories; }
        return res;
    }
    
}

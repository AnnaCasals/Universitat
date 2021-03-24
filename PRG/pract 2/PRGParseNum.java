/**
 * PRGParseNum: Pràctica 2 de PRG.
 * 
 * @author (professors IIP - PRG) 
 * @version (curs 2016-17)
 */
public class PRGParseNum {
    
    /*************************** CODI INICIAL  ***************************/    
    public static final char PUNT = '.';  // Separador part fraccionària.
    public static final char COMA = ',';  // Separador part fraccionària.
    public static final char EXP1 = 'e';  // Separador part exponencial.
    public static final char EXP2 = 'E';  // Separador part exponencial.
    public static final int  BASE = 10;   // Base de numeració per defecte.
    
    /**
     * Torna l'enter associat al caràcter - dígit en c.
     * @param c char.
     * @return int, valor del dígit.
     * PRECONDICIÓ: '9' >= c >= '0'
     */
    public static int parseDig(char c) {
        return c - '0';
        // alternativament, es pot fer servir:
        // return Character.getNumericValue(c);
    }
    
    
    /************************* EXEMPLES INICIALS *************************/    
       
    /** Torna la suma dels dígits continguts en la String que rep.
     *  @param s String, cadena de caràcters sobre els quals s'opera.
     *  @return int. 
     */
    public static int sumaDigits(String s) {
        // Cas base: String buida
        if (s.length() == 0) { return 0; }
        else {
            // Cas general: String no buida. Tractar substring posterior.
            char c = s.charAt(0);
            if (c >= '0' && c <= '9') {
                return (c - '0') + sumaDigits(s.substring(1));
            }
            else { return sumaDigits(s.substring(1)); }
        }
    }
        
    /** Torna la suma dels dígits en la String s des de la posició pos.
     *  PRECONDICIÓ: pos >= 0.
     *  @param s String, cadena de caràcters sobre els quals s'opera.
     *  @param pos int, posició en s des d'on es treballa.
     *  @return int. 
     */
    public static int sumaDigits(String s, int pos) {
        // Cas base: String buida
        if (pos >= s.length()) { return 0; }
        else {
            // Cas general: String no buida. Tractar substring posterior.
            char c = s.charAt(pos);
            if (c >= '0' && c <= '9') {
                return (c - '0') + sumaDigits(s, pos + 1);
            }
            else { return sumaDigits(s, pos + 1); }
        }
    } 
    
    /** Torna la suma dels dígits continguts en la String que rep.
     *  @param s String, cadena de caràcters sobre els quals s'opera.
     *  @return int. 
     */
    public static int sumaDigits2(String s) {
        // Cas base: String buida
        if (s.length() == 0) { return 0; }
        else {
            // Cas general: String no buida. Tractar substring anterior.
            int len = s.length();
            char c = s.charAt(len - 1);
            if (c >= '0' && c <= '9') {
                return (c - '0') + sumaDigits(s.substring(0, len - 1));
            }
            else { return sumaDigits(s.substring(0, len - 1)); }
        }
    }  
    
    /****************** PROBLEMA A: parseInt(String s) ******************/
        
    /** 
     * EXEMPLE, "1234", amb anàlisi DESCENDENT:
     *   s                    s.charAt(s.length() - 1) - '0'   
     * "1234"      123*10   +        4                      = 1234 
     * "123"       12*10    +        3                      =  123 
     * "12"        1*10     +        2                      =   12 
     * "1"         1                                        =    1  
     * 
     * EXEMPLE, "1234", amb anàlisi ASCENDENT:
     *   s    s.charAt(0) - '0'   Math.pow(10, s.length() - 1)
     * "1234"       1         *         10^3                = 1000 +
     *  "234"       2         *         10^2                =  200 +
     *   "34"       3         *         10^1                =   30 +
     *    "4"       4                                       =    4 
     *                                                       _____
     *                                                        1234    
     * PRECONDICIÓ: s conté un enter, >= 0, ben format. 
     */
    public static int parseUnsignedInt(String s) {
        // Cas Base (Només hi ha un número)
        if (s.length() == 1) {
            char a = s.charAt(0); 
            return parseDig(a); // Ho pasem a int;
        } else { // Cas General
            // Ens quedem en la subcadena de la esquerra, en tots menys el últim
            String b = s.substring(0, s.length() - 1);
            // Ja cridem recursivament per a la subcadena, ho multipliquem per 10
            // i li sumem l'últim número pasat a int
            return parseUnsignedInt(b) * 10 + parseDig(s.charAt(s.length() - 1));
        }
    }  
    
    /** 
     * PRECONDICIÓ: s conté un enter, pot ser amb signe, ben format. 
     */ 
    public static int parseInt(String s) {
        if (s.charAt(0) == '-') {
            s = s.substring(1, s.length());
            return -parseUnsignedInt(s);
        } 
        if (s.charAt(0) == '+') {
            s = s.substring(1, s.length());
            return parseUnsignedInt(s);
        } else {
            return parseUnsignedInt(s);
        }
    }    
    
    /**************** PROBLEMA B: parseDouble(String s) *****************/    
    
    /** 
     * PRECONDICIÓ: s conté un nombre en coma flotant ben format. 
     */ 
    // 53.25
    //.25
    //
    public static int posFracSep(String s) {
        // Casos: 1- No hi ha coma; 2 - La coma està al principi; 3 - Coma pel mig;
        int i = 0;
        while(i < s.length() && s.charAt(i) != COMA && s.charAt(i) != PUNT) { i++; }
        return i;
    }
    
    /** 
     * PRECONDICIÓ: s, conté els dìgits de la part fraccionària
     * d'un valor double ben format. 
     */
    public static double parseFrac(String s) {
        int a = parseInt(s);
        int b = s.length();
        double c = Math.pow(10.0, b);
        return a / c;
    }
    
    /** 
     * PRECONDICIÓ: s conté un double, ben format, pot ser amb signe, 
     * que pot tenir (o no) part fraccionària. No conté part exponencial.
     */ //Nose fer-ho amb signe
    public static double parseDouble(String s)   {
        int a = posFracSep(s); //On està la coma
        String b = s.substring(0, a); //Part entera del numero
        int enter = parseUnsignedInt(b); //enter de la part entera
        String c = s.substring(a + 1, s.length());//Part decimal
        double decimal = parseFrac(c);//enter de la part decimal
        return enter + decimal; 
    }
    
    
    /*******************  AMPLIACIONS RECOMANADES  ********************/
    
    
    
    
    
}

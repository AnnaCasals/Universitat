 

/**
 * Classe Hospital: permet representar la informacio dels pacients 
 * que ocupen els llits d'un hospital.
 * 
 * @author IIP
 * @version Curs 2016/17
 */
public class Hospital {
    /** Constant que representa el numero maxim de pacients que 
     *  poden passar per qualsevol hospital. */    
    public static final int MAX_PACIENTS = 5000;
    /** Constant que representa el numero maxim de llits de 
     *  qualsevol hospital. */
    public static final int MAX_LLITS = 200;
    /** Atribut que permet representar tots els llits de 
     *  l'hospital actual. */     
    private Pacient[] llits;
    /** Atribut que representa el numero actual de llits 
     *  lliures de l'hospital actual. */
    private int lliures;
    /** Atribut que representa el numero actual de llits 
     *  ocupats per pacients critics a l'hospital actual. */
    private int critics;
    /** Atribut que permet representar tots els NIF dels 
     *  pacients que han estat a l'hospital actual. */
    private String[] historic;
    /** Atribut que representa el numero de pacients que 
     *  han estat fins ara a l'hospital actual. */
    private int pacients;
    
    /**
     * Crea un {@code Hospital} amb tots els llits lliures,
     * sense pacients critics ni historic de pacients.
     */
    public Hospital() {
        llits = new Pacient[MAX_LLITS + 1];
        lliures = MAX_LLITS;
        critics = 0;
        historic = new String[MAX_PACIENTS];
        pacients = 0;
    } 
    
    /**
     * Torna el numero de llits lliures de l'hospital. 
     * @return {@code int}, el numero de llits lliures.
     */
    public int getLliures() { return lliures; }
    
    /**
     * Torna el numero de pacients en l'historic de l'hospital. 
     * @return {@code int}, el numero de pacients en l'historic.
     */
    public int getPacientsHistoric() { return pacients; }
    
    /**
     * Torna el numero de llits ocupats per pacients critics 
     * a l'hospital.
     * @return {@code int}, el numero de llits ocupats per pacients 
     * critics.
     */
    public int getCritics() { return critics; }
    
    /**
     * Torna {@code true} si a l'hospital hi ha llits lliures i 
     * torna {@code false} en cas contrari.
     * @return {@code boolean}, {@code true} si a l'hospital hi ha 
     * llits lliures i {@code false} en cas contrari.
     */
    public boolean hiHaLliures() { return lliures != 0; } 
    
    /**
     * Torna el numero del primer llit lliure de l'hospital si hi ha 
     * llits lliures o torna {@code -1} si no hi ha.
     * @return {@code int}, numero del primer llit lliure de l'hospital 
     * si hi ha llits lliures o {@code -1} si no hi ha.
     */
    public int primerLliure() {
        int res = 0;
       if(this.hiHaLliures()) {
           int i = 1;
           while(i < llits.length && llits[i] != null) {
               i++;
           }
           if(i < llits.length){ res = i; }
           else { res = -1; }
       } 
       return res;
    }

    
    /**
     * Donat un NIF {@code nif}, comprova si esta a l'historic de NIF 
     * de l'hospital. Si esta, torna la posicio que ocupa a l'array 
     * historic. En cas contrari, torna -1 indicant que no s'ha trobat. 
     * @param nif {@code String}, el NIF del pacient a cercar.
     * @return {@code int}, la posicio que ocupa a l'historic o 
     * {@code -1} si no esta.
     */
    private int cercar(String nif) {
        int i = 0;
        while(i < pacients && !nif.equals(historic[i])) {
            i++;
        }
        if(i < pacients) { return i; }
        else { return -1;}
       
    }
    
    /**
     * Donat un {@link Pacient}, si el seu NIF no esta en l'historic, 
     * l'afegeix. 
     * @param p {@code Pacient}, el pacient.
     */
    private void afegirHistoric(Pacient p) {
        int pos = cercar(p.getNif());
        if(pos == -1) {
            historic[pacients++] = p.getNif();
        }
    }

    /**
     * Si hi ha llits lliures, el primer d'ells (el de numero menor) 
     * passa a estar ocupat pel pacient de nif {@code nif}, 
     * nom {@code nom} i edat {@code edat}. Si el pacient no esta a 
     * l'historic, l'afegeix. Torna {@code true} si s'ha fet l'ingres 
     * o torna {@code false} en cas contrari (si no hi ha llits lliures).
     * @param nif {@code String}, el NIF.
     * @param nom {@code String}, el nom.
     * @param edat {@code int}, l'edat.
     * @return {@code boolean}, {@code true} si s'ha fet l'ingres 
     * o {@code false} en cas contrari.
     */
    public boolean ingresarPacient(String nif, String nom, int edat) {
        Pacient a = new Pacient(nif, nom, edat);
        int b = primerLliure();
        boolean c = false;
        if(b != -1) {
            llits[b] = a;
            afegirHistoric(a);
            return c = true;
        }
        return c;
    } 
   
    /**
     * Torna el {@link Pacient} que ocupa el llit {@code i} de 
     * l'hospital actual o {@code null} si el llit esta lliure. 
     * @param i {@code int}, el numero de llit.
     * @return {@code Pacient}, el pacient que ocupa el llit 
     * {@code i} o {@code null} si el llit esta lliure.
     */
    public Pacient getPacient(int i) {
        return llits[i];
    }
    
    /**
     * El llit {@code i} de l'hospital passa a estar lliure.
     * @param i {@code int}, el numero de llit.
     */
    private void donarAltaPacient(int i) {
       llits[i] = null;
       lliures--;
    } 
    
    /**
     * Es suministra el {@code tractament()} a tots els pacients 
     * de l'hospital i a aquells pacients sans (l'estat dels 
     * quals es {@code 5}) se'ls dona l'alta medica 
     * (s'invoca a {@code donarAltaPacient(int)}).
     */
    public void donarAltes() {
        for(int i = 0; i < llits.length; i++) {
            llits[i].tractament();
            if(getEstat() == 5) {
                donarAltaPacient(i);
            }
        }
        
    } 

    /**
     * Torna un {@code String} que descriu l'hospital, es a dir, 
     * quins pacients ocupen quins llits i quins llits estan lliures. 
     * Si no hi ha pacients a l'hospital torna 
     * {@code "Hospital buit"}.
     * @return {@code String}, el resultat.
     */
    public String toString() {
    
    }    
         
    /**
     * Torna un array amb els numeros de llit ocupats pels pacients 
     * critics (es a dir, aquells pacients amb estat igual a {@code 1}). 
     * L'array que s'ha de tornar tindra tants elements com pacients 
     * critics hi ha a l'hospital. Si no hi ha pacients, l'array 
     * tindra longitud 0.
     * @return {@code int[]}, array amb els numeros de llit ocupats 
     * pels pacients critics.
     */
    public int[] pacientsCritics() {
        
    }
    
} 
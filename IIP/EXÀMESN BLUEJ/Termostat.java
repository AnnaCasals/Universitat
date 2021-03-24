
/**
 * Write a description of class Termostat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Termostat {
    public static final int FRED = 0;
    public static final int CALOR = 1;
    public static final int T_IDEAL_FRED = 25;
    public static final int T_IDEAL_CALOR = 20;
    private String nom;
    private int mode;
    private int tConfort;
    private double tActual;
    
    public Termostat(int m, String n, int tC, double tAct) {
        mode = m; nom = n; tConfort = tC; tActual = tAct;
    }
    
    public Termostat() {
        this(FRED, "zona d'estar", T_IDEAL_FRED, generarAleatori(20.0, 40.0));
    }
    
    private static double generarAleatori(double x, double y) {
        return x + Math.random() * (y - x);
    }
    public String getNom() {return nom; }
    
    public int getMode() { return mode; }
    
    public void setMode(int nou) { mode = nou; }
    
    public boolean equals(Object altre) {
        boolean res = altre instanceof Termostat;
        if (res) {
            Termostat t = (Termostat) altre;
            res = nom.equals(t.nom) && mode == t.mode
            && tConfort == t.tConfort
            && Math.abs(tActual - t.tActual) < 1;
        }
        return res;
    }
    
    public String toString() {
        String m = "refrigeracio";
        if (this.mode == CALOR) { m = "calefaccio"; }
            return nom + ", mode " + m + ", TConfort = " + tConfort
            + ", TActual = " + tActual;
    }
    
    public int diferenciaAmbIdeal() {
        int res = 0;
        if (mode == FRED) {
            if (tConfort < T_IDEAL_FRED) {
                res = Math.abs(tConfort - T_IDEAL_FRED);
            }
        } else {
            if (tConfort > T_IDEAL_CALOR) {
                res = Math.abs(tConfort - T_IDEAL_CALOR);
            }
        }
        return res;
    }
}
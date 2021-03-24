public class Astre {
    public static final int ESTEL = 0;
    public static final int NEBULOSA = 1;
    public static final int GALAXIA = 2;
    
    private String nom;
    private int tipus;
    private double brillantor;
    private double distancia;
    
    public Astre(String n, int t, double b, double d) {
        nom = n; tipus = t; brillantor = b; distancia = d;
    }
    
    public Astre() {
        this("Sirius", ESTEL, -1.42, 87);
    }
    
    public double getBrillantor() { return brillantor; }
    
    public void setBrillantor(double nova) { brillantor = nova; }
    
    public boolean equals(Object o) {
        return o instanceof Astre
        && nom.equals(((Astre)o).nom)
        && tipus == ((Astre)o).tipus
        && brillantor == ((Astre)o).brillantor
        && distancia == ((Astre)o).distancia;
    }
    
    public String toString() {
        String res = nom + ": ";
        switch(tipus) {
            case ESTEL: res += "Estel " ; break;
            case NEBULOSA: res += "Nebulosa "; break;
            case GALAXIA: res += "Galàxia "; break;
        }
        res += "(" + (Math.round(brillantor * 100) / 100.0) + "," 
                   + (Math.round(distancia * 100) / 100.0) + ")";
        return res;
    }
    
    public double magnitudAbsoluta() {
        double m = brillantor + 5 * Math.log10(distancia);
        return m;
    }
    
    public int mesBrillant(Astre a) {
        double act = this.magnitudAbsoluta();
        double don = a.magnitudAbsoluta();
        int res = 0;
        if(act > don) { res = 1; }
        else if(don > act) { res = -1; }
        return res;
    }
    
    public String visibleAmb() {
        if(brillantor < 5) { return "a simple vista"; }
        else if(brillantor >= 5 && brillantor < 7) { return "amb prismàtics"; }
        else if(brillantor >= 7 && brillantor <= 25) { return "amb telescopi"; }
        else return "amb grans telescopis";
    }
    
}

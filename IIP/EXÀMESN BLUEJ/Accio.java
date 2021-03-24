
public class Accio {
    private String empresa;
    private double obertura;
    private double minim;
    private double maxim;
    private double actual;
    
    public Accio(String e, double o) {
        empresa = e;
        obertura = minim = maxim = actual = o;
    }
    
    public Accio(String e, double o, double min, double max) {
        empresa = e;
        obertura = actual = o;
        minim = min;
        maxim = max;
    }
    
    public String getEmpresa() { return empresa; }
    
    public double getObertura() { return obertura; }
    
    public double getMinim() { return minim; }
    
    public double getMaxim() { return maxim; }
    
    public double getActual() { return actual; }
    
    public void setActual(double a) {
        if (a < minim) { minim = a; }
        else if (a > maxim) { maxim = a; }
        actual = a;
    }
    
    public boolean capAMunt() { return (actual > obertura); }
    
    public boolean equals(Object o) {
        return o instanceof Accio &&
        empresa.equals(((Accio) o).empresa);
    }
    
    public String toString() {
        return empresa + ": " + actual + " " + minim + " " + maxim;
    }
}
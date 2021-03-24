
public class Bloc {
    public static int BLAU = 0;
    public static int ROIG = 1;
    
    private int color;
    private int dimensio;
    private boolean comodi;
    
    public Bloc(int c, int d, boolean cd) {
        color = c; dimensio = d; comodi = cd;
    }
    
    public Bloc() {
        this.color = BLAU;
        this.dimensio = (int) (1 + Math.random() * 50);
        this.comodi = false;
    }
    
    public int getDimensio() { return dimensio; }
    
    public void setDimensio(int nova) {dimensio = nova; }
    
    public boolean equals(Object o) {
        return o instanceof Bloc
        && color == ((Bloc) o).color
        && dimensio == ((Bloc) o).dimensio
        && comodi == ((Bloc) o).comodi;
    }
    
    public String toString() {
        String col =  "blau";
        if( this.color == ROIG) { col = "roig"; }
        String com = "NO";
        if(this.comodi) { com = "SÍ"; }
        return "Color: " + col + ", dimensió: " + dimensio + "," + com + " és comodí"; 
    }
    
    public boolean potEstarDamuntDe(Bloc b) {
        return this.getDimensio() <= b.getDimensio() && (this.comodi || this.color != b.color);
        
    }
    
}
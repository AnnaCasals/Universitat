
/**
* Classe Carta per a representar una carta de la baralla espanyola.
*
* @author IIP
* @version Curs 2011/12
*/
public class Carta {
    public static final int ORS = 0;
    public static final int COPES = 1;
    public static final int ESPASES = 2;
    public static final int BASTOS = 3;
    private int pal;
    private int valor;
    public Carta(int p, int v) { pal = p; valor = v; }
    
    public Carta() {
        pal = (int)(Math.random()*4);
        valor = (int)(Math.random()*12 + 1);
    }
    
    public int getPal() { return pal; }
    
    public int getValor() { return valor; }
    
    public void setPal(int nou) { pal = nou; }
    
    public void setValor(int nou) { valor = nou; }
    
    public boolean esMenor(Carta c) {
        return (this.pal < c.pal) || (this.pal == c.pal && this.valor < c.valor);
    }
    
    public Carta segPal() { return new Carta((pal+1)%4, valor); }
    
    public boolean equals(Object o) {
        return o instanceof Carta &&
        pal == ((Carta)o).pal && valor == ((Carta)o).valor;
    }
    
    public String toString() {
        String res = valor + " d";
        switch (pal) {
            case ORS: res += "'ors"; break;
            case COPES: res += "e copes"; break;
            case ESPASES: res += "'espases"; break;
            case BASTOS: res += "e bastos"; break;
        }
        return res;
    }
}
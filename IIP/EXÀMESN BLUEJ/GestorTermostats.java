
/**
 * Write a description of class GestorTermostat2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GestorTermostats {
    public static final int MAX_TERMS = 15;
    public int numTerms;
    public Termostat[] terms;
    public int noEficients;
    public GestorTermostats() {
        numTerms = 0;
        noEficients = 0;
        terms = new Termostat[MAX_TERMS];
    }
    
    private int termostatEnZona(String nomZona) {
        int i = 0;
        while(i < numTerms && !nomZona.equals(terms[i].getNom())) { i++; }
        if(i < numTerms) { return i; }
        else { return -1; }
    }
    
    public boolean instalar(Termostat t) {
        boolean a = true;
        String b = t.getNom();
        int c = termostatEnZona(b);
        if( c != -1) {
            terms[c] = t;
            if(t.diferenciaAmbIdeal() != 0) { noEficients++; }
            return a;
        }
        else if(numTerms < MAX_TERMS) {
            terms[numTerms++] = t;
            if(t.diferenciaAmbIdeal() != 0) { noEficients++; }
            numTerms++;
            return a;
        } else { return a = false; }
    }
    public Termostat diferenciaMajor() {
        Termostat tMax = null;
        if(numTerms != 0) {
            tMax = terms[0];
            int difMax = tMax.diferenciaAmbIdeal();
            for(int i = 1; i < numTerms; i++) {
                int dif = terms[i].diferenciaAmbIdeal();
                if(dif > difMax) { tMax = terms[i]; difMax = dif; }
            }
        }
        return tMax;
    }
    public Termostat[] termsNoEficients() {
        Termostat[] aux = new Termostat[noEficients];
        int k = 0;
        for(int i = 0; i < numTerms; i++) {
            if(terms[i].diferenciaAmbIdeal() != 0) {
                aux[k++] = terms[i];
            }
        }
        return aux;
    }
}

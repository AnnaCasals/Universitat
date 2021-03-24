/**
 * La classe {@code Data} permet representar dates en format dia, mes i any.
 * 
 * @author IIP 
 * @version Curs 2016/17
 */
public class Data {
    // Atributs
    /** Atribut privat que representa el dia de la data actual. */
    private int dia;  
    /** Atribut privat que representa el mes de la data actual. */
    private int mes;
    /** Atribut privat que representa l'any de la data actual. */
    private int any;
   
    /** Crea una Data per defecte 01/01/2016. */
    public Data() {
        this(1, 1, 2016);
    }
   
    /**
     * Crea una Data amb els valors donats de dia, mes i any. 
     * @param d int, el dia.
     * @param m int, el mes.
     * @param a int, l'any.
     */
    public Data(int d, int m, int a) {
        dia = d;
        mes = m;
        any = a;
    }
    
    /**
     * Torna el dia de la Data.
     * @return {@code int}, el dia.
     */
    public int getDia() { return dia; }
   
    /**
     * Torna el mes de la Data.
     * @return {@code int}, el mes.
     */
    public int getMes() { return mes; }
   
    /**
     * Torna l'any de la Data.
     * @return {@code int}, l'any.
     */
    public int getAny() { return any; }
   
    /**
     * Actualitza el dia de la Data a d.
     * @param d {@code int}, el nou dia.
     */
    public void setDia(int d) { dia = d; }
   
    /**
     * Actualitza el mes de la Data a m.
     * @param m {@code int}, el nou mes.
     */
    public void setMes(int m) { mes = m; }
   
    /**
     * Actualitza l'any de la Data a a.
     * @param a {@code int}, el nou any.
     */
    public void setAny(int a) { any = a; }
   
    /** 
     *  Torna un {@link String} com representació de la {@link Data}.
     *  @return {@link String}, representa una data en format dia/mes/any.
     */
    public String toString() {
        return dia + "/" + mes + "/" + any;
    } // de toString
   
    /**
     * Comprova si la Data actual és igual a un altra donada.
     * @param o Object, referència a un objecte de qualsevol classe.
     * @return {@code boolean}, torna {@code true} si dia, mes i any
     * de la data actual coincideixen amb els de la data donada i 
     * {@code false} en cas contrari.
     */
    public boolean equals(Object o) {
        return o instanceof Data
            && this.dia == ((Data) o).dia 
            && this.mes == ((Data) o).mes 
            && this.any == ((Data) o).any;
    } // de equals
  
    /**
     * Comprova si l'any de la Data és bixest.
     * @return {@code boolean}, torna {@code true} si l'any és bixest 
     *  i {@code false} en cas contrari.
     */   
    public boolean esBixest() { 
        return (any % 4 == 0 && any % 100 != 0) || (any % 400 == 0); 
    }
 
    /**
     * Comprova si la Data actual és anterior a un altra data donada,
     * suposant ambdues correctes.
     * @param d Data a comparar amb la Data actual.
     * @return {@code boolean}, torna {@code true} si la Data actual 
     * és anterior a la Data donada i {@code false} en cas contrari.
     */  
    public boolean esAnterior(Data d) {           
        return (any < d.any) 
            || (any == d.any 
            && (mes < d.mes || (mes == d.mes && dia < d.dia)));               
    }  
   
    /**
     * Comprova si la Data actual és correcta.
     * @return {@code boolean}, torna {@code true} si la data és correcta 
     *  i {@code false} en cas contrari.
     */
    public boolean esCorrecta() { 
        boolean correcta = false;
        boolean anyValid = any > 0;
        boolean mesValid = mes >= 1 && mes <= 12;
        boolean diaValid = dia >= 1 && dia <= 31;        
        if (anyValid && mesValid && diaValid) {    
            int diesMes;
            switch (mes) {
                case 2: 
                    if (esBixest()) { diesMes = 29; }
                    else { diesMes = 28; }
                    break;
                case 4: 
                case 6: 
                case 9: 
                case 11: 
                    diesMes = 30; break;
                default: 
                    diesMes = 31; break;
            }
            if (dia <= diesMes) { correcta = true; }
        }
        return correcta;
    }  
} // de la clase Data

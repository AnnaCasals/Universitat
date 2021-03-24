/** Classe MesuraOrdenacio: Estudi empiric de costs dels metodes d'ordenacio.
 *  @author PRG - ETSInf
 *  @version Curs 2016-2017
 */
class MesuraOrdenacio {
    // Constants que defineixen els paràmetres de mesura
    
    public static final int MAXTALLA = 10000, INITALLA = 1000; 
    public static final int INCRTALLA = 1000, REPETICIONS = 200;
    public static final double NMS = 1e3;
  
    /* Genera un array d'int de talla t amb valors compresos entre 0 i t-1.
     * @param t int, la talla.
     * @result int[], l'array generat.
     */
    private static int[] crearArrayAleatori(int t) { 
        int[] a = new int [t];
        for(int i = 0; i < t; i++) {
            a[i] = (int) (Math.random()*t);
        }
        return a;
    }
  
    /* Genera un array d'int de talla t ordenat de forma creixent.
     * @param t int, la talla.
     * @result int[], l'array generat.
     */
    private static int[] crearArrayOrdCreixent(int t) { 
        int a[] = new int[t];
        for(int i = 0; i < t; i++){
            a[i] = i;        
        }
        return a;
    }
    

    /* Genera un array d'int de talla t ordenat de forma decreixent.
     * @param t int, la talla.
     * @result int[], l'array generat.
     */
    private static int[] crearArrayOrdDecreixent(int t) { 
        int a[] = new int[t];
        int i = 0;
        for(int j = 0; j < t; t--) {
            a[i] = t;
            i++;
        }
        return a;
    }
    

    public static void mesuraSeleccio() { 
        for (int i = 0; i < REPETICIONS; i++) {
            int t = 100;
            int[] a = crearArrayAleatori(t);
            long ti = System.nanoTime();
            AlgorismesMesurables.seleccio(a);
            long tf = System.nanoTime();
            long dif = tf - ti;
            System.out.println("Talla de l'array: " + t + "; Temps: " + dif + " microsegons");
        }
    }

    public static void mesuraInsercio() { 
           long ti = 0, tf = 0, tt = 0; // Temps inicial, final i total        
        // Imprimir capçalera de resultats
        System.out.println("# Ordenacio per insercio. Temps en microsegons");
        System.out.printf("# Talla    Pitjor   Millor   Promedi\n");
        System.out.printf("#--------------------------------------\n");

       // Aquest bucle repeteix el proces per a distintes talles
        for (int t = INITALLA; t <= MAXTALLA; t += INCRTALLA) {
            // Crear l'array
            int a[];
            int c[];
            int[] b = crearArrayOrdCreixent(t) ;

            // Estudi del cas pitjor: cambiar un array ordenat descendentment.
            tt = 0;                          // Temps acumulat inicial a 0
            for (int r = 0; r < REPETICIONS; r++) {
                c= crearArrayOrdDecreixent(t) ;
                ti = System.nanoTime();      // Temps inicial
                AlgorismesMesurables.insercio(c) ;
                tf = System.nanoTime();      // Temps final
                tt += (tf - ti);             // Actualitzar temps acumulat
            }
            double tPitjor = (double) tt / REPETICIONS;  // Temps promedi 
                                                         // del cas pitjor
      
            // Estudi del cas millor: cambiar un array ja ordenat.
            // OJO: Com es massa rapid, les repeticions s'inclouen 
            // en la mesura de temps     
            ti = System.nanoTime();   // Temps inicial
            for (int r = 0; r < REPETICIONS; r++) {
                 AlgorismesMesurables.insercio(b) ;
            }
        }
         tf = System.nanoTime();   // Temps final
            double tMillor = (double) (tf - ti) / REPETICIONS; // Temps promedi 
                                                               // del cas millor
      
            // Estudi del cas promedi: cambiar un array aleatori.
            tt = 0;                        // Temps acumulat inicial a 0
            for (int r = 0; r < REPETICIONS; r++) {
                a = crearArrayAleatori(t) ;
                ti = System.nanoTime();  // Temps inicial
                AlgorismesMesurables.insercio(a) ;
                tf = System.nanoTime();  // Temps final
                tt += (tf - ti);         // Actualitzar temps acumulat
            }
            double tPromed = (double) tt / REPETICIONS; // Temps promedi 
                                                        // del cas promedi

            // Imprimir resultats
            System.out.printf("%8d   %6.2f     %4.2f  %8.2f\n", 
                              t, tPitjor / NMS, tMillor / NMS, tPromed / NMS);
        }
    
  
    public static void mesuraMergeSort() { 
        // Completar
    }

    public static void us() {
        System.out.println("Us: java MesuraOrdenacio numero_algorisme");
        System.out.println("   on numero_algorisme es:");
        System.out.println("   1 -> Insercio");
        System.out.println("   2 -> Seleccio");
        System.out.println("   3 -> MergeSort");
    }

    public static void main(String[] args) {        
        if (args.length != 1) {
            us();            
        }
        else {
            try {
                int a = Integer.parseInt(args[0]);
                switch (a) {
                    case 1: 
                        mesuraInsercio();
                        break;
                    case 2: 
                        mesuraSeleccio();
                        break;
                    case 3: 
                        mesuraMergeSort();
                        break;
                    default: 
                        us();
                }
            } catch (Exception e) {
                us(); 
            }
        }
    }
}

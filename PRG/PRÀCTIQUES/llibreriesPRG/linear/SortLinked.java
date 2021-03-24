package linear;

import java.util.Scanner;
/**
 * Classe SortLinked: classe d'utilitats que conté operacions 
 * per tal d'ordenar seqüències enllaçades.
 * 
 * @author PRG 
 * @version Curs 2017/18
 */
public class SortLinked {
    
    /** No hi ha objectes d'aquesta classe. */ 
    private SortLinked() { }
    
    /**
     * Donada una seqüència enllaçada d'enters, l'ordena seguint una 
     * estratègia d'inserció directa, és a dir, inserint ordenadament 
     * les succesives dades de sec en la seqüència resultant.
     * @param sec NodeInt que representa una seqüència enllaçada d'enters 
     * (al menys 1).
     * @return NodeInt seqüència enllaçada d'enters ordenada ascendentment
     * resultant.
     */
    public static NodeInt insDirecta(NodeInt sec) {
        NodeInt aux = sec.next,  // referència per tal de recórrer sec
        ord = new NodeInt(sec.data); // (sub)seqüència ordenada
        while (aux != null) {
            // referències per tal de cercar en ord
            NodeInt ant = null, auxOrd = ord;  
            while (auxOrd != null && auxOrd.data < aux.data) {
                ant = auxOrd; 
                auxOrd = auxOrd.next;
            }
            // la cerca acaba si auxOrd és null 
            // (totes les dades en ord < aux.data)
            // o acaba si auxOrd.data >= aux.data 
            //   --> el nou node s'ha d'afegir entre ant i auxOrd 
            //   però si ant és null, el nou node ha de ser el primer de ord
            NodeInt nou = new NodeInt(aux.data, auxOrd);
            if (ant != null) { ant.next = nou; }
            else { ord = nou; }

            aux = aux.next;
        }        
        return ord;
    }

    /**
     * Compta i torna el nombre d'elements d'una seqüència enllaçada donada.
     * @param sec NodeInt que representa una seqüencia enllaçada d'enters.
     * @return int nombre d'elements de la seqüència.
     */
    private static int longitud(NodeInt sec) {
        int num = 0;
        for (NodeInt aux = sec; aux != null; aux = aux.next) {
            num++;
        }
        return num;
    }

    /**
     * Donades dues seqüències enllaçades d’enters ordenades 
     * ascendentment, torna una tercera amb la mescla natural 
     * o fusió ordenada d’ambdues. 
     * El cost ha de ser lineal amb el número total d’elements a fusionar.
     * @param sec1 NodeInt que representa una seqüència enllaçada d'enters 
     * ordenada ascendentment.
     * @param sec2 NodeInt que representa una seqüència enllaçada d'enters 
     * ordenada ascendentment.
     * @return NodeInt seqüència enllaçada d'enters ordenada ascendentment 
     * resultat de la fusió.
     */
    private static NodeInt mescla(NodeInt sec1, NodeInt sec2) {
        //         NodeInt sec3 = null, aux = null; // referència a l'últim node de sec3
        //         // sec1 i sec2 fan referència als nodes a visitar en la primera 
        //         // i segona seqüència, respectivament 
        //         while (sec1 != null && sec2 != null) {
        //             if (sec1.data < sec2.data) { 
        //                 if (sec3 == null) { 
        //                     sec3 = new NodeInt(sec1.data); 
        //                     aux = sec3; 
        //                 }
        //                 else { 
        //                     aux.next = new NodeInt(sec1.data); 
        //                     aux = aux.next; 
        //                 }
        //                 sec1 = sec1.next;
        //             }
        //             else {
        //                 if (sec3 == null) { 
        //                     sec3 = new NodeInt(sec2.data); 
        //                     aux = sec3; 
        //                 }
        //                 else {
        //                     aux.next = new NodeInt(sec2.data); 
        //                     aux = aux.next; 
        //                 }
        //                 sec2 = sec2.next;
        //             }    
        //         }
        //         
        //         while (sec1 != null) {
        //             if (sec3 == null) { 
        //                 sec3 = new NodeInt(sec1.data); 
        //                 aux = sec3;
        //             }
        //             else { 
        //                 aux.next = new NodeInt(sec1.data); 
        //                 aux = aux.next; 
        //             }
        //             sec1 = sec1.next;
        //         }   
        //    
        //         while (sec2 != null) {
        //             if (sec3 == null) { 
        //                 sec3 = new NodeInt(sec2.data); 
        //                 aux = sec3; 
        //             }
        //             else { 
        //                 aux.next = new NodeInt(sec2.data); 
        //                 aux = aux.next;
        //             }
        //             sec2 = sec2.next;
        //         }
        //         return sec3;

        // Versio simplificada
        NodeInt sec3 = null, aux = null;
        while (sec1 != null && sec2 != null) {
            boolean compara = sec1.data < sec2.data;
            int data = compara ? sec1.data : sec2.data;
            NodeInt nou = new NodeInt(data);
            if (sec3 == null) { sec3 = nou; }
            else { aux.next = nou; }
            aux = nou;
            if (compara) { sec1 = sec1.next; }
            else { sec2 = sec2.next; }
        }

        NodeInt res = sec1 != null ? sec1 : sec2;
        while (res != null) {
            NodeInt nou = new NodeInt(res.data);
            if (sec3 == null) { sec3 = nou; }
            else { aux.next = nou; }
            aux = nou;   
            res = res.next;
        }
        return sec3;        
    }

    /**
     * Donada una seqüència enllaçada d'enters i la seua longitud, 
     * la ordena seguint una estratègia recursiva anàloga a la del mètode 
     * mergesort d’ordenació d’arrays.
     * En el cas general del mètode, partint la seqüència enllaçada en 
     * dues subseqüències de longitud similar, si el número d’elements és 
     * parell, les dues subseqüències tindran la mateixa longitud; 
     * en cas contrari, la primera subseqüència es quedarà amb un node més 
     * que la segona. 
     * Una vegada ordenades les dues subseqüències, s’usarà el mètode 
     * mescla per completar l’ordenació.
     * @param sec NodeInt que representa una seqüència enllaçada d'enters.
     * @param n int que representa la longitud de la seqüència.
     * @return NodeInt seqüència enllaçada d'enters ordenada ascendentment 
     * resultant.
     */
    public static NodeInt mergesort(NodeInt sec, int n) {
        if (n > 1) {   
            int meitat = (n + 1) / 2, i = 0;
            NodeInt aux = sec, sec1 = null, aux1 = null;
            for (; i < meitat; i++) {
                /* COMPLETAR */
            }

            NodeInt sec2 = null, aux2 = null;
            for (; i < n; i++) {
                /* COMPLETAR */
            }

            sec1 = mergesort(sec1, meitat); // la long. de sec1 és meitat
            sec2 = mergesort(sec2, n - meitat); // la long. de sec2 és n-meitat
            // sec1 i sec2 estan ordenades
            sec = mescla(sec1, sec2);            
        }        
        return sec;
    }

    /** main de prova dels mètodes anteriors */
    public static void main(String[] args) {
        Scanner tec = new Scanner(System.in);
        NodeInt sec = new NodeInt(3);
        sec = new NodeInt(4, sec);
        sec = new NodeInt(7, sec);
        sec = new NodeInt(2, sec);
        sec = new NodeInt(6, sec);
        sec = new NodeInt(1, sec);
        sec = new NodeInt(5, sec);
        //sec = insDirecta(sec);
        sec = mergesort(sec, longitud(sec));        
        NodeInt aux = sec;
        while (aux != null) {
            System.out.println(aux.data);
            aux = aux.next;
        }        
    }
}

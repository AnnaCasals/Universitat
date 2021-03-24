
/**
 * Write a description of class Fsd here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fsd {
    public static int sumaMenors(int[] a, int pos, int x) {
        if (pos < a.length) {
            if (a[pos] >= x) { return 0; }
            else { return a[pos] + sumaMenors(a, pos + 1, x); }
        } else { return 0; }
    }
    public static boolean ordenat(int[] a, int ini, int fi) {
        if (ini >= fi) { return true; }
        else {
            if (a[ini] > a[ini + 1] || a[fi] < a[fi - 1]) { return false; }
            else { return ordenat(a, ini + 1, fi - 1); }
        }
     }
     /** 
      *  SI [4, 3, 2, 3, 4] ini = 0, fi = 4;
      */
    public static int sumaCapicua(int[] a, int ini, int fi) {
        // Cas base ini > fi- Return 0;
        // Cas base Arrey 1 num ini == fi; torna a[ini];
        // Cas general: ini < fi(a[ini] != 0) - return 0; (a[ini] == a[fi]) el resultat
        // és la suma dels extrems a[ini], a[fi] més la suma dels valors capicua des
        // dels extrems del subarraya[ini+1...fi-1];
        if (ini > fi) { return 0; }
        else if (ini == fi) { return a[ini]; }
        else { 
            if (a[ini] == a[fi]) { 
                return (a[ini] + a[fi]) + sumaCapicua(a, ini + 1, fi - 1);
            } else { return 0; }
        }
    }
}
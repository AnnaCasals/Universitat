
/**
 * Write a description of class dibuixos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class dibuixos {
    /**
     * U-----U
     * U-----U
     * U-----U
     * U-----U
     * UUUUUUU
     */
    public static void u(int n) {
        for(int i = 0; i < n - 1 ; i++) {
            System.out.print("U");
            for(int k = 0; k < n; k++) {
                System.out.print("-");
            }
            System.out.print("U\n");
        }
        for(int b = 0; b < n + 2; b++) {
            System.out.print("U");
        }
        System.out.println("");
    }
    /** 
     * V--------V
     * -V------V-
     * --V----V--
     * ---V--V---
     * ----VV----
     */
    public static void v(int n) {
        
        int j = (n - 1) * 2;
        for(int i = 0; i < n; i++) {
            for(int b = 0; b < i; b++) {
                System.out.print("-");
            }
            System.out.print("V");
            for(int c = 0; c < j; c++) {
                System.out.print("-");
            }
            System.out.print("V");
            for(int d = 0; d < i; d++) {
                System.out.print("-");
            }
            
            j = j - 2;
            System.out.println("");
        }
    }
    /**
     * M------M
     * MM----MM
     * M-M--M-M
     * M--MM--M
     * M------M
     *
     */
       public static void M(int n){  
        int i = 0;
        int j = (n - 3) * 2;
        int s = (n - 2) * 2;
        System.out.print("M");
        for(int r = 0; r < s; r++){
            System.out.print('-');
        }
        System.out.print("M");
        System.out.println("");
        for(int k = 0; k < n - 2; k++){
            System.out.print("M");
            for(int p = 0; p < i; p++){
                System.out.print('-');
            }
            System.out.print("M");
            for(int o = 0; o < j; o++){
                System.out.print('-');
            }
            System.out.print("M");
            for(int y = 0; y < i; y++){
                System.out.print('-');
            }
            System.out.print("M");
            System.out.println("");
            i++;
            j = j - 2;
        }
        System.out.print("M");
        for(int q = 0; q < s; q++){
            System.out.print('-');
        }
        System.out.print("M");
        System.out.println("");
    }    
    /**
     * ZZZZZ
     *    Z
     *   Z
     *  Z   
     * ZZZZZ
     */
    public static void Z(int n) {
        for(int i = 0; i < n; i++) {
            System.out.print("Z");
        }
        System.out.println("");
        for(int i = 0; i < n  - 2; i++){
            for(int j = 0; j < n - 2 - i; j++) {
                System.out.print(" ");
            }
            System.out.print("Z");
            System.out.println("");
        }
        for(int j = 0; j < n; j++) {
            System.out.print("Z");
        }
        System.out.println("");
    }
    /**
     * a----
     * -a---
     * --a--
     * ---a-
     * ----a
     */
    public static void diagonal(int n) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                System.out.print("-");
            }
            System.out.print("a");
            for(int k = 0; k < n - 1 - i; k++) {
                System.out.print("-");
            }
            System.out.println("");
        }
    }
    }

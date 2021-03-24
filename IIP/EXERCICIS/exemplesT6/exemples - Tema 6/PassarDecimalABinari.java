import java.util.Scanner;
/**
 * Classe PassarDecimalABinari: classe programa per provar 
 * el mètode que tranforma un nombre de decimal a binari
 * @author IIP 
 * @version Curs 2015-16
 */
public class PassarDecimalABinari {

    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        System.out.print("Dis-me un número positiu: ");
        int num = teclat.nextInt();
        if (num > 0) {
            String bin = dec2Bin(num);
            System.out.println(num + " és en binari " + bin);
        } else { System.out.println("El número no és vàlid"); }
    }
    
    /** Transforma un nombre decimal a binari, amb decimal > 0 */
    public static String dec2Bin(int decimal) {
        String binari = "";
        int dividend = decimal;
        while (dividend > 0) {
            binari = dividend % 2 + binari;
            dividend /= 2;
        }
        return binari;   
    }
 
}

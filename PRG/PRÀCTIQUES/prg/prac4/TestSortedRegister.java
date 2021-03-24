package prac4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Year;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Clase TestSortedRegister. Test de la clase SortedRegister.
 * 
 * @author (PRG) 
 * @version (2017/18)
 */
public class TestSortedRegister {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyB = new Scanner(System.in);
        String msg = "Any de les dades (fins 10 anys endarrere): ";
        int currentY = Year.now().getValue();
        int year = CorrectReading.nextInt(keyB, msg, 
                                          currentY - 10, currentY);   
        Scanner in = null;
        PrintWriter out = null, err = null;
        System.out.print("Nom del fitxer a ordenar: "); 
        String nameIn = keyB.next();
        File f = new File(nameIn);
        in = new Scanner(f);
        f = new File("result.out");
        out = new PrintWriter(f);
        
        boolean salir = false;
        int opcion;
        while(!salir) {
            System.out.println("Opcions d'ordenació: ");
            System.out.println("1.- Rebutjar el fitxer si té errors.");
            System.out.println("2.- Filtrar les línies err`nies del fitxer.");
            System.out.println("Escriu una de les opcions");
            opcion = keyB.nextInt();
            switch(opcion) {
                case 1:
                testUnreportedSort(year, in, out);
                in.close();
                out.close();
                break;
                case 2:
                File a = new File("result.log");
                out = new PrintWriter(a);
                testReportedSort(year, in, out, err);
                in.close();
                out.close();
                break;
                default: 
                System.out.println("Només 1 o 2");
            }
        }
    }
  
    /** Metode de prova de add(Scanner) i save(PrintWriter) 
     *  de SortedRegister. */
    public static void testUnreportedSort(int year, Scanner in, 
                                          PrintWriter out) {
        try {                                      
            SortedRegister c = new SortedRegister(year);
            c.add(in); 
            c.save(out);
        } catch (IllegalArgumentException e) {
            System.out.println("Fitxer incorrecte: dada amb quantitat negativa.");
        } catch (InputMismatchException e) {
            System.out.println("Fitxer incorrecte: dada amb format no enter.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Fitxer incorrecte: dada amb data incorrecta.");
        }
    }
    public static void testReportedSort(int year, Scanner in, PrintWriter out, PrintWriter err) {
        SortedRegister c = new SortedRegister(year);
        c.add(in);
        c.save(out);
    }
}
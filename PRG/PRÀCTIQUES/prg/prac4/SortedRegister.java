package prac4;

import java.io.PrintWriter; 
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * Clase SortedRegister
 * 
 * @author (PRG. ETSINF - UPV) 
 * @version (2017/18)
 */
public class SortedRegister {

    private static int[] DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31,
        30, 31, 30, 31};  
    private int year;
    private int[][] m;

    /** Crea un SortedRegister per a l'any dataYear. 
     *  @param dataYear int
     */
    public SortedRegister(int dataYear) {
        this.year = dataYear;
        boolean leap = isLeap(this.year);
        m = new int[13][]; 
        for (int month = 1; month <= 12; month++) {
            int numD = this.DAYS[month];
            if (month == 2 && leap) { numD++; }
            m[month] = new int[numD + 1];
        }    
    }    
    
    /** Classifica ordenadament les dades llegides del Scanner s.
     *  Precondicio: El format de linia recognoscible es
     *        dia mes quantitat
     *  on dia i mes han de ser enters corresponents a una data valida,
     *  i quantitat ha de ser un enter > 0.
     *  La quantitat llegida s'acumula en el registre que es porta per 
     *  al dia del mes.
     *  Si alguna linia no cumpleix el format, o conte una data incorrecta,
     *  el metode acaba llançant una excepcio.
     *  @param s Scanner font de les dades
     *  @throws InputMismatchException si s'intenta llegir una data no entera
     *  @throws ArrayIndexOutOfBoundsException si se llig de s alguna data incorrecta
     */
    public void add(Scanner s) {
        while (s.hasNext()) {
            int day = s.nextInt();
            int month = s.nextInt();
            int amount = s.nextInt();
            if(day < 0 || month < 0 || amount < 0) {
                throw new IllegalArgumentException("Quantitat negativa");
            }
            this.m[month][day] += amount;
        } 
    }
    
    /** Les dades registrades > 0 s'escriuen en p, linia a linia
     *  amb el format
     *        dia  mes  quantitar
     *  ordenades cronologicament.
     *  @param p Printwriter desti de les dades ordenades
     */
    public void save(PrintWriter p) {
        for (int month = 1; month <= 12; month++) {
            for (int day = 1; day < this.m[month].length; day++) {
                int totalAmount = this.m[month][day];
                if (totalAmount > 0) {
                    p.printf("%5d %5d %5d \n", day, month, totalAmount);
                }
            }
        }
    }

    /** Classifica ordenadament les dades llegides del Scanner s. Es filtren
     *  les dades que tingueren algun defecte de format, emetent un informe
     *  d'errors.
     *  Precondicio: El format de linia recognoscible es
     *        dia mes quantitat
     *  on dia i mes han de ser enters corresponents a una data valida,
     *  i quantitat ha de ser un enter > 0.
     *  La quantitat llegida s'acumula en el registre que es porta per 
     *  al dia del mes.
     *  En err s'escriuen les linies defectuoses, indicant el nombre de linia.
     *  @param s Scanner font de les dades
     *  @param err Printwriter desti de l'informe d'errors
     */
    public void add(Scanner s, PrintWriter err) {
        int i = 0;
        while (s.hasNext()) {
            try {
                int day = s.nextInt();
                int month = s.nextInt();
                int amount = s.nextInt();
                i++;
                if(day < 0 || month < 0 || amount < 0) {
                    throw new IllegalArgumentException("Quantitat negativa");
                }
                this.m[month][day] += amount;
            } catch(IllegalArgumentException e) {
                err.print("Línia " + i + ": Quantitat negativa");
            } catch(InputMismatchException e) {
                err.print("Línia " + i + ": Format incorrecte");
            } catch (ArrayIndexOutOfBoundsException e) {
                err.print("Línia " + i + ": Data incorrecta");
            }
        }
 
    }
    
    /** Comprova si year es bixest.
     *  @param year int
     *  @return true sii es bixest.
     */
    private static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}

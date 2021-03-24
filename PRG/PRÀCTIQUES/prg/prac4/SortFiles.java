package prac4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.Year;
import java.util.Scanner;
/**
 * Clase SortFiles. 
 * 
 * @author (PRG) 
 * @version (2017/18)
 */
public class SortFiles {
     
    public static void main(String[] args)  {
        Scanner keyB = new Scanner(System.in);
        String msg = "Any de les dades (fins 10 anys endarrere): ";
        int currentY = Year.now().getValue();
        int year = CorrectReading.nextInt(keyB, msg, 
                                          currentY - 10, currentY);     
        
        // Busca en la ubicacio indicada un directori de nom "dataFilesAAAA",
        // essent AAAA l'any llegit de teclat
        System.out.print("Ubicació del directori amb els fitxers a ordenar: ");
        String dirParent = keyB.next(); 
        File f = new File(dirParent + "/dataFiles" + year);
        if (f.isDirectory()) {
            // El resultat es deixa en el directori "resultFilesAAAA"
            File fResult = new File(dirParent + "/resultFiles" + year);
            if (!fResult.isDirectory()) { fResult.mkdir(); }
            reportedSortFiles(f.listFiles(), year, fResult);
        } else { 
            System.out.println("Error: " + f 
                + " no és un directori del sistema.");           
        }
    } 
    
    /** Classifica les dades llegides d'un array de fitxers de text. 
     *  Les dades corresponen a dates d'un determinat any. Es filtren 
     *  les dades amb algun defecte de format, emitint un informe d'errors. 
     *  Precondicio: El format de linia recognoscible es
     *        dia mes quantitat
     *  on dia i mes han de ser enters correspondents a una data valida 
     *  de l'any, i quantitat ha de ser un enter > 0.
     *  En un fitxer "result.out" s'escriuen en ordre cronologic les quantitats
     *  acumulades per a cada data. En un fitxer "result.log" s'escriuen les 
     *  linies amb dades defectuoses.
     *  Si hi ha problemes d'acces a algun fitxer, el proces no es completa.
     *     
     *  @param listF File[] array dels fitxers font de les dades
     *  @param year int any al que corresponen les dades
     *  @param place File lloc del sistema on es guarden els fitxers .out i .log
     */
    public static void reportedSortFiles(File[] listF, int year, File place) {
       // A  COMPLETAR      
       Scanner in = null;
       PrintWriter out = null, error = null;
       File f = null;
       try{
           SortedRegister c = new SortedRegister(year);
           f = new File(place + "/result.log");
           error = new PrintWriter(f);
           in = new Scanner(f);
           for(int i = 0; i < listF.length; i++) {
               f = listF[i];
               in = new Scanner(f);
               error.println(">>>>> File " + listF[i].getName() + "<<<<<");
               c.add(in, error);
               in.close();
           }
           f= new File(place + "/result.out");
           out = new PrintWriter(f);
           c.save(out);
           out.close();
       } catch (FileNotFoundException e) {
           System.out.println("Procés incomplet: Error en obrir el fitxer " + f);
       } finally {
           if(error != null) {
               error.close();
           }
       }
    }
}
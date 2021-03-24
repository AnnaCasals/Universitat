import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.io.PrintWriter;

/**
 * Classe Banc per a representar un conjunt de comptes.
 * @author PRG 
 * @version Curs 2015/16
 */
public class Banc {
    
    private NodeCompte primer;
    /** Primer element d'una sequencia enllaçada de NodeComptes
     * que contenen com a dada un CompteAp que es una classe
     * que hereda els seus atributs de la classe Compte. */
    
    /** Número actual de comptes i primer índex disponible a l'array comptes. */
    private int numComptes;
    /** Número màxim de comptes. */

    /**
     * Crea un banc sense comptes (pot tenir un màxim de MAX_COMPTES comptes).
     */
    public Banc() {
        this.primer = null;
        this.numComptes = 0;
    }

    /**
     * Consultor del número actual de comptes.
     * @return int, número actual de comptes.
     */
    public int getNumComptes() { return numComptes; }
    
    /**
     * Permet inserir el Compte c al banc. Si el banc està complet,
     * duplica el número de comptes que poden haver al banc.
     * @param c Compte a inserir.
     */
    public void inserir(CompteAp c) {
        NodeCompte p = primer;
        NodeCompte ant = null;
        while(p != null && c.getNumCompte() > p.dada.getNumCompte()){
            ant = p;
            p = p.seguent;
        }
        NodeCompte nou;
        if(ant == null){
            primer = nou = new NodeCompte(c, primer);
        } else {
            ant.seguent = nou = new NodeCompte(c, p);
        }
        numComptes++;
    }
    
    public boolean cancelar(int n){
        NodeCompte p = primer;
        NodeCompte ant = null;
        while(p != null && p.dada.getNumCompte() < n){
            ant = p;
            p = p.seguent;
        }
        if(p != null && p.dada.getNumCompte() == n){
            if(ant == null){
                primer = p.seguent;
            }
            else{
                ant.seguent = p.seguent;
            }
            numComptes--;
            return true;
        }
        return false;
    }
    
    /**
     * Torna el compte amb número de compte n.
     * Si aquest comtpe no existeix, torna null.
     * @param n int que indica el número de compte.
     * @return Compte, el comtpe resultat.
     */
    public CompteAp getCompte(int n) {
        NodeCompte p = primer;
        while (p != null && p.dada.getNumCompte() < n){
            p = p.seguent;
        }
        if(p != null && p.dada.getNumCompte() == n){
            return p.dada;
        }
        return null;
    }

    /**
     * Torna una String amb tota la informació del banc.
     * El format és un compte per línia.
     * @return String.
     */
    public String toString() {
        if (numComptes == 0) { return "No hi ha comptes al banc"; }
        else {
            String res = "";
            NodeCompte p = primer;
            while(p != null){
                res += p.dada.toString() + "\n";
                p = p.seguent;	
            }
            return res;
        }        
    }
    
    /**public void carregarFormatText(Scanner f){
        while (f.hasNext()){
            try{
                int numCompte = f.nextInt();
                double saldoInicial = f.nextDouble();
                if (numCompte < 10000 || numCompte > 99999 || saldoInicial < 0)
                    System.out.println("Linea no valida");
                else if (this.getCompte(numCompte) != null)
                    System.out.println("Compte ya existent");
                else {
                    Compte nom = new Compte(numCompte, saldoInicial);
                    this.inserir(nom);
                }
            } catch(InputMismatchException errortxt) {
                System.out.println("Error: " + errortxt + "fallo de lectura.");
            } finally {
                f.nextLine();
            }
        }
    }
    public void guardarFormatText(PrintWriter f) {
       if(numComptes > 0) f.print(this);
    }
    */
}

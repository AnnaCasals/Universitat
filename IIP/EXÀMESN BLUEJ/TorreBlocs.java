import java.util.*;

public class TorreBlocs {
    public static int dimensioValida(int dimensio) {
        if(dimensio < 1) { return 1; }
        else if(dimensio > 50) { return 50; }
        else { return dimensio; }
    }
    
    public static void main(String[] args) {
        Scanner teclat = new Scanner(System.in);
        Bloc b1 = new Bloc();
        Bloc b2 = new Bloc(Bloc.BLAU, 30, true);
        
        System.out.print("Introdueix el color del bloc 3 (blau/roig): ");
        String color = teclat.next().trim().toLowerCase();
        int codColor = Bloc.ROIG;
        if(color.equals("blau")){ codColor = Bloc.BLAU; }
        
        System.out.print("Introdueix la dimensió del bloc 3[1, 50]: ");
        int dimensio = dimensioValida(teclat.nextInt());
        Bloc b3 = new Bloc(codColor, dimensio, false);
        
        System.out.println("Bloc 1: " + b1 + "\nBloc 2: " + b2 + "\nBloc 3: " + b3);
        
        boolean res = b3.potEstarDamuntDe(b2) && b2.potEstarDamuntDe(b1);
        System.out.print("\nLa torre formada amb aquests tres blocs");
        System.out.println(" és vàlida");
    }
}
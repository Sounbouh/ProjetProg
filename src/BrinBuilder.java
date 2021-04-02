import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BrinBuilder {
    public static int[] first_and_last_parenthesis(String appariement){
        int first = appariement.indexOf('(');
        int last = appariement.lastIndexOf(')');
        return new int[]{first, last};
    }

    public static String appariement_corrected_without_extremities(int[] position_extremities, String appariement_to_cut){
        StringBuilder cut_appariement = new StringBuilder(appariement_to_cut.length());
        for (int i = 0; i < appariement_to_cut.length(); i++) {
            char c = appariement_to_cut.charAt(i);
            if (c != '.'){
                if (c == '(' || c == '[' || c == '{'){
                    cut_appariement.append('(');
                } else if (c == ')' || c == ']' || c == '}'){
                    cut_appariement.append(')');
                } else {
                    cut_appariement.append('-');
                }
            }
        }
        return cut_appariement.substring(position_extremities[0],position_extremities[1]);
    }

    public static String sequence_corrected_without_extremities(int[] position_extremities, String sequence_to_cut){
        StringBuilder corrected_sequence = new StringBuilder(sequence_to_cut.length());
        for (int i = 0; i < sequence_to_cut.length(); i++) {
            if (sequence_to_cut.charAt(i) != '.'){
                corrected_sequence.append(sequence_to_cut.charAt(i));
            }
        }
        return corrected_sequence.toString().toUpperCase().substring(position_extremities[0],position_extremities[1]);
    }

    public static Brin lire_fichier(String filename) {
        //Methode qui donne à partir de fichier en format Stockholm la séquence consensus et l'appariement correspondant
        String sequence= null;
        String appariement = null;
        String sequence_corrigee = null;
        String appariement_corrigee = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String currentLine;
            while ((currentLine= reader.readLine()) != null){
                if (currentLine.startsWith("#=GC SS_cons")){
                     appariement = currentLine.substring(27);
                } else if(currentLine.startsWith("#=GC RF")){
                    sequence = currentLine.substring(27);
                }
            }
        } catch (IOException e) {
            System.out.println("Erreur lors de l'accès au fichier " + filename);
            System.exit(1);
        }
        if(appariement != null && sequence != null){
            int[] positions_to_cut = first_and_last_parenthesis(appariement);
            sequence_corrigee = sequence_corrected_without_extremities(positions_to_cut,sequence);
            appariement_corrigee = appariement_corrected_without_extremities(positions_to_cut, sequence);
        }
        else {
            System.out.println("Appariement et/ou sequence absent du fichier");
        }

        return new Brin(sequence_corrigee, appariement_corrigee);
    }
}

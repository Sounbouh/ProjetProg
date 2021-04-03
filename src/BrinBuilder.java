import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BrinBuilder {
    public static int[] firstAndLastParenthesis(String appariement){
        int first = appariement.indexOf('(');
        int last = appariement.lastIndexOf(')');
        return new int[]{first, last};
    }

    public static String cutExtremities(int[] positionExtremities, String elementBrin){
        return elementBrin.substring(positionExtremities[0],positionExtremities[1]);
    }

    public static String appariement_corrected_without_extremities(String appariementToCorrect){
        StringBuilder correctedAppariement = new StringBuilder(appariementToCorrect.length());
        for (int i = 0; i < appariementToCorrect.length(); i++) {
            char c = appariementToCorrect.charAt(i);
            if (c != '.'){
                if (c == '(' || c == '[' || c == '{' || c == '<'){
                    correctedAppariement.append('(');
                } else if (c == ')' || c == ']' || c == '}' || c == '>'){
                    correctedAppariement.append(')');
                } else {
                    correctedAppariement.append('-');
                }
            }
        }
        return correctedAppariement.toString();
    }

    public static String sequence_corrected_without_extremities(String sequence_to_correct){
        StringBuilder corrected_sequence = new StringBuilder(sequence_to_correct.length());
        for (int i = 0; i < sequence_to_correct.length(); i++) {
            if (sequence_to_correct.charAt(i) != '.'){
                corrected_sequence.append(sequence_to_correct.charAt(i));
            }
        }
        return corrected_sequence.toString().toUpperCase();
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
            sequence_corrigee = sequence_corrected_without_extremities(sequence);
            appariement_corrigee = appariement_corrected_without_extremities(appariement);
        } else {
            System.out.println("Appariement et/ou sequence absent du fichier");
            System.exit(1);
        }
        int[] position_extremities = firstAndLastParenthesis(appariement_corrigee);
        return new Brin(cutExtremities(position_extremities, sequence_corrigee),
                cutExtremities(position_extremities, appariement_corrigee));
    }
}

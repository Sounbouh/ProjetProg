import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StrandBuilder {
    /**
     *
     * @param parenthesing
     * @return position de la première et dernière parenthése
     */
    public static int[] firstAndLastParenthesis(String parenthesing){
        int first = parenthesing.indexOf('(');
        int last = parenthesing.lastIndexOf(')');
        return new int[]{first, last};
    }

    /**
     *
     * @param positionExtremities position de la première et derniere parenthèses
     * @param elementStrand séquence ou parenthésage
     * @return parenthésage ou parenthésage sans les extrémités non appariées
     */
    public static String cutExtremities(int[] positionExtremities, String elementStrand){
        return elementStrand.substring(positionExtremities[0],positionExtremities[1]+1);
    }

    //Méthode qui modifie les notations de la séquence d'appariement pour ne garder que des parenthèses et des tirets
    public static String appariement_corrected_without_extremities(String appariementToCorrect){
        StringBuilder correctedAppariement = new StringBuilder(appariementToCorrect.length());
        for (int i = 0; i < appariementToCorrect.length(); i++) {
            char c = appariementToCorrect.charAt(i);
            if (c != '.'){
                if (c == '(' || c == '[' || c == '{' || c == '<'){
                    correctedParenthesing.append('(');
                } else if (c == ')' || c == ']' || c == '}' || c == '>'){
                    correctedParenthesing.append(')');
                } else {
                    correctedParenthesing.append('-');
                }
            }
        }
        return correctedParenthesing.toString();
    }

    //Méthode qui retire les points de la séquence consensus et l'écrit en majuscule
    public static String sequence_corrected_without_extremities(String sequence_to_correct){
        StringBuilder corrected_sequence = new StringBuilder(sequence_to_correct.length());
        for (int i = 0; i < sequence_to_correct.length(); i++) {
            if (sequence_to_correct.charAt(i) != '.'){
                corrected_sequence.append(sequence_to_correct.charAt(i));
            }
        }
        return corrected_sequence.toString().toUpperCase();
    }

    /**
     * Methode qui permet de couper les extrémites non appariées de la séquence et le parenthésage
     * @param sequence : sequence de l'ARN
     * @param parenthesing : parenthésage de la structure secondaire de l'ARN
     * @return Brin contenant séquence et parenthésage tronqué
     */
    public static Strand input_brin(String sequence, String parenthesing){
        int[] position_extremities = firstAndLastParenthesis(parenthesing);
        Strand corrected = new Strand(cutExtremities(position_extremities, sequence),
                cutExtremities(position_extremities, parenthesing));
        if (!corrected.testParenthesing()) { /*doit corriger la méthode*/
            System.out.println("Erreur : la séquence et le parenthésage ne correspondent pas");
            System.exit(1);
        }
        return corrected;
    }

    /**
     * Methode qui donne à partir de fichier en format Stockholm la séquence consensus et l'appariement correspondant
     * @param filename : chemin relatif du fichier
     * @return Brin avec le parenthésage modifié pour n' avoir que '(',')' et '-' comme caractères et sans les gaps et la séquence correspondante
     */
    public static Strand readFile(String filename) {
        String sequence= null;
        String parenthesing = null;
        String sequenceCorrected = null;
        String parenthesingCorrected = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String currentLine;
            while ((currentLine= reader.readLine()) != null){
                if (currentLine.startsWith("#=GC SS_cons")){
                     parenthesing = currentLine.substring(27);
                } else if(currentLine.startsWith("#=GC RF")){
                    sequence = currentLine.substring(27);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erreur lors de l'accès au fichier " + filename);
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("Erreur de type I/O");
            e.printStackTrace();
        }
        if(parenthesing != null && sequence != null){
            sequenceCorrected = sequence_corrected(sequence);
            parenthesingCorrected = parenthesingCorrected(parenthesing);
        } else {
            System.out.println("Appariement et/ou sequence absent du fichier");
            System.exit(1);
        }
        return input_brin(sequenceCorrected,parenthesingCorrected);
    }
}

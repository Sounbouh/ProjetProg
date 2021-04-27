import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class StrandBuilder {
    /**
     * Methode pour obtenir la position de la première et dernière parenthése
     * @param parenthesing parenthesage de l'ARN
     * @return tableau avec les positions
     */
    public static int[] firstAndLastParenthesis(String parenthesing){
        int first = parenthesing.indexOf('(');
        int last = parenthesing.lastIndexOf(')');
        return new int[]{first, last};
    }

    /**
     * Méthode qui coupe une séquence au niveau des positions données
     * @param positionExtremities position de la première et derniere parenthèses
     * @param elementStrand séquence ou parenthésage
     * @return parenthésage ou parenthésage sans les extrémités non appariées
     */
    public static String cutExtremities(int[] positionExtremities, String elementStrand){
        return elementStrand.substring(positionExtremities[0],positionExtremities[1]+1);
    }

    /**
     * Méthode qui corrige les parenthésages alternatifs et enlève les gaps
     * @param parenthesingToCorrect appariement avec gap(s) et parenthésages particuliers
     * @return parenthésage sans gap et avec uniquement '(', ')' et '-'
     */
    public static String parenthesingCorrected(String parenthesingToCorrect){
        StringBuilder correctedParenthesing = new StringBuilder(parenthesingToCorrect.length());
        for (int i = 0; i < parenthesingToCorrect.length(); i++) {
            char c = parenthesingToCorrect.charAt(i);
            if (c != '.'){
                if (c == '(' || c == '[' || c == '{' || c == '<'){ //Caractères correspondant à des parenthèses ouvrantes
                    correctedParenthesing.append('(');
                } else if (c == ')' || c == ']' || c == '}' || c == '>'){ //Caractères correspondant à des parenthèses fermantes
                    correctedParenthesing.append(')');
                } else {
                    correctedParenthesing.append('-');
                }
            }
        }
        return correctedParenthesing.toString();
    }

    /**
     * Methode qui enleve les gaps
     * @param sequenceToCorrect séquence avec gap(s)
     * @return séquence sans les gap(s)
     */
    public static String sequence_corrected(String sequenceToCorrect){
        StringBuilder correctedSequence = new StringBuilder(sequenceToCorrect.length());
        for (int i = 0; i < sequenceToCorrect.length(); i++) {
            if (sequenceToCorrect.charAt(i) != '.'){
                correctedSequence.append(sequenceToCorrect.charAt(i));
            }
        }
        return correctedSequence.toString().toUpperCase();
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
        if (!corrected.testParenthesing()) { //Le parenthésage ne correspond pas à la séquence
            System.out.println("Erreur : la séquence et le parenthésage ne correspondent pas");
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

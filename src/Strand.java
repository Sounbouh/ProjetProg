import java.util.Stack;

//Classe permettant de représenter un brin d'ARN avec sa séquence et son appariement en parenthésage
public class Strand {

    final String sequence;
    final String parenthesing;

    //Constructeur
    public Strand(String sequence, String parenthesing) {
        this.sequence = sequence;
        this.parenthesing = parenthesing;
    }

    /**
     * Méthode vérifiant la correspondance entre le parenthésage et la séquence
     * Seuls les A et U et les C et G peuvent être appariés entre eux
     * Quand une parenthèse ouvrante est lue dans le parenthésage, son nucléotide correspond est empilé
     * Quand une parenthèse fermante est lue, le dernier nucléotide empilé est lu et comparé au nucléotide correspond
     * à la parenthèse fermante
     * @return true si le parenthésage correspond à la séquence
     */
    public boolean testParenthesing() {
        if (this.sequence.length() == this.parenthesing.length()) {
            Stack pile = new Stack();
            for (int i = 0; i < this.parenthesing.length(); i++) {
                if (this.parenthesing.charAt(i) == '('){
                    pile.push(this.sequence.charAt(i));
                } else if (this.parenthesing.charAt(i) == ')'){
                    if (this.sequence.charAt(i) == 'A' && (pile.peek().equals('G')  || pile.peek().equals('C') || pile.peek().equals('A'))) {
                        return false;
                    } else if (this.sequence.charAt(i) == 'U' && (pile.peek().equals('G')  || pile.peek().equals('C') || pile.peek().equals('U'))) {
                        return false;
                    } else if (this.sequence.charAt(i) == 'G' && (pile.peek().equals('G')  || pile.peek().equals('U') || pile.peek().equals('A'))) {
                        return false;
                    } else if (this.sequence.charAt(i) == 'C' && (pile.peek().equals('C')  || pile.peek().equals('U') || pile.peek().equals('A'))) {
                        return false;
                    }
                    pile.pop(); /*défile le nucléotide*/
                }
            }
        } else { /*le parenthésage et la séquence n'ont pas la même taille*/
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Brin{" +
                "sequence='" + sequence + '\'' +
                ", appariement='" + parenthesing + '\'' +
                '}';
    }

    /**
     * Verifie que 2 brins sont égaux
     * @param strand2 brin à comparer
     * @param méthode choix de si on compare que le parenthésage ("forme") ou aussi la séquence
     * @return true si les deux brins sont égaux
     */
    public boolean strandEgality(Strand strand2, String methode) {
        if (methode.equals("forme")) {
            return this.sameParenthesing(strand2);
        } else {
            return this.sequences_et_formes_egales(strand2);
        }
    }

    /**
     * Méthode vérifiant que deux parenthésage sont égaux
     * @param strand brin à comparer
     * @return true si les deux parenthésages sont égaux ou au moins le début
     */
    public boolean sameParenthesing(Strand strand) {
        int i = 0;
        int j = 0;
        while (this.parenthesing.charAt(i) != '(') {
            i++;
        }
        while (strand.parenthesing.charAt(j) != '(') {
            j++;
        }
        while (i < this.parenthesing.length() && j < strand.parenthesing.length()) {
            if (this.parenthesing.charAt(i) == strand.parenthesing.charAt(j)) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Méthode vérifiant que le parenthésage et la séquence correspondent
     * @param strand2 brin à comparer
     * @return true si le parenthésage et la séquence sont identiques ou au moins le début
     */
    public boolean sequences_et_formes_egales(Strand strand2) {
        int i = 0;
        int j = 0;
        while (i < this.parenthesing.length() && j < strand2.parenthesing.length()) {
            if (this.parenthesing.charAt(i) == strand2.parenthesing.charAt(j) && this.sequence.charAt(i) == strand2.sequence.charAt(j)) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * Methode vérifiant que le motif ARN est présent dans l'ARN
     * @param motif Brin du motif
     * @param useSequence false si non utilisation de la séquence pour comparer
     * @return true si le motif est présent
     */
    public boolean contains(Strand motif, boolean useSequence) {
        if (this.parenthesing.contains(motif.parenthesing)) {
            if (!useSequence) {
                return true;
            } else {
                return this.parenthesing.indexOf(motif.parenthesing) == this.sequence.indexOf(motif.sequence);
            }

        }
        return false;
    }

    //

    /**
     * Methode permettant de trouver la plus grand partie de séquence/parenthésage en commun
     * Pour vérifier qu'on a bien une structure secondaire le nombre de parenthèses ouvrante
     * doit être égal au nombre de fermante
     * @param strandToCompare ARN à comparer
     * @return Brin correspondant à la plus grande structure secondaire en commun
     */
    public Strand biggestSubstrand(Strand strandToCompare) {
        int bestScore = 0;
        StringBuilder bestSequence = new StringBuilder();
        StringBuilder bestParenthesing = new StringBuilder();
        StringBuilder bufferSequence = new StringBuilder();
        StringBuilder bufferParenthesing = new StringBuilder();
        if (this.contains(strandToCompare, true)) {//si strandToCompare est entièrement motif de this
            return this;
        } else {
            for (int i = 0; i < this.parenthesing.length(); i++) {
                for (int j = 0; j < strandToCompare.parenthesing.length(); j++) {
                    int nb_opening_parenthesis = 0;
                    int nb_closing_parenthesis = 0;
                    while (i < this.parenthesing.length() && j < strandToCompare.parenthesing.length()
                            && this.parenthesing.charAt(i) == strandToCompare.parenthesing.charAt(j)
                            && this.sequence.charAt(i) == strandToCompare.sequence.charAt(j)) {
                        bufferSequence.append(this.sequence.charAt(i));
                        bufferParenthesing.append(this.parenthesing.charAt(i));
                        if (this.parenthesing.charAt(i) == '(') nb_opening_parenthesis++;
                        else if (this.parenthesing.charAt(i) == ')') nb_closing_parenthesis++;
                        i++;
                        j++;
                    }
                    if (bufferSequence.length() > bestScore && nb_closing_parenthesis == nb_opening_parenthesis) {
                        /*si le dernier motif possible est plus grand que le maximum, il devient le plus grand motif connu*/
                        bestScore = bufferSequence.length();
                        bestSequence.append(bufferSequence);
                        bestParenthesing.append(bufferParenthesing);
                    }
                    bufferSequence.setLength(0);
                    bufferParenthesing.setLength(0);
                }
            }
        }
        return new Strand(bestSequence.toString(), bestParenthesing.toString());
    }
}

import java.util.Stack;

public class Brin {

    final String sequence;
    final String appariement;


    public Brin(String sequence, String appariement) {
        this.sequence = sequence;
        this.appariement = appariement;
    }


    public boolean verification_appariement() { //ne fonctionne pas vu que le parenthésage n'est pas symétrique, il faudrait faire une pile/file xD
        if (this.sequence.length() == this.appariement.length()) {
            int len = this.appariement.length();
            Stack pile = new Stack();
            for (int i = 0; i < this.appariement.length(); i++) {
                if (this.appariement.charAt(i) == '('){
                    pile.push(this.sequence.charAt(i));
                } else if (this.appariement.charAt(i) == ')'){
                    if (this.sequence.charAt(i) == 'A' && (pile.peek().equals('G')  || pile.peek().equals('C') || pile.peek().equals('A'))) {
                        return false;
                    } else if (this.sequence.charAt(i) == 'U' && (pile.peek().equals('G')  || pile.peek().equals('C') || pile.peek().equals('U'))) {
                        return false;
                    } else if (this.sequence.charAt(i) == 'G' && (pile.peek().equals('G')  || pile.peek().equals('U') || pile.peek().equals('A'))) {
                        return false;
                    } else if (this.sequence.charAt(i) == 'C' && (pile.peek().equals('C')  || pile.peek().equals('U') || pile.peek().equals('A'))) {
                        return false;
                    }
                    pile.pop();
                }
            }
        } else {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Brin{" +
                "sequence='" + sequence + '\'' +
                ", appariement='" + appariement + '\'' +
                '}';
    }
    //Méthode qui permet de vérifier que les structures secondaires sont les mêmes entre deux ARN
    public boolean egalite(Brin brin2, String methode) {
        if (methode.equals("forme")) {
            return this.parenthesages_egaux(brin2);
        } else {
            return this.sequences_et_formes_egales(brin2);
        }
    }

    //Méthode qui permet de vérifier que deux séquences ont même séquences de parenthésages (ou même forme)
    public boolean parenthesages_egaux(Brin brin) {
        /*problème : si une des sequences bien plus longue ==> comparaison que partielle*/
        int i = 0;
        int j = 0;
        while (this.appariement.charAt(i) != '(') {
            i++;
        }
        while (brin.appariement.charAt(j) != '(') {
            j++;
        }
        while (i < this.appariement.length() && j < brin.appariement.length()) {
            if (this.appariement.charAt(i) == brin.appariement.charAt(j)) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        return true;
    }

    //Méthode qui permet de vérifier que deux séqueces ont même séquence consensus et même forme
    public boolean sequences_et_formes_egales(Brin brin2) {
        int i = 0;
        int j = 0;
        while (this.appariement.charAt(i) == '-') {
            i++;
        }
        while (brin2.appariement.charAt(j) == '-') {
            j++;
        }
        while (i < this.appariement.length() && j < brin2.appariement.length()) {
            if (this.appariement.charAt(i) == brin2.appariement.charAt(j) && this.sequence.charAt(i) == brin2.sequence.charAt(j)) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        return true;
    }

    //Méthode qui permet de trouver si un arbre est présent comme motif dans un autre arbre
    public boolean contains(Brin motif, boolean useSequence) {
        if (this.appariement.contains(motif.appariement)) {
            if (!useSequence) {
                return true;
            } else {
                return this.appariement.indexOf(motif.appariement) == this.sequence.indexOf(motif.sequence);
            }

        }
        return false;
    }

    //Méthode permettant de trouver le plus grand sous-arbre commun à deux brins d'ARN
    public Brin biggestSubstrand(Brin strandToCompare) {
        int bestScore = 0;
        StringBuilder bestSequence = new StringBuilder();
        StringBuilder bestParenthesing = new StringBuilder();
        StringBuilder bufferSequence = new StringBuilder();
        StringBuilder bufferParenthesing = new StringBuilder();
        if (this.contains(strandToCompare, true)) {
            return this;
        } else {
            for (int i = 0; i < this.appariement.length(); i++) {
                for (int j = 0; j < strandToCompare.appariement.length(); j++) {
                    int nb_opening_parenthesis = 0;
                    int nb_closing_parenthesis = 0;
                    while (i < this.appariement.length() && j < strandToCompare.appariement.length()
                            && this.appariement.charAt(i) == strandToCompare.appariement.charAt(j)
                            && this.sequence.charAt(i) == strandToCompare.sequence.charAt(j)) {
                        bufferSequence.append(this.sequence.charAt(i));
                        bufferParenthesing.append(this.appariement.charAt(i));
                        if (this.sequence.charAt(i) == '(') nb_opening_parenthesis++;
                        else if (this.sequence.charAt(i) == ')') nb_closing_parenthesis++;
                        i++;
                        j++;
                    }
                    if (bufferSequence.length() > bestScore && nb_closing_parenthesis == nb_opening_parenthesis) {
                        bestScore = bufferSequence.length();
                        bestSequence.append(bufferSequence);
                        bestParenthesing.append(bufferParenthesing);
                    }
                    bufferSequence.setLength(0);
                    bufferParenthesing.setLength(0);
                }
            }
        }
        return new Brin(bestSequence.toString(), bestParenthesing.toString());
    }
}

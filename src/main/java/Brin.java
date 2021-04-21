public class Brin {

    final String sequence;
    final String appariement;


    public Brin(String sequence, String appariement) {
        this.sequence = sequence;
        this.appariement = appariement;
    }

    //Méthode qui permet de vérifier que les séquences ARN et d'appariement correspondent
    public boolean verification_appariement() {
        if (this.sequence.length() == this.appariement.length()) { /*On s'assure que les séquences ont la même taille */
            /*On prend seulement en compte les premiers et derniers nucléotides non appariés et
            on compare seulement à l’intérieur du premier couple de parenthèses*/
            int i = this.appariement.indexOf('(');
            int j = this.appariement.lastIndexOf(')');
            while (i < this.appariement.length() && j >= i) {
                while (this.appariement.charAt(i) != '(' && i < j) {
                    i++;
                    if (i == j) {
                        return true;
                    }
                }
                while (this.appariement.charAt(j) != ')') {
                    j--;
                }
                /*On vérifie que chaque couple de parenthèses correspond à un appariement Watson-Crick.*/
                if (this.sequence.charAt(i) == 'A' && (this.sequence.charAt(j) == 'G' || this.sequence.charAt(j) == 'C' || this.sequence.charAt(j) == 'A')) {
                    return false;
                } else if (this.sequence.charAt(i) == 'U' && (this.sequence.charAt(j) == 'G' || this.sequence.charAt(j) == 'C' || this.sequence.charAt(j) == 'U')) {
                    return false;
                } else if (this.sequence.charAt(i) == 'G' && (this.sequence.charAt(j) == 'G' || this.sequence.charAt(j) == 'U' || this.sequence.charAt(j) == 'A')) {
                    return false;
                } else if (this.sequence.charAt(i) == 'C' && (this.sequence.charAt(j) == 'U' || this.sequence.charAt(j) == 'C' || this.sequence.charAt(j) == 'A')) {
                    return false;
                }
                i++;
                j--;
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
    public Brin biggestSubstrand(Brin strandToCompare){
        if (this.contains(strandToCompare, true)){
            return this;
        } else{
            char[] strandSeqChar = this.sequence.toCharArray();
            char[] strandParenthesisChar = this.appariement.toCharArray();
            char[] strandToCompareSeqChar = strandToCompare.sequence.toCharArray();
            char[] strandToCompareParenthesisChar = strandToCompare.appariement.toCharArray();
            int strandlength = strandSeqChar.length;
            int strandToComparelength = strandToCompareSeqChar.length;
            int[][] cache = new int[strandlength+1][strandToComparelength+1];
            int max = 0;
            int row =0;
            int col = 0;
            for (int i = 0; i<strandlength; i++){
                for (int j = 0; j < strandToComparelength; j++) {
                    if (i ==0 || j == 0){
                        cache[i][j] = 0;
                    }
                    else if (strandSeqChar[i-1]==strandToCompareSeqChar[j-1]
                            && strandParenthesisChar[i-1]==strandToCompareParenthesisChar[j-1]){
                        cache[i][j] = cache[i-1][j-1] + 1;
                        if (cache[i][j]>max){
                            max = cache[i][j];
                            row = i;
                            col = j;
                        }
                    }else {
                        cache[i][j] = 0;
                    }
                }
            }
            if (max == 0){
                System.out.println("No common substring");
                return null;
            }
            StringBuilder biggestSubSequence = new StringBuilder();
            StringBuilder biggestSubParenthesis = new StringBuilder();
            while (cache[row][col] !=0){
                biggestSubSequence.append(strandSeqChar[row - 1]);
                biggestSubParenthesis.append(strandParenthesisChar[row - 1]);
                row --;
                col --;
            }
            return new Brin(biggestSubSequence.reverse().toString(), biggestSubParenthesis.reverse().toString());
        }
    }
}

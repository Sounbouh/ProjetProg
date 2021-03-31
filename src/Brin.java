public class Brin {

    private String sequence;
    private String appariement;


    public Brin(String sequence, String appariement) {
        this.sequence = sequence;
        this.appariement = appariement;
    }

    /*creer methode pour verifier sequence va avec appariement*/

    public boolean verification_appariement() {
        if (this.sequence.length() == this.appariement.length()) {
            int i = this.appariement.indexOf('(');
            int j = this.appariement.lastIndexOf(')');
            while (i < this.appariement.length() && j >= i) {
                while (this.appariement.charAt(i) != '(' && i < j) {
                    i++;
                    if (i == j){
                        return true;
                    }
                }
                while (this.appariement.charAt(j) != ')') {
                    j--;
                }
                char a = this.sequence.charAt(i);
                char b = this.sequence.charAt(j);
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

    public boolean egalite(Brin brin2, String methode) {
        if (methode.equals("forme")) {
            return this.parenthesages_egaux(brin2.appariement);
        } else {
            return this.sequences_et_formes_egales(brin2);
        }
    }

    public boolean parenthesages_egaux(String appariement2) {
        /*problème : si une des sequences bien plus longues ==> comparaison que partielle*/
        int i = 0;
        int j = 0;
        while (i < this.appariement.length()) {
            while (j < appariement2.length()) {
                if (this.appariement.charAt(i) == appariement2.charAt(j)) {
                    i++;
                    j++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean sequences_et_formes_egales(Brin brin2) {
        int i = 0;
        int j = 0;
        while (i < this.appariement.length()) {
            while (j < brin2.appariement.length()) {
                if (this.appariement.charAt(i) == brin2.appariement.charAt(j) && this.sequence.charAt(i) == brin2.sequence.charAt(j)) {
                    i++;
                    j++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Brin l = new Brin("ACGUGCCACGAUUCAACGUGGCACAG", "--((((((((------))))))))--");
        Brin l2 = new Brin("GGGUGCGACGAUUCAACGUGGCACAG", "--((((((((------))))))))--");
        System.out.println(l.verification_appariement());
        System.out.println(l2.verification_appariement());
        System.out.println(l.egalite(l2, "forme"));
        System.out.println(l.egalite(l2, "forme et sequences"));


    }


}

public class Brin {

    private String sequence;
    private String appariement;


    public Brin(String sequence, String appariement){
        this.sequence = sequence;
        this.appariement = appariement;
    }

    /*creer methode pour verifier sequence va avec appariement*/

    public boolean parenthesages_egaux(String appariement2){
        int i = 0;
        int j = 0;
        while (this.appariement.charAt(i)!='('){
            i++;
        }
        while (appariement2.charAt(j) != '('){
            j++;
        }
        while (i<this.appariement.length()){
            while (j<appariement2.length()){
                if (this.appariement.charAt(i) == appariement2.charAt(j)){
                    i++;
                    j++;
                } else {
                   return false;
                }
            }
        }
        return true;
    }

    public boolean sequences_et_formes_egales(Brin brin2){
        int i = 0;
        int j = 0;
        while (this.appariement.charAt(i)== '-'){
            i++;
        }
        while (brin2.appariement.charAt(j) == '-'){
            j++;
        }
        while (i<this.appariement.length()){
            while (j<brin2.appariement.length()){
                if (this.appariement.charAt(i) == brin2.appariement.charAt(j) && this.sequence.charAt(i)==brin2.sequence.charAt(j)){
                    i++;
                    j++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        Brin l = new Brin("ACGUGCCACGAUUCAACGUGGCACAG", "--((((((((------))))))))--");
        Brin l2 = new Brin("GGGUGCCACGAUUCAACGUGGCACAG","--((((((((------))))))))--");
        System.out.println(l.parenthesages_egaux(l2.appariement));
        System.out.println(l.sequences_et_formes_egales(l2));


    }


}

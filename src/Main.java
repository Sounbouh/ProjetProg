public class Main {
    public static void main(String[] args){
        System.out.println(BrinBuilder.lire_fichier("RF00005.stockholm.txt")+ "\n"+BrinBuilder.lire_fichier("RF00005.stockholm.txt"));
        Brin l = new Brin("ACGUGCCACGAUUCAACGUGGCACAG", "--((((((((------))))))))--");
        Brin l2 = new Brin("GGGUGCCACGAUUCAACGUGGCACAG","--((((((((------))))))))--");
        System.out.println(l.parenthesages_egaux(l2));
        System.out.println(l.sequences_et_formes_egales(l2));
    }
}

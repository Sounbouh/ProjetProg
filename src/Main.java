public class Main {
    public static void main(String[] args){
        Brin test = BrinBuilder.lire_fichier("RF00005.stockholm.txt");
        System.out.println(test.toString());
        Brin l = new Brin("ACGUGCCACGAUUCAACGUGGCACAG", "--((((((((------))))))))--");
        Brin l2 = new Brin("UUUGUGCCACGAUUCAACGUGGCAC","---((((((((------))))))))");
        Brin l3 = new Brin("GUGCCACGAUUCAACGUGGCAC","((((((((------))))))))");
        System.out.println(l.parenthesages_egaux(l2));
        System.out.println(l.sequences_et_formes_egales(l2));
        System.out.println(l);
        Tree arbre = Tree.strandToTree(l);
        System.out.println(arbre.treeToParenthesis());
        //System.out.println(arbre.treeToSequence());
        Tree motif = Tree.strandToTree(l2);
        Tree motif2 = Tree.strandToTree(l3);
//        System.out.println(l.contains(l2,true));
//        System.out.println(l.contains(l2,false));
        System.out.println(l2.biggestSubstrand(l));
    }
}

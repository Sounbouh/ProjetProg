public class Main {
    public static void main(String[] args){
        Brin test = BrinBuilder.lire_fichier("RF00005.stockholm.txt");
        System.out.println(test.toString());
        Brin l = BrinBuilder.input_brin("ACGUGCCACGAUUCAACGUGGCACAG", "--((((((((------))))))))--");
        Brin l2 = BrinBuilder.input_brin("UUUGUGCCACGAUUCAACGUGGCAC","---((((((((------))))))))");
        Brin l3 = BrinBuilder.input_brin("GUGCCACGAUUCAACGUGGCAC","((((((((------))))))))");
        System.out.println(l.parenthesages_egaux(l2));
        System.out.println(l.sequences_et_formes_egales(l2));
        System.out.println(l);
        Tree arbre = Tree.parenthesis_to_tree(l.appariement,l.sequence);
        System.out.println(arbre.treeToParenthesis());
        //System.out.println(arbre.treeToSequence());
        Tree motif = Tree.parenthesis_to_tree(l2.appariement,l2.sequence);
        Tree motif2 = Tree.parenthesis_to_tree(l3.appariement,l3.sequence);
        System.out.println(l.contains(l2,true));
        System.out.println(l.contains(l2,false));
        System.out.println(l2.biggestSubstrand(l));
    }
}

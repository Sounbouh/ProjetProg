public class Tests {
    public static void main(String[] args){
        Strand test = StrandBuilder.readFile("RF00005.stockholm.txt");
        System.out.println(test.toString());
        Strand l = new Strand("ACGUGCCACGAUUCAACGUGGCACAG", "--((((((((------))))))))--");
        Strand l2 = new Strand("UUUGUGCCACGAUUCAACGUGGCAC","---((((((((------))))))))");
        Strand l3 = new Strand("GUGCCACGAUUCAACGUGGCAC","((((((((------))))))))");
        System.out.println(l.sameParenthesing(l2));
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

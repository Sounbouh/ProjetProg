public class Tests {
    public static void main(String[] args){
        Strand test = StrandBuilder.readFile("RF00005.stockholm.txt");
        System.out.println(test.toString());
        Strand l = new Strand("ACGUGCCACGAUUCAACGUGGCACAG", "--((((((((------))))))))--");
        Strand l2 = new Strand("UUUGUGCCACGAUUCAACGUGGCAC","---((((((((------))))))))");
        Strand l3 = new Strand("GUGCCACGAUUCAACGUGGCAC","((((((((------))))))))");
        Strand ltest1 = new Strand("AAUU", "(())");
        Strand ltest2 = new Strand("AAAAGGCCUU", "((--(())))");
        System.out.println(l.sameParenthesing(l2));
        System.out.println(l.sameSequenceAndParenthesing(l2));
        System.out.println(l);
        Tree arbre = Tree.strandToTree(l);
        System.out.println(arbre.treeToParenthesis());
        //System.out.println(arbre.treeToSequence());
        Tree motif = Tree.strandToTree(l2);
        Tree motif2 = Tree.strandToTree(l3);
//        System.out.println(l.contains(l2,true));
//        System.out.println(l.contains(l2,false));
        System.out.println(ltest1.biggestSubstrand(ltest2));
    }
}

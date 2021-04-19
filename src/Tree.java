import java.util.ArrayList;
import java.util.Arrays;

public class Tree {
    private ArrayList<Tree> children = new ArrayList<>();
    private Tree linkTofather;
    private String label;

    @Override
    public String toString() {
        return label;
    }

    public Tree() {
    }

    public Tree(String label, Tree father) {
        this.label = label;
        this.linkTofather = father;
    }

    public void addChildren(String label) {
        Tree child = new Tree(label, this);
        child.label = label;
        this.children.add(child);
    }

    public void addPair(String base) {
        this.label += base;
    }

    public Tree lastChild() {
        return this.children.get(this.children.size() - 1);
    }

    public static Tree parenthesis_to_tree(String appariement, String sequence) {
        Tree racine = new Tree();
        Tree father = racine;
        for (int i = 0; i < appariement.length(); i++) {
            if (appariement.charAt(i) == '(') {
                father.addChildren(Character.toString(sequence.charAt(i)));
                father = father.lastChild();
            } else if (appariement.charAt(i) == ')') {
                father.addPair(Character.toString(sequence.charAt(i)));
                father = father.linkTofather;
            } else if (appariement.charAt(i) == '-') {
                father.addChildren(Character.toString(sequence.charAt(i)));
            }
        }
        return racine;
    }

    public String treeToParenthesis() {
        StringBuilder parenthesis = new StringBuilder();
        for (Tree node : this.children) {
            if (Arrays.asList("A", "U", "G", "C").contains(node.label)) {
                parenthesis.append('-');
            } else {
                parenthesis.append('(');
                parenthesis.append(node.treeToParenthesis());
                parenthesis.append(')');
            }
        }
        return parenthesis.toString();
    }

    public void affichageArbre() {
        for (Tree noeud : this.children) {
            if (noeud.children != null) {
                System.out.print("[" + noeud.label);
                noeud.affichageArbre();
                System.out.print("]");
            }
        }
    }
    public int numberOfNodes(){
        int number = this.children.size();
        if (this.children.size()!=0){
            for (Tree node: this.children) {
                number += node.numberOfNodes();
            }
        }
        return number;
    }
    public boolean egalityTest(Tree toCompare) {
        if (this.numberOfNodes()== toCompare.numberOfNodes() && this.children.size()==toCompare.children.size()){
            for (int i = 0; i < this.children.size(); i++) {
                Tree node = this.children.get(i);
                Tree nodeToCompare = toCompare.children.get(i);
                if (!node.egalityTest(nodeToCompare)){
                    return false;
                }
            }
            return true;
        } else{
            return false;
        }
    }

//    public ArrayList<Tree> allLeaves (){
//        ArrayList<Tree> leaves = new ArrayList<>();
//        for (Tree node: this.children) {
//            if (node.children.size() == 0){
//                leaves.add(node);
//            } else {
//                leaves.addAll(node.allLeaves());
//            }
//        }
//        return leaves;
//    }

    public boolean presentInTree(Tree motif, boolean UseSequence) {
        if (!UseSequence) {
            if (this.egalityTest(motif)){
                return true;
                }
            else {
                for (Tree node: this.children) {
                    if (node.presentInTree(node,UseSequence)){
                        return true;
                    }
                }
            }
        }
//                int i =0;
//                while (this.children.get(i).label.equals(motif.children.get(i).label)){
//                    i++;
//                }
//            }
//            if (this.egalityTest(motif)){
//                return true;
//            } else {
//                for (Tree node : this.children) {
//                    if (node.egalityTest(motif)) {
//                        return true;
//                    } else {
//                        return node.presentInTree(motif, UseSequence);
//                    }
//                }
//            }
//        }
//        else {
//            if (this.children.size() == motif.children.size()){
//                int i = 0;
//                while (i<this.children.size() && !this.children.get(i).presentInTree(motif.children.get(i),UseSequence)){
//                    i+=1;
//                }
//            return this.children.get(i).presentInTree(motif.children.get(i),UseSequence);
//            } else {
//                for (Tree node: this.children) {
//
//                }
//            }
//        }
        return false;
    }

//    public Tree biggestSubTree(Tree toCompare) {
//
//    }
}


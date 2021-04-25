import java.util.ArrayList;
import java.util.Arrays;

//Classe permettant de représentant les brins d'ARN en arbre
public class Tree {
    private ArrayList<Tree> children = new ArrayList<>();
    private Tree linkTofather;
    private String label;

    //Constructeurs
    public Tree() { //Arbre vide
    }

    public Tree(String label, Tree father) { //Noeud d'un arbre
        this.label = label;
        this.linkTofather = father;
    }

    /**
     * Méthode permettant d'ajouter un enfant à un noeud de l'arbre
     * @param label nucléotide de l'enfant
     */
    public void addChildren(String label) {
        Tree child = new Tree(label, this);
        child.label = label;
        this.children.add(child);
    }

    /**
     * Méthode permettant d'associer une base à sa paire
     * @param base base appariée au nucléotide déja présent dans le label
     */
    public void addPair(String base) {
        this.label += base;
    }

    /**
     * Méthode permettant d'accéder au dernier fils ajouté à un noeud
     * @return dernier fils de l'arbre
     */
    public Tree lastChild() {
        return this.children.get(this.children.size() - 1);
    }

    /**
     * Méthode qui traduit le brin en arbre
     * @param RNA Brin à traduire
     * @return brin traduit en arbre
     */
    public static Tree strandToTree(Strand RNA) {
        String appariement = RNA.parenthesing;
        String sequence = RNA.sequence;
        Tree racine = new Tree();
        Tree father = racine;
        for (int i = 0; i < appariement.length(); i++) {
            if (appariement.charAt(i) == '(') { /*pour chaque "(", on ajoute un fils qui devient le noeud considéré comme père pour la suite*/
                father.addChildren(Character.toString(sequence.charAt(i)));
                father = father.lastChild();
            } else if (appariement.charAt(i) == ')') { /*pour chaque ")", on remonte au noeud précédent*/
                father.addPair(Character.toString(sequence.charAt(i)));
                father = father.linkTofather;
            } else if (appariement.charAt(i) == '-') { /*pour chaque "-" on ajoute un fils qui sera une feuille*/
                father.addChildren(Character.toString(sequence.charAt(i)));
            }
        }
        return racine;
    }

    /**
     * Méthode qui traduit l'arbre en système de parenthèses
     * @return parenthésage correspondant à l'arbre
     */
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

    /**
     * Méthode qui traduit l'arbre en séquence
     * @return séquence correspondant à l'arbre
     */
    public String treeToSequence() {
        StringBuilder sequence = new StringBuilder();
        for (Tree node : this.children) {
            if (Arrays.asList("A", "U", "G", "C").contains(node.label)) {
                sequence.append(node.label);
            } else {
                sequence.append(node.label.charAt(0));
                sequence.append(node.treeToSequence());
                sequence.append(node.label.charAt(1));
            }
        }
        return sequence.toString();
    }

    /**
     * Méthode qui traduit l'arbre en brin
     * @return brin correspondant à l'arbre
     */
    public Strand treeToStrand(){
        return new Strand(this.treeToSequence(), this.treeToParenthesis());
    }

    /**
     * Méthode qui permet d'afficher l'arbre à l' aide de crochet pour représenter les branches
     * @return String représentant l'arbre
     */
    @Override
    public String toString() {
        StringBuilder tree = new StringBuilder();
        for (Tree node : this.children) {
            if (node.children != null) { //Branche de l'arbre
                tree.append('[');
                tree.append(node.label); //Affiche nucléotide(s) du noeud de la branche
                tree.append(node.toString()); //Applique méthode à la branche
                tree.append(']');
            }
        }
        return tree.toString();
    }

    /**
     * Methode qui à partir d'un arbre compare si un motif ARN est présent dans l' arbre
     * @param motif Arbre correspond au motif dont on veut tester la présence
     * @param UseSequence Booléen correspond à l' utilisation (true) ou non de la comparaison de la séquence aussi
     * @return true si le motif est présent
     */
    public boolean presentInTree(Tree motif, boolean UseSequence) {
        Strand RNA = this.treeToStrand();
        Strand motifRNA = motif.treeToStrand();
        return RNA.contains(motifRNA, UseSequence);
    }

    /**
     * Methode qui compare deux arbres pour trouver le plus grand sous arbre
     * @param tree2 arbre qu' on veut comparer
     * @return sous-arbre commun
     */
    public Tree biggestTreeInCommon(Tree tree2){
        Strand RNA = this.treeToStrand();
        Strand RNA2 = tree2.treeToStrand();
        Strand biggestRNA =  RNA.biggestSubstrand(RNA2);
        return strandToTree(biggestRNA);
    }
}


import java.util.ArrayList;
import java.util.Arrays;

//Classe permettant de représentant les brins d'ARN en arbre
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

    //
    public Tree(String label, Tree father) {
        this.label = label;
        this.linkTofather = father;
    }

    //Méthode permettant d'ajouter des enfants à un noeud de l'arbre
    public void addChildren(String label) {
        Tree child = new Tree(label, this);
        child.label = label;
        this.children.add(child);
    }

    //Méthode permettant d'associer une base à sa paire
    public void addPair(String base) {
        this.label += base;
    }

    //Méthode permettant d'accéder au dernier fils ajouté à un noeud
    public Tree lastChild() {
        return this.children.get(this.children.size() - 1);
    }

    //Méthode qui traduit le parenthésage en arbre
    public static Tree parenthesis_to_tree(String appariement, String sequence) {
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

    //Méthode qui traduit l'arbre en système de parenthèses
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

    //Méthode qui permet d'afficher l'abre
    public void affichageArbre() {
        for (Tree noeud : this.children) {
            if (noeud.children != null) {
                System.out.print("[" + noeud.label);
                noeud.affichageArbre();
                System.out.print("]");
            }
        }
    }


    //Méthode permettant de comparer si deux arbres sont les mêmes
    public boolean egalityTest(Tree toCompare) {
        if (this.label.equals(toCompare.label)) {
            if (this.children == null && toCompare.children == null) {
                return true;
            } else if (this.children != null && toCompare.children != null) {
                if (this.children.size() == toCompare.children.size()){
                    for (int i = 0; i < this.children.size(); i++) {
                        if (this.children.get(i).label.equals(toCompare.children.get(i).label)){
                            if (!this.children.get(i).egalityTest(toCompare.children.get(i))){
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean presentInTree(Tree motif, boolean UseSequence) {
        if (UseSequence) {
            if (this.egalityTest(motif)){
                return true;
            } else {
                for (Tree node : this.children) {
                    if (node.egalityTest(motif)) {
                        return true;
                    } else {
                        return node.presentInTree(motif, UseSequence);
                    }
                }
            }
        }
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
}


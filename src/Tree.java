//partir d'un noeud origine, lire séquence : pour chaque -
//ajouter une feuille au noeud, pour chaque "(" ajouter un noeud fils
//dans ce nouveau noeud, pour chaque - ajouter une feuille, et pour chaque ( ajouter noeud
//pour ) remonter dans les noeuds, et si - ajouter feuille au noeud en cours

import java.util.ArrayList;

public class Tree<T> {
    private Node<T> racine;

    public Tree(T racineData) {
        this.racine = new Node<T>();
        racine.data = racineData;
        racine.enfants = new ArrayList<Node<T>>();
    }

    public static class Node<T> {
        private T data;
        private Node<T> parent;
        private List<Node<T>> enfants;
    }

    public void ajout_enfants(String appariement){
        int i = 0;
        if(this.appariement.charAt(i) == '-'){
            addfeuille to mainnode
            i++
        } else (this.appariement.charAt(i) == '('){
            addchildrenasnode to main node
                main node = newnode
            i++
        } else (this.appariement.charAt(i) == ')'){
            main node = previous node

        }
    }
}
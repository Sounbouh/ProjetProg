import java.util.ArrayList;

public class Arbre {
    public ArrayList<Arbre> parenthesage;
    public String lienVerslePere;
    public String noeud;

    //Noeuds arbre
    static class Noeud {
        int data;
        Noeud gauche, droite;
        Noeud (int data)
        {
            this.data = data;
            this.gauche = null;
            this.droite = null;
        }
    }

    //fonction pour insérer noeuds dans ordre
    public Noeud insertionNiveauArbre (int[] arr, Noeud racine, int i){

        if (i<arr.length){
            Noeud temp = new Noeud (arr[i]);
            racine = temp;

            racine.gauche = insertionNiveauArbre(arr, racine.gauche, 2*i +1);
            racine.droite = insertionNiveauArbre(arr, racine.droite, 2*i+2);
        }

        return racine;
    }

}



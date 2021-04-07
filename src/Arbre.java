import java.util.ArrayList;
import java.util.List;

public class Arbre {
    private String type;
    private String label;
    private List<Arbre> fils;

    public Arbre(String noeud, String label){
        this.label = label;
        fils = new ArrayList<>();
    }

    /*public Arbre(List<String> fils){
        fils = new ArrayList<>();
        this.tokens = tokens;
    }*/

    //Type of node ? je suppose que ça peut être intéressant si on veut comparer des sous arbres
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }

    //Returns all of the labels for this node and oll of its children
    public List<String> yield(ArrayList<String> strings){
        return yield(new ArrayList<String>());
    }

    //Retourne liste des labels for the node

    private List<String> yield(List Labels){
        labels.add(label);
        for(Arbre t : fils()){
            labels.addAll(t.yield());
        }
        return labels;
    }


}

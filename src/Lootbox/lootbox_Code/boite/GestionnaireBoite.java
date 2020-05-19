package Lootbox.lootbox_Code.boite;


import java.util.ArrayList;

public class GestionnaireBoite {

    private ArrayList<Boite> boites;

    public GestionnaireBoite(){
        boites=new ArrayList<>();
    }

    public void ajouter(Boite b){
        boites.add(b);
    }

    public int size(){
        return boites.size();
    }

    public Boite get(int i){
        return boites.get(i);
    }

    public String toString(){
        StringBuilder s = new StringBuilder(9999);
        for(Boite b : boites){
            s.append("\t" + b.toString() + "\n");
        }
        return s.toString();
    }

    public void reset() {
        for(Boite b : boites){
            b.reset();
        }
    }
}

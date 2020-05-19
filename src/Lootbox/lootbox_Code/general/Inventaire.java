package Lootbox.lootbox_Code.general;

import java.util.ArrayList;

public class Inventaire {

    private ArrayList<String> inventaire;
    private ArrayList<String> type;

    public Inventaire(){
        inventaire = new ArrayList<String>();
        type = new ArrayList<String>();
    }

    public ArrayList<String> getInventaire(){
        return inventaire;
    }

    public ArrayList<String> getType(){
        return type;
    }

    public void ajout(String s, String t) {
        for(int i=0; i<inventaire.size(); i++){
            if(s.equals(inventaire.get(i))){
                return;
            }
        }
        type.add(t);
        inventaire.add(s);
    }

    public void remove(String url){
        for(int i=0; i<inventaire.size(); i++){
            if(url.equals(inventaire.get(i))){
                type.remove(i);
            }
        }
    }

    public void reset() {
        inventaire = new ArrayList<String>();
        type = new ArrayList<String>();
    }
}

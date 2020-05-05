package Lootbox.lootbox_Code.general;

import Lootbox.lootbox_Code.boite.*;
import Lootbox.lootbox_IG.vues.Vue;
import Lootbox.lootbox_IG.vues.VueCompteur;
import Lootbox.lootbox_IG.vues.VueOuverture;
import javafx.scene.Node;

import java.util.ArrayList;

public class Monde{

    private GestionnaireBoite box;
    private ArrayList<Vue> vues;

    public Monde(){
        box = new GestionnaireBoite();
        box.ajouter(new BoisBoite());
        box.ajouter(new MetalBoite());
        box.ajouter(new DiamantBoite());
        vues = new ArrayList<>();
        vues.add(new VueOuverture(this,box.get(0)));
        vues.add(new VueOuverture(this,box.get(1)));
        vues.add(new VueOuverture(this,box.get(2)));
        vues.add(new VueCompteur(this,box.get(0)));
        vues.add(new VueCompteur(this,box.get(1)));
        vues.add(new VueCompteur(this,box.get(2)));
    }

    public String toString(){
        StringBuilder s = new StringBuilder(9999);
        s.append("Monde : " + box.size() + "\n");
        s.append(box.toString());
        return s.toString();
    }

    public void update() {
        for(Vue v : vues){
            v.notif();
        }
    }

    public ArrayList<Vue> getVues() {
        return vues;
    }
}
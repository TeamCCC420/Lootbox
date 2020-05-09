package Lootbox.lootbox_Code.general;

import Lootbox.lootbox_Code.boite.*;
import Lootbox.lootbox_IG.vues.Vue;
import Lootbox.lootbox_IG.vues.VueCompteur;
import Lootbox.lootbox_IG.vues.VueOuverture;
import javafx.scene.Node;

import java.util.ArrayList;

/**
 * Classe Monde, classe maitre du programme, qui instancie les graphismes et informations de chaque élément du programme
 */
public class Monde{

    private GestionnaireBoite box;
    private ArrayList<Vue> vues;

    /**
     * Constucteur du Monde
     */
    public Monde(){
        box = new GestionnaireBoite();
        box.ajouter(new BoisBoite());
        box.ajouter(new MetalBoite());
        box.ajouter(new DiamantBoite());
        vues = new ArrayList<>();
    }

    /**
     * Fonction inscrivant dans un String toutes les données du monde et de ce qu'il y a  à l'intérieur
     * @return String contenant toutes les informations
     */
    public String toString(){
        StringBuilder s = new StringBuilder(9999);
        s.append("Monde : " + box.size() + "\n");
        s.append(box.toString());
        return s.toString();
    }

    /**
     * Fontion qui update toutes les vues du programme, c'est à dire qui met à jour les graphismes
     */
    public void update() {
        for(Vue v : vues){
            v.notif();
        }
    }

    /**
     * Getter sur les vues du monde, c'est à dire les données graphiques
     * @return ArrayList<Vue></Vue> Vue du monde, données graphiques
     */
    public ArrayList<Vue> getVues() {
        return vues;
    }

    /**
     * Getter sur les données des boites
     * @return GestionnaireBoite gestionnaire complet contenat les boites
     */
    public GestionnaireBoite getBox(){
        return box;
    }

    public void reset() {
    }
}
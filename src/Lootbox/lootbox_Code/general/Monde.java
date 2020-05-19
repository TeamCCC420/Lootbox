package Lootbox.lootbox_Code.general;

import Lootbox.lootbox_Code.boite.*;
import Lootbox.lootbox_Code.jeu.GestionnaireCarte;
import Lootbox.lootbox_Code.outils.Semaphore;
import Lootbox.lootbox_IG.ecouteurs.*;
import Lootbox.lootbox_IG.vues.Vue;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

/**
 * Classe Monde, classe maitre du programme, qui instancie les graphismes et informations de chaque élément du programme
 */
public class Monde{

    private GestionnaireBoite box;
    private ArrayList<Vue> vues;
    private PorteFeuille pf;
    private GainIcone gi;
    private Inventaire inv;
    private boolean remise;
    private GestionnaireCarte cartes;

    /**
     * Constucteur du Monde
     */
    public Monde(){
        box = new GestionnaireBoite();
        box.ajouter(new BoisBoite());
        box.ajouter(new MetalBoite());
        box.ajouter(new DiamantBoite());
        vues = new ArrayList<>();
        pf = new PorteFeuille();
        gi = new GainIcone();
        inv = new Inventaire();
        remise = true;
        cartes = new GestionnaireCarte();
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

    public PorteFeuille getPf(){
        return pf;
    }

    public GainIcone getGi(){ return gi;}

    public Inventaire getInv(){ return inv;}

    public boolean getRemise() {
        return remise;
    }

    public void setRemise(boolean n) {
        remise = n;
    }

    public GestionnaireCarte getCartes(){
        return cartes;
    }

    public void reset() {
        this.inv.reset();
        this.gi.reset();
        this.box.reset();
        System.out.println(box.toString());
    }

    public boolean verifBois(){
        int c=0, m=0, r=0, e=0, l=0;
        for(String type : this.getInv().getType()){
            switch(type) {
                case "Commun":
                    c++;
                    break;
                case "Moyen":
                    m++;
                    break;
                case "Rare":
                    r++;
                    break;
                case "Epic":
                    e++;
                    break;
                case "Legendaire":
                    l++;
                    break;
            }
        }
        if(this.getGi().getCommun().length == c){
            if(this.getGi().getMoyen().length == m){
                if(this.getGi().getRare().length == r){
                    if(this.getGi().getEpic().length == e){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean verifMetal(){
        int c=0, m=0, r=0, e=0, l=0;
        for(String type : this.getInv().getType()){
            switch(type) {
                case "Commun":
                    c++;
                    break;
                case "Moyen":
                    m++;
                    break;
                case "Rare":
                    r++;
                    break;
                case "Epic":
                    e++;
                    break;
                case "Legendaire":
                    l++;
                    break;
            }
        }
        if(this.getGi().getCommun().length == c){
            if(this.getGi().getMoyen().length == m){
                if(this.getGi().getRare().length == r){
                    if(this.getGi().getEpic().length == e){
                        if(this.getGi().getLegendaire().length == l){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public boolean verifDiamant(){
        int c=0, m=0, r=0, e=0, l=0;
        for(String type : this.getInv().getType()){
            switch(type) {
                case "Commun":
                    c++;
                    break;
                case "Moyen":
                    m++;
                    break;
                case "Rare":
                    r++;
                    break;
                case "Epic":
                    e++;
                    break;
                case "Legendaire":
                    l++;
                    break;
            }
        }
        if(this.getGi().getMoyen().length == m){
            if(this.getGi().getRare().length == r){
                if(this.getGi().getEpic().length == e){
                    if(this.getGi().getLegendaire().length == l){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
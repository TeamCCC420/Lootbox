package Lootbox.lootbox_IG.vues;

import Lootbox.lootbox_Code.boite.Boite;
import Lootbox.lootbox_Code.boite.Compteur;
import Lootbox.lootbox_Code.general.Monde;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class VueCompteur extends VBox implements Vue {

    private Monde m;
    private Boite b;
    private Compteur c;
    private String[] code;
    private int[] valeur;
    private Label[] lables;

    public VueCompteur(Monde m, Boite b){
        this.m = m;
        this.b = b;
        c = b.getCompt();
        code = new String[5];
        code[0] = "Commun";
        code[1] = "Moyen";
        code[2] = "Rare";
        code[3] = "Epic";
        code[4] = "Legendaire";
        valeur = new int[5];
        for(int i=0; i<5; i++){
            valeur[i] = c.getValeur(code[i]);
            System.out.println(code[i] +" --> "+valeur[i]);
        }
        lables = new Label[5];
        for(int i=0; i<5; i++){
            System.out.println(code[i]);
            System.out.println(valeur[i]);
            lables[i] = new Label();
            lables[i].setText(new String(code[i] +" --> "+valeur[i]));
            super.getChildren().add(lables[i]);
        }
    }

    @Override
    public void notif() {
        for(int i=0; i<5; i++){
            valeur[i] = c.getValeur(code[i]);
        }
        for(int i=0; i<5; i++){
            lables[i].setText(code[i] +" --> "+valeur[i]);
            System.out.println(lables[i].toString());
        }
    }
}

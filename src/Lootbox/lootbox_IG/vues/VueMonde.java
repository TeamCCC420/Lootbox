package Lootbox.lootbox_IG.vues;

import Lootbox.lootbox_Code.general.Monde;
import javafx.geometry.Pos;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VueMonde extends VBox implements Vue {

    private Monde m;

    public VueMonde(Monde m){
        super();
        super.setAlignment(Pos.CENTER);
        this.m = m;
        VueOuverture vueO;
        VueCompteur vueC;
        HBox hbox = new HBox();
        hbox.setSpacing(100);
        hbox.setAlignment(Pos.CENTER);
        HBox hbox2 = new HBox();
        hbox2.setSpacing(20);
        hbox2.setAlignment(Pos.CENTER);
        for(int i=0; i<m.getBox().size(); i++) {
            vueC = new VueCompteur(m, m.getBox().get(i));
            hbox.getChildren().addAll(vueC);
            vueO = new VueOuverture(m, m.getBox().get(i));
            hbox2.getChildren().addAll(vueO);
            m.getVues().add(vueO);
            m.getVues().add(vueC);
        }
        super.getChildren().addAll(hbox2,hbox);
        super.setSpacing(20);
    }

    @Override
    public void notif() {

    }
}

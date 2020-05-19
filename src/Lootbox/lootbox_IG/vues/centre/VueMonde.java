package Lootbox.lootbox_IG.vues.centre;

import Lootbox.lootbox_Code.general.Monde;
import Lootbox.lootbox_Code.outils.TailleComposants;
import Lootbox.lootbox_IG.vues.Vue;
import javafx.geometry.Pos;
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
        hbox.setSpacing(40);
        hbox.setAlignment(Pos.CENTER);
        for(int i=0; i<m.getBox().size(); i++) {
            vueO = new VueOuverture(m, m.getBox().get(i));
            hbox.getChildren().addAll(vueO);
            m.getVues().add(vueO);
        }
        String url = new String("fond/fond.jpg");
        super.setStyle("-fx-background-image: url(" + url + "); -fx-background-size: "+ TailleComposants.getInstance().getLargeurEcran()+" "+ TailleComposants.getInstance().gethauteurEcran() +";");
        super.getChildren().addAll(hbox);
        super.setSpacing(20);
    }

    @Override
    public void notif() {

    }
}

package Lootbox.lootbox_IG.vues;

import Lootbox.lootbox_Code.boite.Boite;
import Lootbox.lootbox_Code.general.Monde;
import Lootbox.lootbox_IG.ecouteurs.EcouteurOuvrir;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


public class VueOuverture extends VBox implements Vue{

    private Monde m;
    private Boite b;
    private Label l;

    public VueOuverture(Monde m, Boite boite){
        super();
        super.setAlignment(Pos.CENTER);
        this.m = m;
        this.b = boite;
        ImageView image = new ImageView();
        switch(boite.getId()){
            case "Commun":
                image = new ImageView("imagesBoite/boitebois1.png");
                break;
            case "Rare":
                image = new ImageView("imagesBoite/boitemetal1.png");
                break;
            case "Legendaire":
                image = new ImageView("imagesBoite/boitediamant1.png");
                break;

        }
        //image.setPickOnBounds(true);
        image.setOnMouseClicked(new EcouteurOuvrir(m,boite,1));
        l = new Label();
        l.setText(b.getGain());
        super.setSpacing(20);
        super.getChildren().addAll(image, l);
    }

    @Override
    public void notif() {
        l.setText(b.getGain());
    }
}

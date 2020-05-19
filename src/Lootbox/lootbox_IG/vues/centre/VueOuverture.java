package Lootbox.lootbox_IG.vues.centre;

import Lootbox.lootbox_Code.boite.Boite;
import Lootbox.lootbox_Code.general.Monde;
import Lootbox.lootbox_Code.outils.TailleComposants;
import Lootbox.lootbox_IG.ecouteurs.*;
import Lootbox.lootbox_IG.vues.Vue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;


public class VueOuverture extends VBox implements Vue {

    private Monde m;
    private Boite b;
    private Label l;
    private ImageView image = new ImageView();

    public VueOuverture(Monde m, Boite boite){
        super();
        super.setAlignment(Pos.CENTER);
        this.m = m;
        this.b = boite;
        Label l2 = new Label("Prix : "+b.getPrixMonnaie()+" coins");
        switch(boite.getId()){
            case "Commun":
                image = new ImageView("imagesBoite/boitebois1.png");
                image.setOnMouseClicked(new EcouteurBoiteBougeBois(m,boite,1));
                break;
            case "Rare":
                image = new ImageView("imagesBoite/boitemetal1.png");
                image.setOnMouseClicked(new EcouteurBoiteBougeMetal(m,boite,1));
                break;
            case "Legendaire":
                image = new ImageView("imagesBoite/boitediamant1.png");
                image.setOnMouseClicked(new EcouteurBoiteBougeDiamant(m,boite,1));
                break;
        }
        //image.setPickOnBounds(true);
        image.setFitHeight(TailleComposants.getInstance().gethauteurCoffre());
        image.setFitWidth(TailleComposants.getInstance().getLargeurCoffre());
        l = new Label();
        l.setText("Gain : " +b.getGain());
        super.setPadding(new Insets(20));
        VueCompteur vueC = new VueCompteur(m, b);
        super.getChildren().addAll(image,l2, l,vueC);
        m.getVues().add(vueC);
        super.setStyle("-fx-background-color: #D9D9D9; -fx-border-color: black; -fx-border-insets: 5; -fx-border-width: 3; -fx-border-style: dashed;");
        super.setSpacing(10);
    }

    @Override
    public void notif() {
        l.setText("Gain : " +b.getGain());
        switch(b.getId()){
            case "Commun":
                if(m.verifBois()){
                    image = new ImageView("imagesBoite/boitevide.jpg");
                    image.setDisable(true);
                }
                break;
            case "Rare":
                if(m.verifMetal()){
                    image = new ImageView("imagesBoite/boitevide.jpg");
                    image.setDisable(true);
                }
                break;
            case "Legendaire":
                if(m.verifDiamant()){
                    image = new ImageView("imagesBoite/boitevide.jpg");
                    image.setDisable(true);
                }
                break;
        }
        image.setFitHeight(TailleComposants.getInstance().gethauteurCoffre());
        image.setFitWidth(TailleComposants.getInstance().getLargeurCoffre());
    }
}

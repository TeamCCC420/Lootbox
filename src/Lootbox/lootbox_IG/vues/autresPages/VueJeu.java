package Lootbox.lootbox_IG.vues.autresPages;

import Lootbox.lootbox_Code.general.Monde;
import Lootbox.lootbox_Code.jeu.Carte;
import Lootbox.lootbox_Code.outils.TailleComposants;
import Lootbox.lootbox_IG.ecouteurs.jeu.EcouteurJeuGeneral;
import Lootbox.lootbox_IG.vues.Vue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class VueJeu extends Pane implements Vue {

    private Monde monde;
    private ArrayList<ImageView> images;

    public VueJeu(Monde m) {
        super();
        super.setPrefHeight(TailleComposants.getInstance().gethauteurEcran());
        super.setPrefWidth(TailleComposants.getInstance().getLargeurEcran());
        Button info = new Button("Informations");
        info.setOnAction(new EcouteurJeuGeneral(m));
        super.getChildren().add(info);
        info.relocate(375,500);
        String url = new String("jeu/borne_arcade.png");
        super.setStyle("-fx-background-image: url(" + url + "); -fx-background-size: "+ (TailleComposants.getInstance().getLargeurEcran()-170)+" "+ (TailleComposants.getInstance().gethauteurEcran()-65) +";");
        this.monde = m;
        images = new ArrayList<ImageView>();
        VueJeu v = this;
        ImageView imageView;
        for(int i=0; i<monde.getCartes().getCartes().size(); i++){
            super.getChildren().add(moduleImage(monde.getCartes().getCartes().get(i)));
        }
    }

    private ImageView moduleImage(Carte c) {
        final ImageView imageView = new ImageView(c.getUrl());
        imageView.relocate(c.getX(),c.getY());
        imageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                c.setUrl("/jeu/carteretournecliquable.png");
                monde.update();
            }
        });
        imageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                c.setUrl("/jeu/carteretourne.png");
                monde.update();
            }
        });
        imageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(c.isQui()){
                    c.setUrl("/jeu/cartevalide.png");
                    monde.getPf().gainJeu();
                    monde.getCartes().resetVictoire();
                }else{
                    c.setUrl("/jeu/carterefuse.png");
                    monde.getPf().perteJeu();
                }
                monde.update();
            }
        });
        images.add(imageView);
        return imageView;
    }

    @Override
    public void notif() {
        for(int i=0; i<images.size(); i++){
            images.get(i).setImage(new Image(monde.getCartes().getCartes().get(i).getUrl()));
        }
    }

    public void reini(){
        for(ImageView i : images){
            i.setImage(new Image("/jeu/carteretourne.png"));
        }
        for(Carte c : monde.getCartes().getCartes()){
            c.setUrl("/jeu/carteretourne.png");
        }
    }
}

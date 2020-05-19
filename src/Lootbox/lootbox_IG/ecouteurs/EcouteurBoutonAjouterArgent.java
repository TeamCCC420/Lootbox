package Lootbox.lootbox_IG.ecouteurs;

import Lootbox.Main;
import Lootbox.lootbox_Code.general.Monde;
import Lootbox.lootbox_Code.outils.TailleComposants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EcouteurBoutonAjouterArgent implements EventHandler<ActionEvent> {

    private Monde m;

    public EcouteurBoutonAjouterArgent(Monde m){
        this.m = m;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VBox vboxPrincipal = new VBox();
        HBox hbox1 = new HBox();
        Stage dialogStage = new Stage();
        ImageView image = new ImageView("cartebancaire.png");
        image.setFitWidth(500);
        image.setFitHeight(300);
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Button b = new Button("Retour");
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                dialogStage.close();
            }
        });
        Button b1 = new Button("Payer 1$");
        Button b2 = new Button("Payer 2$");
        Button b3 = new Button("Payer 5$");
        Button b4 = new Button("Payer 10$");
        Button b5 = new Button("Payer 50$");
        b1.setOnAction(new EcouteurAjouterXArgent(m,1));
        b2.setOnAction(new EcouteurAjouterXArgent(m,2));
        b3.setOnAction(new EcouteurAjouterXArgent(m,5));
        b4.setOnAction(new EcouteurAjouterXArgent(m,10));
        b5.setOnAction(new EcouteurAjouterXArgent(m,50));
        hbox1.getChildren().addAll(b1,b2,b3,b4,b5);
        hbox1.setAlignment(Pos.CENTER);
        hbox1.setSpacing(20);
        vboxPrincipal.getChildren().addAll(image,hbox1,b);
        vboxPrincipal.setAlignment(Pos.CENTER);
        vboxPrincipal.setSpacing(20);
        dialogStage.setScene(new Scene(vboxPrincipal, TailleComposants.getInstance().getLargeurEcran()/1.5, TailleComposants.getInstance().gethauteurEcran()/1.5));
        dialogStage.setTitle("Ajouter de l'argent : par PETIT Brian et DUCHESNE Leila");
        dialogStage.show();
        dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/icones/iconeAppli.png")));
        String url = new String("fond/argent.jpg");
        vboxPrincipal.setStyle("-fx-background-image: url(" + url + "); -fx-background-size: "+ TailleComposants.getInstance().getLargeurEcran()/1.5+" "+ TailleComposants.getInstance().gethauteurEcran()/1.5 +";");

    }
}

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

public class EcouteurConvertir implements EventHandler<ActionEvent> {

    private Monde m;

    public EcouteurConvertir(Monde m) {
        this.m = m;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VBox vboxPrincipal = new VBox();
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        Button b = new Button("Retour");
        b.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                dialogStage.close();
            }
        });
        Button b1 = new Button("1$ --> 100 coins");
        Button b2 = new Button("2$ --> 250 coins");
        Button b3 = new Button("5$ --> 600 coins");
        Button b4 = new Button("10$ --> 1500 coins");
        Button b5 = new Button("50$ --> 9000 coins");
        b1.setOnAction(new EcouteurMonnaieConvertir(m,1));
        b2.setOnAction(new EcouteurMonnaieConvertir(m,2));
        b3.setOnAction(new EcouteurMonnaieConvertir(m,5));
        b4.setOnAction(new EcouteurMonnaieConvertir(m,10));
        b5.setOnAction(new EcouteurMonnaieConvertir(m,50));
        vboxPrincipal.getChildren().addAll(b5,b4,b3,b2,b1,b);
        vboxPrincipal.setAlignment(Pos.CENTER);
        vboxPrincipal.setSpacing(50);
        dialogStage.setScene(new Scene(vboxPrincipal, TailleComposants.getInstance().getLargeurEcran()/1.5, TailleComposants.getInstance().gethauteurEcran()/1.5));
        dialogStage.setTitle("Convertir de l'argent : par PETIT Brian et DUCHESNE Leila");
        dialogStage.show();
        dialogStage.setResizable(false);
        dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/icones/iconeAppli.png")));
        String url = new String("fond/convertir.jpg");
        vboxPrincipal.setStyle("-fx-background-image: url(" + url + "); -fx-background-size: "+ TailleComposants.getInstance().getLargeurEcran()/1.5+" "+ TailleComposants.getInstance().gethauteurEcran()/1.5 +";");
    }
}

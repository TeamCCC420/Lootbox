package Lootbox.lootbox_IG.ecouteurs.jeu;

import Lootbox.Main;
import Lootbox.lootbox_Code.general.Monde;
import Lootbox.lootbox_IG.vues.autresPages.VueJeu;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class EcouteurJeuGeneral implements EventHandler<ActionEvent> {

    private Monde monde;

    public EcouteurJeuGeneral(Monde m) {
        this.monde = monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setScene(new Scene(module(), 600,500));
        dialogStage.setTitle("Jouer et gagner ! : par PETIT Brian et DUCHESNE Leila");
        dialogStage.show();
        dialogStage.setResizable(false);
        dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/icones/iconeAppli.png")));
    }

    public VBox module(){
        VBox vBox = new VBox();
        vBox.setStyle("-fx-background-color: #ffffCC; -fx-border-color: black; -fx-border-insets: 5; -fx-border-width: 3; -fx-border-style: dashed;");
        StringBuilder s = new StringBuilder();
        s.append("Ceci est un jeu pour tenter de remporter des coins ! Les règles sont simples :\n");
        s.append("Parmis ses 8 cartes, 1 est correcte et les autres sont incorrectes, à vous de deviner laquelle est la bonne ! \n");
        s.append("\n");
        s.append("- Il vous suffit de cliquer sur un carte et de prier pour avoir trouver la bonne !\n");
        StringBuilder s1 = new StringBuilder();
        s1.append("- A chaque fois qu'une carte verte est trouvé, les cartes se réinitialise, à vous de retrouver cette carte !\n");
        s1.append("bonne chance ! \n");
        vBox.getChildren().addAll(new Label(s.toString()),module1(),new Label(s1.toString()));
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        return vBox;
    }

    public HBox module1(){
        HBox hBox = new HBox();
        VBox v1 = new VBox();
        v1.setSpacing(20);
        v1.setAlignment(Pos.CENTER);
        VBox v2 = new VBox();
        v2.setSpacing(20);
        v2.setAlignment(Pos.CENTER);
        v1.getChildren().addAll(new Label("- La bonne carte, \ncarte verte,\nvous offre 50 coins !\n"), new ImageView("/jeu/cartevalide.png"));
        v2.getChildren().addAll(new Label("- Les autres cartes, \ncartes rouges, \nvous retire 10 coins !\n"),new ImageView("/jeu/carterefuse.png"));
        hBox.getChildren().addAll(v1,v2);
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(50);
        return hBox;
    }
}

package Lootbox.lootbox_IG.ecouteurs;

import Lootbox.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EcouteurCCM implements EventHandler<ActionEvent> {

    public EcouteurCCM(){

    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage dialogStage = new Stage();
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.setScene(new Scene(module(), 900,500));
        dialogStage.setTitle("Tutoriel : par PETIT Brian et DUCHESNE Leila");
        dialogStage.show();
        dialogStage.setResizable(false);
        dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/icones/iconeAppli.png")));
    }

    public VBox module(){
        VBox vBox = new VBox();
        vBox.setStyle("-fx-background-color: #ddffdd; -fx-border-color: black; -fx-border-insets: 5; -fx-border-width: 3; -fx-border-style: dashed;");
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(20);
        StringBuilder s =new StringBuilder();
        s.append("Ici, nous vous expliquons comment fonctionne tout ce logiciel, ce système de lootbox avec remise !\n");
        s.append("\n");
        s.append("LES GAINS :\n");
        s.append("Grâce à cette lootbox, vous pouvez gagner des icones de nourritures téléchargeables ! Qui n'aime pas manger ?!\n");
        s.append("Il y a 5 catégories de gains :\n");
        s.append("Commun : Icone de nourritures peu intérréssante, mais que l'on obtient souvent.\n");
        s.append("Moyen : Icone de nourritures un peu plus alléchante, qui tombe assez souvent aussi.\n");
        s.append("Rare : Icone de nourriture que votre estomac réclame, il les veut, c'est une obsession ! Rare d'obtention\n");
        s.append("Epic : Icone nourriture vous faisant voyager à l'autre bout du monde, pour découvrir des saveurs... envoutantes ! Tres rare d'obtention.\n");
        s.append("Legendaire : Les icones de nourritures que vous voyez la nuit, dans vos reves les plus fou ! Tres tres rare d'obtiention.\n");
        s.append("\n");
        s.append("LES BOITES :\n");
        s.append("Elles sont au nombre de 3: une en bois, une en métal, et une en diamant.\n");
        s.append("Celle en Bois ne permet d'obtenir que des Gains de type [Commun, Moyen, Rare, Epic]\n");
        s.append("Celle en Metal permet d'obtenir des Gains de type [Commun, Moyen, Rare, Epic, Légendaire], mais les objets rares ont une faible probabilité\n");
        s.append("Celle en Bois ne permet d'obtenir que des Gains de type [Moyen, Rare, Epic, Légendaire], avec une probabilité plus élévée pour les objets les plus rares\n");
        s.append("Mais attention, les véritables probabilités sont tenues secretes !\n");
        s.append("\n");
        s.append("L'ARGENT\n");
        s.append("Chaque boite a son prix en Coins, vous pouvez payer pour remplir votre porte monnaie, et ainsi convertir cet argent en Coins, la monnaie du système ! \n");
        s.append("\n");
        s.append("LE JEU :\n");
        s.append("Pour gagner des coins, un mini jeu de pur chance vous est proposé ! \n");
        s.append("A vous de trouver la carte verte pour empocher 50 coins !\n");
        s.append("Mais garre aux cartes rouges, qui ferons fondre votre porte-Coins à vue d'oeil !\n");
        s.append("\n");
        s.append("Bonne chance!\n");
        vBox.getChildren().add(new Label(s.toString()));
        return vBox;
    }
}

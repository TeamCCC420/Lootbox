package Lootbox;

import Lootbox.lootbox_Code.general.Monde;
import Lootbox.lootbox_Code.outils.TailleComposants;
import Lootbox.lootbox_IG.vues.autresPages.VueJeu;
import Lootbox.lootbox_IG.vues.droite.VueArgent;
import Lootbox.lootbox_IG.vues.haut.VueMenuBar;
import Lootbox.lootbox_IG.vues.centre.VueMonde;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        TabPane centre = new TabPane();
        Tab box = new Tab("                    Gagnez de la nourriture avec notre Lootbox !                         ");
        box.setClosable(false);
        box.setStyle("-fx-background-color: #ccffcc; -fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #ffffff;");
        Tab jeu = new Tab("                    Jouez et gagnez des coins au jeu des cartes !                     ");
        jeu.setClosable(false);
        jeu.setStyle("-fx-background-color: #ffffcc; -fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #ffffff;");
        centre.getTabs().addAll(box,jeu);
        String style = this.getClass().getResource("ressources/css/style.css").toExternalForm();
        Monde m = new Monde();
        Label l = new Label(m.toString());
        root.getStylesheets().addAll(style);
        box.setContent(new VueMonde(m));
        VueJeu vueJeu = new VueJeu(m);
        m.getVues().add(vueJeu);
        jeu.setContent(vueJeu);
        root.setCenter(centre);
        root.setTop(new VueMenuBar(m));
        VueArgent vueA = new VueArgent(m);
        m.getVues().add(vueA);
        root.setRight(vueA);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Système de lootbox : par PETIT Brian et DUCHESNE Leila");
        primaryStage.setScene(new Scene(root, (TailleComposants.getInstance().getLargeurEcran()-25), TailleComposants.getInstance().gethauteurEcran()));
        primaryStage.show();
        primaryStage.getIcons().add(new Image(Main.class.getResourceAsStream("/icones/iconeAppli.png")));
    }

    public static void main(String[] args) {
        launch(args);
    }

}

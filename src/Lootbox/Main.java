package Lootbox;

import Lootbox.lootbox_Code.general.Monde;
import Lootbox.lootbox_Code.outils.TailleComposants;
import Lootbox.lootbox_IG.vues.Vue;
import Lootbox.lootbox_IG.vues.VueMenuBar;
import Lootbox.lootbox_IG.vues.VueMonde;
import Lootbox.lootbox_IG.vues.VueOuverture;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        primaryStage.setTitle("Système de lootbox : par PETIT Brian et DUCHESNE Leila");
        primaryStage.setScene(new Scene(root, TailleComposants.getInstance().getLargeurEcran(), TailleComposants.getInstance().gethauteurEcran()));
        primaryStage.show();
        Monde m = new Monde();
        Label l = new Label(m.toString());
        root.getChildren().add(l);
        root.setCenter(new VueMonde(m));
        root.setTop(new VueMenuBar(m));
    }


    public static void main(String[] args) {
        launch(args);
    }
}

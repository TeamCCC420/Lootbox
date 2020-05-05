package Lootbox;

import Lootbox.lootbox_Code.general.Monde;
import Lootbox.lootbox_IG.vues.Vue;
import Lootbox.lootbox_IG.vues.VueOuverture;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        HBox root = new HBox();
        primaryStage.setTitle("Système de lootbox : ");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        Monde m = new Monde();
        Label l = new Label(m.toString());
        root.getChildren().add(l);
        VBox vbox = new VBox();
        VBox vbox2 = new VBox();
        for(int i=0; i<3;i++){
            vbox.getChildren().add((Node) m.getVues().get(i));
        }
        for(int i=3; i<6;i++){
            vbox2.getChildren().add((Node) m.getVues().get(i));
        }
        vbox.setSpacing(140);
        vbox2.setSpacing(80);
        root.setSpacing(50);
        root.getChildren().addAll(vbox,vbox2);
    }


    public static void main(String[] args) {
        launch(args);
    }
}

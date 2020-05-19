package Lootbox.lootbox_IG.ecouteurs;

import Lootbox.Main;
import Lootbox.lootbox_Code.boite.Boite;
import Lootbox.lootbox_Code.general.Monde;
import Lootbox.lootbox_Code.outils.TailleComposants;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class EcouteurInventaire implements EventHandler<ActionEvent> {

    private Monde m;

    public EcouteurInventaire(Monde m) {
        this.m = m;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        TabPane tabPane = new TabPane();
        Tab commun = new Tab("Commun");
        commun.setStyle("-fx-background-color: green; -fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #ffffff;");
        Tab moyen = new Tab("Moyen");
        moyen.setStyle("-fx-background-color: yellow; -fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #000000;");
        Tab rare = new Tab("Rare");
        rare.setStyle("-fx-background-color: red; -fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #ffffff;");
        Tab epic = new Tab("Epic");
        epic.setStyle("-fx-background-color: blue; -fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #ffffff;");
        Tab legendaire = new Tab("Legendaire");
        legendaire.setStyle("-fx-background-color: purple; -fx-font-size: 12px; -fx-font-weight: bold; -fx-text-fill: #ffffff;");
        tabPane.getTabs().addAll(commun,moyen,rare,epic,legendaire);
        FlowPane f1 = new FlowPane();
        FlowPane f2 = new FlowPane();
        FlowPane f3 = new FlowPane();
        FlowPane f4 = new FlowPane();
        FlowPane f5 = new FlowPane();
        f1.setAlignment(Pos.CENTER);
        f1.setVgap(20);
        f1.setHgap(20);
        f1.setPrefWidth(TailleComposants.getInstance().getLargeurEcran()/1.6);
        f2.setAlignment(Pos.CENTER);
        f2.setVgap(20);
        f2.setHgap(20);
        f2.setPrefWidth(TailleComposants.getInstance().getLargeurEcran()/1.6);
        f3.setAlignment(Pos.CENTER);
        f3.setVgap(20);
        f3.setHgap(20);
        f3.setPrefWidth(TailleComposants.getInstance().getLargeurEcran()/1.6);
        f4.setAlignment(Pos.CENTER);
        f4.setVgap(20);
        f4.setHgap(20);
        f4.setPrefWidth(TailleComposants.getInstance().getLargeurEcran()/1.6);
        f5.setAlignment(Pos.CENTER);
        f5.setVgap(20);
        f5.setHgap(20);
        f5.setPrefWidth(TailleComposants.getInstance().getLargeurEcran()/1.6);
        ScrollPane s1 = new ScrollPane();
        s1.setContent(f1);
        s1.setStyle("-fx-background-color: #ffffff; -fx-border-color: green; -fx-border-insets: 5; -fx-border-width: 3; -fx-border-style: dashed;");
        ScrollPane s2 = new ScrollPane();
        s2.setContent(f2);
        s2.setStyle("-fx-background-color: #ffffff; -fx-border-color: yellow; -fx-border-insets: 5; -fx-border-width: 3; -fx-border-style: dashed;");
        ScrollPane s3 = new ScrollPane();
        s3.setContent(f3);
        s3.setStyle("-fx-background-color: #ffffff; -fx-border-color: red; -fx-border-insets: 5; -fx-border-width: 3; -fx-border-style: dashed;");
        ScrollPane s4 = new ScrollPane();
        s4.setContent(f4);
        s4.setStyle("-fx-background-color: #ffffff; -fx-border-color: blue; -fx-border-insets: 5; -fx-border-width: 3; -fx-border-style: dashed;");
        ScrollPane s5 = new ScrollPane();
        s5.setContent(f5);
        s5.setStyle("-fx-background-color: #ffffff; -fx-border-color: purple; -fx-border-insets: 5; -fx-border-width: 3; -fx-border-style: dashed;");
        commun.setContent(s1);
        moyen.setContent(s2);
        rare.setContent(s3);
        epic.setContent(s4);
        legendaire.setContent(s5);
        ImageView image;
        for(int i=0; i<m.getInv().getInventaire().size(); i++){
            System.out.println(m.getInv().getInventaire().get(i));
            image = new ImageView(m.getInv().getInventaire().get(i));
            switch(m.getInv().getType().get(i)) {
                case "Commun":
                    f1.getChildren().add(module(image,m.getInv().getInventaire().get(i)));
                    break;
                case "Moyen":
                    f2.getChildren().add(module(image,m.getInv().getInventaire().get(i)));
                    break;
                case "Rare":
                    f3.getChildren().add(module(image,m.getInv().getInventaire().get(i)));
                    break;
                case "Epic":
                    f4.getChildren().add(module(image,m.getInv().getInventaire().get(i)));
                    break;
                case "Legendaire":
                    f5.getChildren().add(module(image,m.getInv().getInventaire().get(i)));
                    break;
            }
        }
        Stage dialogStage = new Stage();
        dialogStage.setScene(new Scene(tabPane, TailleComposants.getInstance().getLargeurEcran()/1.5, TailleComposants.getInstance().gethauteurEcran()/1.5));
        dialogStage.setTitle("Inventaire : par PETIT Brian et DUCHESNE Leila");
        dialogStage.show();
        dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/icones/iconeAppli.png")));
        m.update();
    }

    public VBox module(ImageView imageView,String url){
        VBox v = new VBox();
        Button button = new Button("Telecharger");
        button.setOnAction(new EcouteurTelecharger(m,url));
        v.setSpacing(5);
        v.setAlignment(Pos.CENTER);
        v.getChildren().addAll(imageView,button);
        return v;
    }
}

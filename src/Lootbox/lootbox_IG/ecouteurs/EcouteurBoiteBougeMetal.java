package Lootbox.lootbox_IG.ecouteurs;

import Lootbox.Main;
import Lootbox.lootbox_Code.boite.Boite;
import Lootbox.lootbox_Code.general.Monde;
import Lootbox.lootbox_Code.outils.TailleComposants;
import javafx.animation.Interpolator;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class EcouteurBoiteBougeMetal implements EventHandler<MouseEvent> {

    private Monde m;
    private Boite b;
    private int iteration;

    public EcouteurBoiteBougeMetal(Monde m, Boite b, int i) {
        this.m = m;
        this.b = b;
        this.iteration = i;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (b.getPrixMonnaie() <= m.getPf().getMonnaie()) {
            Pane pane = new Pane();
            ImageView couvercle = new ImageView("/imagesBoite/boitemetal2.png");
            ImageView plateau = new ImageView("/imagesBoite/boitemetal3.png");
            couvercle.relocate(TailleComposants.getInstance().getLargeurEcran()/1.2 -769,-50);
            plateau.relocate(TailleComposants.getInstance().getLargeurEcran()/1.2 -770,TailleComposants.getInstance().gethauteurEcran()/1.2 -50);
            Stage dialogStage = new Stage();
            dialogStage.getIcons().add(new Image(Main.class.getResourceAsStream("/icones/iconeAppli.png")));
            dialogStage.setScene(new Scene(pane, TailleComposants.getInstance().getLargeurEcran()/1.2, TailleComposants.getInstance().gethauteurEcran()/1.2));
            dialogStage.setTitle("Gains");
            dialogStage.show();
            dialogStage.setResizable(false);
            for (int i = 0; i < iteration; i++) {
                b.gift();
            }
            String url = new String("fond/salade.png");
            pane.setStyle("-fx-background-image: url(" + url + "); -fx-background-size: "+ TailleComposants.getInstance().getLargeurEcran()/1.2+" "+ TailleComposants.getInstance().gethauteurEcran()/1.2 +";");
            Button b1 = new Button("Trop bien !");
            b1.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    dialogStage.close();
                }
            });
            pane.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    dialogStage.close();
                }
            });
            ImageView i;
            i = new ImageView(aleaGift());
            Label type = new Label(b.getGain());
            switch(b.getGain()){
                case "Commun":
                    type.setTextFill(Paint.valueOf("#00DD00"));
                    break;
                case "Moyen":
                    type.setTextFill(Paint.valueOf("#DDDD00"));
                    break;
                case "Rare":
                    type.setTextFill(Paint.valueOf("#DD0000"));
                    break;
                case "Epic":
                    type.setTextFill(Paint.valueOf("#0000DD"));
                    break;
                case "Legendaire":
                    type.setTextFill(Paint.valueOf("#DD00DD"));
                    break;
            }
            Label l = new Label("TU AS GAGNE UNE ICONE DE NOURRITURE !");
            m.getPf().depenseMonnaie(b.getPrixMonnaie());
            VBox vBox = new VBox();
            vBox.setAlignment(Pos.CENTER);
            vBox.setSpacing(5);
            vBox.setPadding(new Insets(20));
            vBox.getChildren().addAll(b1,l,type,i);
            vBox.relocate(280,330);
            vBox.setStyle("-fx-background-color: white; -fx-border-color: gray; -fx-border-insets: 5; -fx-border-width: 3; -fx-border-style: dashed;");
            pane.getChildren().addAll(plateau,vBox,couvercle);
            final TranslateTransition translateAnimation = new TranslateTransition(Duration.seconds(1), couvercle);
            translateAnimation.setCycleCount(1);
            translateAnimation.setAutoReverse(true);
            translateAnimation.setByY(-250);
            translateAnimation.setInterpolator(Interpolator.LINEAR);
            translateAnimation.play();
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Avez vous pensez à convertir votre argent ?");
            a.setContentText("Vous n'avez pas assez de monnaie virtuelle pour acheter cette \nbox, n'hésitez pas à redéposer de l'argent et à le convertir.");
            a.show();
        }
        m.update();
    }

    private String aleaGift() {
        int max=0, alea=0;
        Random rand = new Random();
        String s = new String();
        switch(b.getGain()){
            case "Commun":
                max=m.getGi().getCommun().length;
                alea = rand.nextInt(max);
                s = m.getGi().getCommun()[alea];
                break;
            case "Moyen":
                max=m.getGi().getMoyen().length;
                alea = rand.nextInt(max);
                s = m.getGi().getMoyen()[alea];
                break;
            case "Rare":
                max=m.getGi().getRare().length;
                alea = rand.nextInt(max);
                s = m.getGi().getRare()[alea];
                break;
            case "Epic":
                max=m.getGi().getEpic().length;
                alea = rand.nextInt(max);
                s = m.getGi().getEpic()[alea];
                break;
            case "Legendaire":
                max=m.getGi().getLegendaire().length;
                alea = rand.nextInt(max);
                s = m.getGi().getLegendaire()[alea];
                break;
        }
        m.getInv().ajout(s,b.getGain());
        return s;
    }
}

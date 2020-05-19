package Lootbox.lootbox_IG.vues.droite;

import Lootbox.lootbox_Code.general.Monde;
import Lootbox.lootbox_Code.general.PorteFeuille;
import Lootbox.lootbox_Code.outils.TailleComposants;
import Lootbox.lootbox_IG.ecouteurs.EcouteurBoutonAjouterArgent;
import Lootbox.lootbox_IG.ecouteurs.EcouteurConvertir;
import Lootbox.lootbox_IG.ecouteurs.EcouteurInventaire;
import Lootbox.lootbox_IG.ecouteurs.jeu.EcouteurJeuGeneral;
import Lootbox.lootbox_IG.vues.Vue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;

public class VueArgent extends VBox implements Vue {

    private Monde m;
    private Label argent;
    private Label monnaie;
    private Label depense;

    public VueArgent(Monde m){
        super();
        this.m = m;
        this.setId("Label");
        VBox vboxA = new VBox();
        VBox vboxB = new VBox();
        argent = new Label(stringArgent());
        Button bA = new Button("Ajouter \n de l'argent");
        bA.setId("Argent");
        monnaie = new Label("Coin : " + m.getPf().getMonnaie());
        Button bC = new Button("Convertir \n en monnaie");
        Button bI = new Button("Accéder à \n l'inventaire");
        bC.setId("Convertir");
        bI.setId("Inventaire");
        vboxA.getChildren().addAll(argent,bA);
        vboxA.setSpacing(20);
        vboxA.setAlignment(Pos.CENTER);
        vboxB.getChildren().addAll(monnaie,bC);
        vboxB.setSpacing(20);
        vboxB.setAlignment(Pos.CENTER);
        depense = new Label(stringDepense());
        super.getChildren().addAll(depense,vboxA,vboxB, bI);
        super.setAlignment(Pos.CENTER);
        super.setSpacing(40);
        super.setStyle("-fx-background-color: #D9D9D9; -fx-border-color: black; -fx-border-insets: 5; -fx-border-width: 3; -fx-border-style: dashed;");
        super.setPadding(new Insets(10));
        bA.setOnAction(new EcouteurBoutonAjouterArgent(m));
        bC.setOnAction(new EcouteurConvertir(m));
        bI.setOnAction(new EcouteurInventaire(m));
    }

    private String stringArgent() {
        String sA = new String("Argent : ");
        int arg = m.getPf().getArgent();
        int euro = 0, centime = 0;
        euro = arg/100;
        centime = arg%100;
        sA += euro + ",";
        sA += centime;
        sA += "$";
        return sA;
    }

    private String stringDepense() {
        String sA = new String("Total des \ndépenses : ");
        int arg = m.getPf().getTotalArgent();
        int euro = 0, centime = 0;
        euro = arg/100;
        centime = arg%100;
        sA += euro + ",";
        sA += centime;
        sA += "$";
        return sA;
    }

    @Override
    public void notif() {
        depense.setText(stringDepense());
        monnaie.setText("Coin : " + m.getPf().getMonnaie());
        argent.setText(stringArgent());
    }
}

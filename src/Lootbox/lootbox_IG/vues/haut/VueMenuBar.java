package Lootbox.lootbox_IG.vues.haut;

import Lootbox.lootbox_Code.general.Monde;
import Lootbox.lootbox_Code.outils.TailleComposants;
import Lootbox.lootbox_IG.ecouteurs.*;
import Lootbox.lootbox_IG.vues.Vue;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;

public class VueMenuBar extends MenuBar implements Vue {
    private Monde m;

    public VueMenuBar(Monde m){
        super();
        this.m = m;
        //this.setStyle("-fx-border-color: #0F0F0F; -fx-border-width: 2pt; -fx-background-color: #666666;");

        Menu fichier = new Menu("Fichier");
        setMenu(fichier, "icones/fichierIcon.png");
        MenuItem quitter = new MenuItem("Quitter");
        setMenu(quitter, "icones/quitterIcon.jpg");
        fichier.getItems().addAll(quitter);

        Menu rens = new Menu("Renseignements");
        setMenu(rens, "icones/standardIcon.png");
        MenuItem rens0 = new MenuItem("Comment ça marche ?");
        setMenu(rens0, "icones/standardIcon.png");
        MenuItem rens1 = new MenuItem("Compte - Rendu");
        setMenu(rens1, "icones/standardIcon.png");
        rens.getItems().addAll(rens0,rens1);

        super.getMenus().addAll(fichier,rens);

        quitter.setOnAction(new EcouteurMenuQuitter());
        rens1.setOnAction(new EcouteurRenseignements(m));
        rens0.setOnAction(new EcouteurCCM());
    }

    @Override
    public void notif() {

    }

    private void setMenu(MenuItem mi, String image){
        ImageView View = new ImageView(image);
        //mi.setStyle("-fx-border-color: #0F0F0F; -fx-border-width: 2pt;-fx-background-color: #FFFFFF;");
        View.setFitWidth(TailleComposants.getInstance().tailleIcon());
        View.setFitHeight(TailleComposants.getInstance().tailleIcon());
        mi.setGraphic(View);
    }
}

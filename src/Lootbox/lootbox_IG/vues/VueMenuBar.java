package Lootbox.lootbox_IG.vues;

import Lootbox.lootbox_Code.general.Monde;
import Lootbox.lootbox_Code.outils.TailleComposants;
import Lootbox.lootbox_IG.ecouteurs.EcouteurMenuQuitter;
import Lootbox.lootbox_IG.ecouteurs.EcouteurMenuResetAll;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;

public class VueMenuBar extends MenuBar implements Vue {
    private Monde m;

    public VueMenuBar(Monde m){
        super();
        this.m = m;
        this.setStyle("-fx-border-color: #0F0F0F; -fx-border-width: 2pt; -fx-background-color: #666666;");

        Menu fichier = new Menu("Fichier");
        fichier.setStyle("-fx-border-color: #0F0F0F; -fx-border-width: 2pt;-fx-background-color: #FFFFFF;");
        setMenu(fichier, "icones/fichierIcon.png");
        MenuItem reset = new MenuItem("Nouveau");
        setMenu(reset, "icones/nouveauIcon.png");
        MenuItem quitter = new MenuItem("Quitter");
        setMenu(quitter, "icones/quitterIcon.jpg");
        fichier.getItems().addAll(reset,quitter);

        super.getMenus().add(fichier);

        quitter.setOnAction(new EcouteurMenuQuitter());
        reset.setOnAction(new EcouteurMenuResetAll(this.m));
    }

    @Override
    public void notif() {

    }

    private void setMenu(MenuItem mi, String image){
        ImageView View = new ImageView(image);
        View.setFitWidth(TailleComposants.getInstance().tailleIcon());
        View.setFitHeight(TailleComposants.getInstance().tailleIcon());
        mi.setGraphic(View);
    }
}

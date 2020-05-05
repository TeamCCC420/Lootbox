package Lootbox.lootbox_IG.vues;

import Lootbox.lootbox_Code.boite.Boite;
import Lootbox.lootbox_Code.general.Monde;
import Lootbox.lootbox_IG.ecouteurs.EcouteurOuvrir;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;


public class VueOuverture extends HBox implements Vue{

    private Monde m;
    private Boite b;
    private Label l;

    public VueOuverture(Monde m, Boite boite){
        super();
        this.m = m;
        this.b = boite;
        Button button = new Button("Ouvrir");
        button.setOnAction(new EcouteurOuvrir(m,boite,1));
        Button button2 = new Button("Ouvrir 10000 fois");
        button2.setOnAction(new EcouteurOuvrir(m,boite,10000));
        l = new Label();
        l.setText(b.getGain());
        super.setSpacing(20);
        super.getChildren().addAll(button, button2, l);
    }

    @Override
    public void notif() {
        l.setText(b.getGain());
    }
}

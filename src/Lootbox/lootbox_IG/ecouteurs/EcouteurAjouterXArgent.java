package Lootbox.lootbox_IG.ecouteurs;

import Lootbox.lootbox_Code.general.Monde;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;

public class EcouteurAjouterXArgent implements EventHandler<ActionEvent> {

    private Monde m;
    private int prix;

    public EcouteurAjouterXArgent(Monde m, int prix) {
        this.m = m;
        this.prix = prix;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        m.getPf().remplissageArgent(prix);
        System.out.println(m.getPf().getArgent());
        m.update();
    }
}

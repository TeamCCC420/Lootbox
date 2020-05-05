package Lootbox.lootbox_IG.ecouteurs;

import Lootbox.lootbox_Code.boite.Boite;
import Lootbox.lootbox_Code.general.Monde;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EcouteurOuvrir implements EventHandler<ActionEvent> {

    private Monde m;
    private Boite b;
    private int iteration;

    public EcouteurOuvrir(Monde m, Boite b, int i) {
        this.m = m;
        this.b = b;
        this.iteration = i;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        for(int i=0; i<iteration;i++) {
            b.gift();
        }
        m.update();
    }
}

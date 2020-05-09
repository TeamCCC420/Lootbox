package Lootbox.lootbox_IG.ecouteurs;

import Lootbox.lootbox_Code.general.Monde;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class EcouteurMenuResetAll implements EventHandler<ActionEvent> {

    private Monde monde;

    public EcouteurMenuResetAll(Monde monde){
        this.monde = monde;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        monde.reset();
    }
}

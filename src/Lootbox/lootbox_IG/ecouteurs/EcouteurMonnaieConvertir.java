package Lootbox.lootbox_IG.ecouteurs;

import Lootbox.lootbox_Code.general.Monde;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

public class EcouteurMonnaieConvertir implements EventHandler<ActionEvent> {

    private Monde m;
    private int prix;

    public EcouteurMonnaieConvertir(Monde m, int prix) {
        this.m = m;
        this.prix = prix;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(m.getPf().getArgent() - prix*100 >= 0 ){
            m.getPf().remplissageMonnaie(prix);
        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Oh non, vous n'avez pas assez ?");
            a.setContentText("Vous n'avez pas assez d'argent déposé pour transformer cela en coins \n,n'hésitez pas à redéposer de l'argent pour pouvoir le convertir");
            a.showAndWait();
        }
        m.update();
    }
}

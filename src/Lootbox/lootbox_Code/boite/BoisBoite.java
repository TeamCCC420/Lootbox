package Lootbox.lootbox_Code.boite;

import Lootbox.lootbox_Code.outils.Probabilites;

public class BoisBoite extends Boite{

    public BoisBoite(){
        super(Probabilites.getInstance().probaCommun(),"Commun");
    }

    public String toString(){
        return super.toString();
    }

}
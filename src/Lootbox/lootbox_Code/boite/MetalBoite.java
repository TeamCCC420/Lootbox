package Lootbox.lootbox_Code.boite;

import Lootbox.lootbox_Code.outils.Probabilites;

public class MetalBoite extends Boite{

    public MetalBoite() {
        super(Probabilites.getInstance().probaRare(), "Rare");
    }

    public String toString(){
        return super.toString();
    }

}

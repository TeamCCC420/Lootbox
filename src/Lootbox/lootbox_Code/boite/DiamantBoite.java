package Lootbox.lootbox_Code.boite;

import Lootbox.lootbox_Code.outils.Probabilites;

public class DiamantBoite extends Boite{

    public DiamantBoite() {
        super(Probabilites.getInstance().probaLegendaire(), "Legendaire");
    }

    public String toString(){
        return super.toString();
    }
}

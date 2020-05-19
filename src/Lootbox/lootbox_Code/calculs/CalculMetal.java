package Lootbox.lootbox_Code.calculs;

import Lootbox.lootbox_Code.boite.Compteur;
import Lootbox.lootbox_Code.outils.ProbaDiamant;
import Lootbox.lootbox_Code.outils.ProbaMetal;
import Lootbox.lootbox_Code.outils.Probabilites;

import java.util.Random;

public class CalculMetal {

    private float[] normaleTest;
    private float[] normaleAttendu;
    private float moyenne;
    private float ecartType;
    private float variance;

    public CalculMetal(Compteur c) {
        normaleAttendu = new float[9];
        normaleTest = new float[9];
        moyenne = CalculProba.getInstance().moyenne(
                Probabilites.getInstance().probaRareMax(),
                new ValeurObject(c.getValeur("Commun"), ProbaMetal.getInstance().probaRareCommun()),
                new ValeurObject(c.getValeur("Moyen"),ProbaMetal.getInstance().probaRareMoyen()),
                new ValeurObject(c.getValeur("Rare"),ProbaMetal.getInstance().probaRareRare()),
                new ValeurObject(c.getValeur("Epic"),ProbaMetal.getInstance().probaRareEpic()),
                new ValeurObject(c.getValeur("Legendaire"),ProbaMetal.getInstance().probaRareLegendaire())
        );
        ecartType = CalculProba.getInstance().ecartType(
                Probabilites.getInstance().probaRareMax(),
                new ValeurObject(c.getValeur("Commun"), ProbaMetal.getInstance().probaRareCommun()),
                new ValeurObject(c.getValeur("Moyen"),ProbaMetal.getInstance().probaRareMoyen()),
                new ValeurObject(c.getValeur("Rare"),ProbaMetal.getInstance().probaRareRare()),
                new ValeurObject(c.getValeur("Epic"),ProbaMetal.getInstance().probaRareEpic()),
                new ValeurObject(c.getValeur("Legendaire"),ProbaMetal.getInstance().probaRareLegendaire())
        );
        variance = CalculProba.getInstance().variance(
                Probabilites.getInstance().probaRareMax(),
                new ValeurObject(c.getValeur("Commun"), ProbaMetal.getInstance().probaRareCommun()),
                new ValeurObject(c.getValeur("Moyen"),ProbaMetal.getInstance().probaRareMoyen()),
                new ValeurObject(c.getValeur("Rare"),ProbaMetal.getInstance().probaRareRare()),
                new ValeurObject(c.getValeur("Epic"),ProbaMetal.getInstance().probaRareEpic()),
                new ValeurObject(c.getValeur("Legendaire"),ProbaMetal.getInstance().probaRareLegendaire())
        );
        normaleAttendu = CalculProba.getInstance().normale(
                Probabilites.getInstance().probaRareMax(),
                9
                ,
                new ValeurObject(ProbaMetal.getInstance().probaRareCommun(), ProbaMetal.getInstance().probaRareCommun()),
                new ValeurObject(ProbaMetal.getInstance().probaRareMoyen(), ProbaMetal.getInstance().probaRareMoyen()),
                new ValeurObject(ProbaMetal.getInstance().probaRareRare(), ProbaMetal.getInstance().probaRareRare()),
                new ValeurObject(ProbaMetal.getInstance().probaRareEpic(), ProbaMetal.getInstance().probaRareEpic()),
                new ValeurObject(ProbaMetal.getInstance().probaRareLegendaire(), ProbaMetal.getInstance().probaRareLegendaire())
        );
        normaleTest = CalculProba.getInstance().normale(
                Probabilites.getInstance().probaRareMax(),
                9,
                new ValeurObject(c.getValeur("Commun"), ProbaMetal.getInstance().probaRareCommun()),
                new ValeurObject(c.getValeur("Moyen"),ProbaMetal.getInstance().probaRareMoyen()),
                new ValeurObject(c.getValeur("Rare"),ProbaMetal.getInstance().probaRareRare()),
                new ValeurObject(c.getValeur("Epic"),ProbaMetal.getInstance().probaRareEpic()),
                new ValeurObject(c.getValeur("Legendaire"),ProbaMetal.getInstance().probaRareLegendaire())
        );
    }


    public float[] getNormaleTest() {
        return normaleTest;
    }

    public void setNormaleTest(float[] normaleTest) {
        this.normaleTest = normaleTest;
    }

    public float[] getNormaleAttendu() {
        return normaleAttendu;
    }

    public void setNormaleAttendu(float[] normaleAttendu) {
        this.normaleAttendu = normaleAttendu;
    }

    public float getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(float moyenne) {
        this.moyenne = moyenne;
    }

    public float getEcartType() {
        return ecartType;
    }

    public void setEcartType(float ecartType) {
        this.ecartType = ecartType;
    }

    public float getVariance() {
        return variance;
    }

    public void setVariance(float variance) {
        this.variance = variance;
    }

}

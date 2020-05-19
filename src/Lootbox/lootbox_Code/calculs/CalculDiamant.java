package Lootbox.lootbox_Code.calculs;

import Lootbox.lootbox_Code.boite.Compteur;
import Lootbox.lootbox_Code.outils.ProbaBois;
import Lootbox.lootbox_Code.outils.ProbaDiamant;
import Lootbox.lootbox_Code.outils.Probabilites;

import java.util.Random;

public class CalculDiamant {

    private float[] normaleTest;
    private float[] normaleAttendu;
    private float moyenne;
    private float ecartType;
    private float variance;

    public CalculDiamant(Compteur c) {
        normaleAttendu = new float[9];
        normaleTest = new float[9];
        moyenne = CalculProba.getInstance().moyenne(
                Probabilites.getInstance().probaLegendaireMax(),
                new ValeurObject(c.getValeur("Commun"), ProbaDiamant.getInstance().probaLegendaireCommun()),
                new ValeurObject(c.getValeur("Moyen"),ProbaDiamant.getInstance().probaLegendaireMoyen()),
                new ValeurObject(c.getValeur("Rare"),ProbaDiamant.getInstance().probaLegendaireRare()),
                new ValeurObject(c.getValeur("Epic"),ProbaDiamant.getInstance().probaLegendaireEpic()),
                new ValeurObject(c.getValeur("Legendaire"),ProbaDiamant.getInstance().probaLegendaireLegendaire())
        );
        ecartType = CalculProba.getInstance().ecartType(
                Probabilites.getInstance().probaLegendaireMax(),
                new ValeurObject(c.getValeur("Commun"), ProbaDiamant.getInstance().probaLegendaireCommun()),
                new ValeurObject(c.getValeur("Moyen"),ProbaDiamant.getInstance().probaLegendaireMoyen()),
                new ValeurObject(c.getValeur("Rare"),ProbaDiamant.getInstance().probaLegendaireRare()),
                new ValeurObject(c.getValeur("Epic"),ProbaDiamant.getInstance().probaLegendaireEpic()),
                new ValeurObject(c.getValeur("Legendaire"),ProbaDiamant.getInstance().probaLegendaireLegendaire())
        );
        variance = CalculProba.getInstance().variance(
                Probabilites.getInstance().probaLegendaireMax(),
                new ValeurObject(c.getValeur("Commun"), ProbaDiamant.getInstance().probaLegendaireCommun()),
                new ValeurObject(c.getValeur("Moyen"),ProbaDiamant.getInstance().probaLegendaireMoyen()),
                new ValeurObject(c.getValeur("Rare"),ProbaDiamant.getInstance().probaLegendaireRare()),
                new ValeurObject(c.getValeur("Epic"),ProbaDiamant.getInstance().probaLegendaireEpic()),
                new ValeurObject(c.getValeur("Legendaire"),ProbaDiamant.getInstance().probaLegendaireLegendaire())
        );
        normaleAttendu = CalculProba.getInstance().normale(
                Probabilites.getInstance().probaLegendaireMax(),
                9,
                new ValeurObject(ProbaDiamant.getInstance().probaLegendaireCommun(), ProbaDiamant.getInstance().probaLegendaireCommun()),
                new ValeurObject(ProbaDiamant.getInstance().probaLegendaireMoyen(), ProbaDiamant.getInstance().probaLegendaireMoyen()),
                new ValeurObject(ProbaDiamant.getInstance().probaLegendaireRare(), ProbaDiamant.getInstance().probaLegendaireRare()),
                new ValeurObject(ProbaDiamant.getInstance().probaLegendaireEpic(), ProbaDiamant.getInstance().probaLegendaireEpic()),
                new ValeurObject(ProbaDiamant.getInstance().probaLegendaireLegendaire(), ProbaDiamant.getInstance().probaLegendaireLegendaire())
        );
        normaleTest = CalculProba.getInstance().normale(
                Probabilites.getInstance().probaLegendaireMax(),
                9,
                new ValeurObject(c.getValeur("Commun"), ProbaDiamant.getInstance().probaLegendaireCommun()),
                new ValeurObject(c.getValeur("Moyen"),ProbaDiamant.getInstance().probaLegendaireMoyen()),
                new ValeurObject(c.getValeur("Rare"),ProbaDiamant.getInstance().probaLegendaireRare()),
                new ValeurObject(c.getValeur("Epic"),ProbaDiamant.getInstance().probaLegendaireEpic()),
                new ValeurObject(c.getValeur("Legendaire"),ProbaDiamant.getInstance().probaLegendaireLegendaire())
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
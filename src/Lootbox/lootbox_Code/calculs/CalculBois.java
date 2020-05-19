package Lootbox.lootbox_Code.calculs;

import Lootbox.lootbox_Code.boite.Compteur;
import Lootbox.lootbox_Code.outils.ProbaBois;
import Lootbox.lootbox_Code.outils.Probabilites;

import java.util.Random;

public class CalculBois {

    private float[] normaleTest;
    private float[] normaleAttendu;
    private float moyenne;
    private float ecartType;
    private float variance;

    public CalculBois(Compteur c){
        normaleAttendu = new float[9];
        normaleTest = new float[9];
        moyenne = CalculProba.getInstance().moyenne(
                Probabilites.getInstance().probaCommunMax(),
                new ValeurObject(c.getValeur("Commun"),ProbaBois.getInstance().probaCommunCommun()),
                new ValeurObject(c.getValeur("Moyen"),ProbaBois.getInstance().probaCommunMoyen()),
                new ValeurObject(c.getValeur("Rare"),ProbaBois.getInstance().probaCommunRare()),
                new ValeurObject(c.getValeur("Epic"),ProbaBois.getInstance().probaCommunEpic()),
                new ValeurObject(c.getValeur("Legendaire"),ProbaBois.getInstance().probaCommunLegendaire())
        );
        ecartType = CalculProba.getInstance().ecartType(
                Probabilites.getInstance().probaCommunMax(),
                new ValeurObject(c.getValeur("Commun"),ProbaBois.getInstance().probaCommunCommun()),
                new ValeurObject(c.getValeur("Moyen"),ProbaBois.getInstance().probaCommunMoyen()),
                new ValeurObject(c.getValeur("Rare"),ProbaBois.getInstance().probaCommunRare()),
                new ValeurObject(c.getValeur("Epic"),ProbaBois.getInstance().probaCommunEpic()),
                new ValeurObject(c.getValeur("Legendaire"),ProbaBois.getInstance().probaCommunLegendaire())
        );
        variance = CalculProba.getInstance().variance(
                Probabilites.getInstance().probaCommunMax(),
                new ValeurObject(c.getValeur("Commun"),ProbaBois.getInstance().probaCommunCommun()),
                new ValeurObject(c.getValeur("Moyen"),ProbaBois.getInstance().probaCommunMoyen()),
                new ValeurObject(c.getValeur("Rare"),ProbaBois.getInstance().probaCommunRare()),
                new ValeurObject(c.getValeur("Epic"),ProbaBois.getInstance().probaCommunEpic()),
                new ValeurObject(c.getValeur("Legendaire"),ProbaBois.getInstance().probaCommunLegendaire())
        );
        normaleAttendu = CalculProba.getInstance().normale(
                Probabilites.getInstance().probaCommunMax(),
                9,
                new ValeurObject(ProbaBois.getInstance().probaCommunCommun(),ProbaBois.getInstance().probaCommunCommun()),
                new ValeurObject(ProbaBois.getInstance().probaCommunMoyen(),ProbaBois.getInstance().probaCommunMoyen()),
                new ValeurObject(ProbaBois.getInstance().probaCommunRare(),ProbaBois.getInstance().probaCommunRare()),
                new ValeurObject(ProbaBois.getInstance().probaCommunEpic(),ProbaBois.getInstance().probaCommunEpic()),
                new ValeurObject(ProbaBois.getInstance().probaCommunLegendaire(),ProbaBois.getInstance().probaCommunLegendaire())
        );
        normaleTest = CalculProba.getInstance().normale(
                Probabilites.getInstance().probaCommunMax(),
                9,
                new ValeurObject(c.getValeur("Commun"),ProbaBois.getInstance().probaCommunCommun()),
                new ValeurObject(c.getValeur("Moyen"),ProbaBois.getInstance().probaCommunMoyen()),
                new ValeurObject(c.getValeur("Rare"),ProbaBois.getInstance().probaCommunRare()),
                new ValeurObject(c.getValeur("Epic"),ProbaBois.getInstance().probaCommunEpic()),
                new ValeurObject(c.getValeur("Legendaire"),ProbaBois.getInstance().probaCommunLegendaire())
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

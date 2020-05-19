package Lootbox.lootbox_Code.calculs;

public class ValeurObject {

    private int nbfois;
    private float valeur;

    public ValeurObject(int nbfois, float valeur){
        this.nbfois = nbfois;
        this.valeur = valeur;
    }

    public int getNbfois() {
        return nbfois;
    }

    public void setNbfois(int nbfois) {
        this.nbfois = nbfois;
    }

    public float getValeur() {
        return valeur;
    }

    public void setValeur(float valeur) {
        this.valeur = valeur;
    }
}

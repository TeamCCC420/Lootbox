package Lootbox.lootbox_Code.boite;

import Lootbox.lootbox_Code.outils.Prix;
import Lootbox.lootbox_Code.outils.Probabilites;
import com.sun.jdi.event.StepEvent;

import java.sql.SQLOutput;
import java.util.Random;

public class Boite{

    private int[] proba;
    private int max;
    private String id;
    private String gain;
    private Compteur compt;
    private int prixMonnaie;

    public Boite(int[] proba, String lequel){
        switch(lequel){
            case "Commun":
                max = Probabilites.getInstance().probaCommunMax();
                prixMonnaie = Prix.getInstance().prixBoiteBois();
                break;
            case "Rare":
                max = Probabilites.getInstance().probaRareMax();
                prixMonnaie = Prix.getInstance().prixBoiteMetal();
                break;
            case "Legendaire":
                max = Probabilites.getInstance().probaLegendaireMax();
                prixMonnaie = Prix.getInstance().prixBoiteDiamant();
                break;
        }
        System.out.println(lequel + max);
        this.id = lequel;
        this.proba = new int[proba.length];
        for(int i=0; i<proba.length; i++){
            this.proba[i] = proba[i];
        }
        gain = "Vide";
        compt = new Compteur();
    }

    public Boite(){
        compt = new Compteur();
    }
    private int getGift(){
        Random random = new Random();
        int alea = random.nextInt(max);
        int flag = 0;
        for(int i=0; i<proba.length; i++){
            flag += proba[i];
            if(alea < flag){
                return i;
            }
        }
        return -1;
    }

    public void gift(){
        switch(getGift()){
            case 0:
                gain = "Commun";
                break;
            case 1:
                gain = "Moyen";
                break;
            case 2:
                gain = "Rare";
                break;
            case 3:
                gain = "Epic";
                break;
            case 4:
                gain = "Legendaire";
                break;
            default:
                gain = " --- Erreur !! --- ";
                break;
        }
        compt.update(gain);
    }

    public int[] getProba() {
        return proba;
    }

    public void setProba(int[] proba) {
        this.proba = proba;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGain() {
        return gain;
    }

    public void setCompt(Compteur c){
        compt = c;
    }

    public Compteur getCompt(){
        return compt;
    }

    public int getPrixMonnaie() {
        return prixMonnaie;
    }

    public String toString(){
        StringBuilder s = new StringBuilder(999);
        s.append("Boite : " + id + "\n");
        for(int i=0; i<proba.length; i++){
            s.append("\t\t Proba " + i + " : " + proba[i] + " --> " + proba[i]/100 + "," + proba[i]%100 +"%\n");
        }
        s.append("\t\t Maximun : "  + max + " --> " + max/100 + "," + max%100 +"%\n");
        return s.toString();
    }

    public void reset() {
        gain = "Vide";
        compt = new Compteur();
    }
}
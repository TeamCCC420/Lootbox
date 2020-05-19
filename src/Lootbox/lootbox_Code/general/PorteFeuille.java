package Lootbox.lootbox_Code.general;

import Lootbox.lootbox_Code.outils.ArgentVersMonnaie;

public class PorteFeuille {

    private int argent;
    private int monnaie;
    private int totalArgent;

    public PorteFeuille(){
        argent = 0;
        monnaie = 0;
        totalArgent = 0;
    }

    public void remplissageArgent(int euro){
        argent += euro*100;
        totalArgent += euro*100;
    }

    public void remplissageMonnaie(int euro){
        argent -= euro*100;
        switch(euro){
            case 1:
                monnaie += ArgentVersMonnaie.getInstance().get1to();
                break;
            case 2:
                monnaie += ArgentVersMonnaie.getInstance().get2to();
                break;
            case 5:
                monnaie += ArgentVersMonnaie.getInstance().get5to();
                break;
            case 10:
                monnaie += ArgentVersMonnaie.getInstance().get10to();
                break;
            case 50:
                monnaie += ArgentVersMonnaie.getInstance().get50to();
                break;
        }
    }

    public void depenseMonnaie(int monnaie){
        this.monnaie -= monnaie;
    }

    public int getMonnaie(){
        return monnaie;
    }

    public int getArgent(){
        return argent;
    }

    public int getTotalArgent(){
        return totalArgent;
    }

    public void gainJeu() {
        monnaie += 50;
    }
    public void perteJeu() {
        if(!(monnaie<10)){
            monnaie -= 10;
        }
    }
}

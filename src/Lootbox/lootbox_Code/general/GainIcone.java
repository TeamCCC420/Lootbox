package Lootbox.lootbox_Code.general;

import java.io.File;

public class GainIcone {

    private String[] commun;
    private String[] moyen;
    private String[] rare;
    private String[] epic;
    private String[] legendaire;

    public GainIcone(){
        construCommun();
        construMoyen();
        construRare();
        construEpic();
        construLegendaire();
    }

    private void construCommun() {
        commun = listeRepertoire("src/Lootbox/ressources/nourriture/commun","nourriture/commun/");
    }

    private void construMoyen() {
        moyen = listeRepertoire("src/Lootbox/ressources/nourriture/moyen","nourriture/moyen/");
    }

    private void construRare() {
       rare = listeRepertoire("src/Lootbox/ressources/nourriture/rare","nourriture/rare/");
    }

    private void construEpic() {
        epic = listeRepertoire("src/Lootbox/ressources/nourriture/epic","nourriture/epic/");
    }

    private void construLegendaire() {
        legendaire = listeRepertoire("src/Lootbox/ressources/nourriture/legendaire","nourriture/legendaire/");
    }

    private String[] listeRepertoire(String url, String urldebut){
        File repertoire = new File(url);
        String[] remplir = repertoire.list();
        if (remplir != null) {
            for (int i = 0; i < remplir.length; i++) {
                remplir[i] = urldebut + remplir[i];
            }
        } else {
            System.err.println("Nom de repertoire invalide");
        }
        return remplir;
    }

    public String[] getCommun() {
        return commun;
    }

    public String[] getMoyen() {
        return moyen;
    }

    public String[] getRare() {
        return rare;
    }

    public String[] getEpic() {
        return epic;
    }

    public String[] getLegendaire() {
        return legendaire;
    }

    public void reset() {
        construCommun();
        construMoyen();
        construRare();
        construEpic();
        construLegendaire();
    }
}

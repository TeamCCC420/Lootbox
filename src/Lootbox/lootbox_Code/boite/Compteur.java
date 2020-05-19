package Lootbox.lootbox_Code.boite;

import javax.xml.stream.events.Comment;
import java.util.HashMap;

public class Compteur {

    private HashMap<String, Integer> tab;

    public Compteur(){
        tab = new HashMap<>();
        tab.put("Commun", 0);
        tab.put("Moyen", 0);
        tab.put("Rare", 0);
        tab.put("Epic", 0);
        tab.put("Legendaire", 0);
    }

    public Compteur(int c, int m, int r, int e, int l){
        tab = new HashMap<>();
        tab.put("Commun", c);
        tab.put("Moyen", m);
        tab.put("Rare", r);
        tab.put("Epic", e);
        tab.put("Legendaire", l);
    }

    public void update(String code){
        tab.replace(code,(tab.get(code)+1));
    }

    public int getValeur(String s){
        return tab.get(s);
    }

    public String toString(){
        StringBuilder s = new StringBuilder(9999);
        s.append("Commun : " + this.getValeur("Commun") + "\n");
        s.append("Moyen : " + this.getValeur("Moyen") + "\n");
        s.append("Rare : " + this.getValeur("Rare") + "\n");
        s.append("Epic : " + this.getValeur("Epic") + "\n");
        s.append("Legendaire : " + this.getValeur("Legendaire") + "\n");
        return s.toString();
    }
}

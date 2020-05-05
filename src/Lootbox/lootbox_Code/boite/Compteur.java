package Lootbox.lootbox_Code.boite;

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

    public void update(String code){
        //System.out.println(code + " --> " + (tab.get(code)+1));
        tab.replace(code,(tab.get(code)+1));
    }

    public int getValeur(String s){
        return tab.get(s);
    }
}

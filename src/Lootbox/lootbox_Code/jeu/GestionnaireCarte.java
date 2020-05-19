package Lootbox.lootbox_Code.jeu;

import java.util.ArrayList;
import java.util.Random;

public class GestionnaireCarte {

    private ArrayList<Carte> cartes;

    public GestionnaireCarte(){
        Random rand = new Random();
        cartes = new ArrayList<Carte>(8);
        int alea = rand.nextInt(7);
        Carte carte;
        int ecart = 75;
        for(int i=0; i<8; i++){
            if(i<4){
                if(alea == i){
                    carte = new Carte(i*100+(i*ecart+100),100,true);
                }
                else {
                    carte = new Carte(i*100+(i*ecart+100),100, false);
                }
            }
            else{
                if(alea == i){
                    carte = new Carte((i-4)*100+((i-4)*ecart+100),300,true);
                }
                else {
                    carte = new Carte((i-4)*100+((i-4)*ecart+100),300, false);
                }
            }

            cartes.add(carte);
        }
    }

    public ArrayList<Carte> getCartes(){
        return cartes;
    }

    public void resetVictoire(){
        for(Carte c : cartes){
            c.setQui(false);
        }
        Random rand = new Random();
        int alea = rand.nextInt(7);
        cartes.get(alea).setQui(true);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("Gestionnaire Carte :\n");
        for(Carte c : cartes){
            s.append(c.toString());
        }
        return s.toString();
    }
}

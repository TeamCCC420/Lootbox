package Lootbox.lootbox_Code.jeu;

import javafx.scene.Scene;

public class Carte {

    private float x;
    private float y;
    private boolean qui; //true : correct; false : incorrect
    private String url;
    private boolean trouve; //false : carte toujours pas trouvé, true: carte trouvé

    public Carte(float x, float y, boolean qui){
        this.x = x;
        this.y = y;
        this.qui = qui;
        url = new String("/jeu/carteretourne.png");
        trouve = false;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public boolean isQui() {
        return qui;
    }

    public void setQui(boolean qui) {
        this.qui = qui;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String mess){
        url = mess;
    }

    public boolean getTrouve(){
        return trouve;
    }

    public void setTrouve(boolean trouve){
        this.trouve = trouve;
    }

    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("Carte : \n");
        s.append("\t x = "+getX()+"\n");
        s.append("\t y = "+getY()+"\n");
        s.append("\t la bonne ? : "+isQui()+"\n");
        return s.toString();
    }
}

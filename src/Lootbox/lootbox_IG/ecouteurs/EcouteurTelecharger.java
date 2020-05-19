package Lootbox.lootbox_IG.ecouteurs;

import Lootbox.lootbox_Code.general.Monde;
import Lootbox.lootbox_Code.outils.Semaphore;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.io.*;

public class EcouteurTelecharger implements EventHandler<ActionEvent> {

    private Monde m;
    private String url;

    public EcouteurTelecharger(Monde m,String url){
        this.m = m;
        this.url = url;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        InputStream in;
        OutputStream out=System.out;
        String s = new String(Semaphore.getInstance().getSema()+".jpg");
        int c=0;
        try
        {
            in = new FileInputStream("src/Lootbox/ressources/"+url);
            out = new FileOutputStream(s);
            while ((c=in.read())!=-1) out.write(c);
            in.close();
            out.close();
        }
        catch (IOException e)
        {
            System.out.println(e.toString());
        }
    }
}

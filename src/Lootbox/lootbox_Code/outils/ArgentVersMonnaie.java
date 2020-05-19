package Lootbox.lootbox_Code.outils;

public class ArgentVersMonnaie {

    private static ArgentVersMonnaie ourInstance = new ArgentVersMonnaie();

    /**
     * Auto-instance du singleton
     * @return rien, simplement l'instance
     */
    public static ArgentVersMonnaie getInstance(){
        return ourInstance;
    }

    public int get1to(){
        return 100;
    }

    public int get2to(){
        return 250;
    }

    public int get5to(){
        return 600;
    }

    public int get10to(){
        return 1500;
    }

    public int get50to(){
        return 9000;
    }
}

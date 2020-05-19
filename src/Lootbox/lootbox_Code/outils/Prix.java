package Lootbox.lootbox_Code.outils;

public class Prix {

    private static Prix ourInstance = new Prix();

    /**
     * Auto-instance du singleton
     * @return rien, simplement l'instance
     */
    public static Prix getInstance(){
        return ourInstance;
    }

    public int prixBoiteBois(){
        return 100;
    }

    public int prixBoiteMetal(){
        return 600;
    }

    public int prixBoiteDiamant(){
        return 1200;
    }
}

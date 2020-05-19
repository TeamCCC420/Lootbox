package Lootbox.lootbox_Code.outils;

/**
 * Singleton utilisé pour obtenir les informations sur la taille des éléments graphiques
 */
public class TailleComposants {

    private static TailleComposants ourInstance = new TailleComposants();

    /**
     * Auto-instance du singleton
     * @return rien, simplement l'instance
     */
    public static TailleComposants getInstance(){
        return ourInstance;
    }

    /**
     * Getter sur la largeur de l'écran de l'application
     * @return int Largeur de l'écran
     */
    public int getLargeurEcran(){
        return 1000;
    }

    /**
     * Getter sur la hauteur de l'écran de l'application
     * @return int Largeur de l'écran
     */
    public int gethauteurEcran(){
        return 750;
    }

    /**
     * Getter sur la taille des icones du menu
     * @return double Taille de l'icone
     */
    public double tailleIcon() {
        return 25;
    }

    /**
     * Getter sur la largeur des coffres de l'application
     * @return int Largeur de l'écran
     */
    public int getLargeurCoffre(){
        return 180;
    }

    /**
     * Getter sur la hauteur des coffres de l'application
     * @return int Largeur de l'écran
     */
    public int gethauteurCoffre(){
        return 180;
    }

}

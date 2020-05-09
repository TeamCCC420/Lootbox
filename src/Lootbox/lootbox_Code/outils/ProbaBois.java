package Lootbox.lootbox_Code.outils;

/**
 * Singleton s'occupant de retourner les 5 probabilités respectives des 5 événements d'une boite en bois
 */
public class ProbaBois {

    private static ProbaBois ourInstance = new ProbaBois();

    /**
     * Auto-instance du singleton
     * @return rien, simplement l'instance
     */
    public static ProbaBois getInstance(){
        return ourInstance;
    }

    /**
     * Fonction définissant la probabilité d'un evenement commun
     * @return int valeur de l'évènement
     */
    public int probaCommunCommun(){
        return 8000;
    }

    /**
     * Fonction définissant la probabilité d'un evenement moyen
     * @return int valeur de l'évènement
     */
    public int probaCommunMoyen(){
        return 1600;
    }

    /**
     * Fonction définissant la probabilité d'un evenement rare
     * @return int valeur de l'évènement
     */
    public int probaCommunRare(){
        return 336;
    }

    /**
     * Fonction définissant la probabilité d'un evenement epic
     * @return int valeur de l'évènement
     */
    public int probaCommunEpic(){
        return 64;
    }

    /**
     * Fonction définissant la probabilité d'un evenement légendaire
     * @return int valeur de l'évènement
     */
    public int probaCommunLegendaire(){
        return 0;
    }

}

package Lootbox.lootbox_Code.outils;

/**
 * Singleton s'occupant de retourner les 5 probabilités respectives des 5 événements d'une boite en metal
 */
public class ProbaMetal {


    private static ProbaMetal ourInstance = new ProbaMetal();

    /**
     * Auto-instance du singleton
     * @return rien, simplement l'instance
     */
    public static ProbaMetal getInstance(){
        return ourInstance;
    }

    /**
     * Fonction définissant la probabilité d'un evenement commun
     * @return int valeur de l'évènement
     */
    public int probaRareCommun(){
        return 5000;
    }

    /**
     * Fonction définissant la probabilité d'un evenement moyen
     * @return int valeur de l'évènement
     */
    public int probaRareMoyen(){
        return 2500;
    }

    /**
     * Fonction définissant la probabilité d'un evenement rare
     * @return int valeur de l'évènement
     */
    public int probaRareRare(){
        return 1150;
    }

    /**
     * Fonction définissant la probabilité d'un evenement epic
     * @return int valeur de l'évènement
     */
    public int probaRareEpic(){
        return 1000;
    }

    /**
     * Fonction définissant la probabilité d'un evenement légendaire
     * @return int valeur de l'évènement
     */
    public int probaRareLegendaire(){
        return 350;
    }
}

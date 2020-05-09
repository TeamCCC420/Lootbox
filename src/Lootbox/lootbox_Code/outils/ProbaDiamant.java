package Lootbox.lootbox_Code.outils;

/**
 * Singleton s'occupant de retourner les 5 probabilités respectives des 5 événements d'une boite en diamant
 */
public class ProbaDiamant {

    private static ProbaDiamant ourInstance = new ProbaDiamant();

    /**
     * Auto-instance du singleton
     * @return rien, simplement l'instance
     */
    public static ProbaDiamant getInstance(){
        return ourInstance;
    }

    /**
     * Fonction définissant la probabilité d'un evenement commun
     * @return int valeur de l'évènement
     */
    public int probaLegendaireCommun(){
        return 0;
    }

    /**
     * Fonction définissant la probabilité d'un evenement moyen
     * @return int valeur de l'évènement
     */
    public int probaLegendaireMoyen(){
        return 4000;
    }

    /**
     * Fonction définissant la probabilité d'un evenement rare
     * @return int valeur de l'évènement
     */
    public int probaLegendaireRare(){
        return 2800;
    }

    /**
     * Fonction définissant la probabilité d'un evenement epic
     * @return int valeur de l'évènement
     */
    public int probaLegendaireEpic(){
        return 2200;
    }

    /**
     * Fonction définissant la probabilité d'un evenement légendaire
     * @return int valeur de l'évènement
     */
    public int probaLegendaireLegendaire(){
        return 1000;
    }

}

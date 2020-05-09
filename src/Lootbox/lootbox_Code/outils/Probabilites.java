package Lootbox.lootbox_Code.outils;

/**
 * Singleton utilisé pour obtenir les tableaux de probabilités de chaque boite de l'application
 */
public class Probabilites{

    private static Probabilites ourInstance = new Probabilites();

    /**
     * Auto-instance du singleton
     * @return rien, simplement l'instance
     */
    public static Probabilites getInstance(){
        return ourInstance;
    }

    ////////////////////////////////////////////////////////////////////////////

    /**
     * Fonction des probabilité d'une boite en bois : boite simple
     * @return int[5] retourne le tableau des 5 probabilités de la boite: comumn, moyen, rare, epic, legendaire
     */
    public int[] probaCommun(){
        int[] tab = new int[5];
        tab[0] = ProbaBois.getInstance().probaCommunCommun();
        tab[1] = ProbaBois.getInstance().probaCommunMoyen();
        tab[2] = ProbaBois.getInstance().probaCommunRare();
        tab[3] = ProbaBois.getInstance().probaCommunEpic();
        tab[4] = ProbaBois.getInstance().probaCommunLegendaire();
        return tab;
    }

    /**
     * Total des probabilités des 5 evenements possibles de la boite en bois : boite simple
     * @return int Somme totale des probabilités de chaque type d'objet de la boite
     */
    public int probaCommunMax(){
        return (ProbaBois.getInstance().probaCommunCommun()+
                ProbaBois.getInstance().probaCommunMoyen()+
                ProbaBois.getInstance().probaCommunRare()+
                ProbaBois.getInstance().probaCommunEpic()+
                ProbaBois.getInstance().probaCommunLegendaire());
    }

    ////////////////////////////////////////////////////////////////////////////

    /**
     * Fonction des probabilité d'une boite en Metal : boite moyenne
     * @return int[5] retourne le tableau des 5 probabilités de la boite: comumn, moyen, rare, epic, legendaire
     */
    public int[] probaRare(){
        int[] tab = new int[5];
        tab[0] = ProbaMetal.getInstance().probaRareCommun();
        tab[1] = ProbaMetal.getInstance().probaRareMoyen();
        tab[2] = ProbaMetal.getInstance().probaRareRare();
        tab[3] = ProbaMetal.getInstance().probaRareEpic();
        tab[4] = ProbaMetal.getInstance().probaRareLegendaire();
        return tab;
    }

    /**
     * Total des probabilités des 5 evenements possibles de la boite en Metal : boite moyenne
     * @return int Somme totale des probabilités de chaque type d'objet de la boite
     */
    public int probaRareMax(){
        return (ProbaMetal.getInstance().probaRareCommun()+
                ProbaMetal.getInstance().probaRareMoyen()+
                ProbaMetal.getInstance().probaRareRare()+
                ProbaMetal.getInstance().probaRareEpic()+
                ProbaMetal.getInstance().probaRareLegendaire());
    }



    ////////////////////////////////////////////////////////////////////////////


    /**
     * Fonction des probabilité d'une boite en Diamant : boite elevee
     * @return int[5] retourne le tableau des 5 probabilités de la boite: comumn, moyen, rare, epic, legendaire
     */
    public int[] probaLegendaire(){
        int[] tab = new int[5];
        tab[0] = ProbaDiamant.getInstance().probaLegendaireCommun();
        tab[1] = ProbaDiamant.getInstance().probaLegendaireMoyen();
        tab[2] = ProbaDiamant.getInstance().probaLegendaireRare();
        tab[3] = ProbaDiamant.getInstance().probaLegendaireEpic();
        tab[4] = ProbaDiamant.getInstance().probaLegendaireLegendaire();
        return tab;
    }

    /**
     * Total des probabilités des 5 evenements possibles de la boite en Diamant : boite elevee
     * @return int Somme totale des probabilités de chaque type d'objet de la boite
     */
    public int probaLegendaireMax(){
        return (ProbaDiamant.getInstance().probaLegendaireCommun()+
                ProbaDiamant.getInstance().probaLegendaireMoyen()+
                ProbaDiamant.getInstance().probaLegendaireRare()+
                ProbaDiamant.getInstance().probaLegendaireEpic()+
                ProbaDiamant.getInstance().probaLegendaireLegendaire());
    }
}
package Lootbox.lootbox_Code.outils;

public class Probabilites{

    private static Probabilites ourInstance = new Probabilites();

    public static Probabilites getInstance(){
        return ourInstance;
    }

    ////////////////////////////////////////////////////////////////////////////

    public int[] probaCommun(){
        int[] tab = new int[5];
        tab[0] = probaCommunCommun();
        tab[1] = probaCommunMoyen();
        tab[2] = probaCommunRare();
        tab[3] = probaCommunEpic();
        tab[4] = probaCommunLegendaire();
        return tab;
    }

    public int probaCommunMax(){
        return (probaCommunCommun()+probaCommunMoyen()+probaCommunRare()+probaCommunEpic()+probaCommunLegendaire());
    }

    public int probaCommunCommun(){
        return 8000;
    }

    public int probaCommunMoyen(){
        return 1600;
    }

    public int probaCommunRare(){
        return 336;
    }

    public int probaCommunEpic(){
        return 64;
    }

    public int probaCommunLegendaire(){
        return 0;
    }

    ////////////////////////////////////////////////////////////////////////////

    public int[] probaRare(){
        int[] tab = new int[5];
        tab[0] = probaRareCommun();
        tab[1] = probaRareMoyen();
        tab[2] =  probaRareRare();
        tab[3] = probaRareEpic();
        tab[4] = probaRareLegendaire();
        return tab;
    }

    public int probaRareMax(){
        return (probaRareCommun()+probaRareMoyen()+probaRareRare()+probaRareEpic()+probaRareLegendaire());
    }

    public int probaRareCommun(){
        return 5000;
    }

    public int probaRareMoyen(){
        return 2500;
    }

    public int probaRareRare(){
        return 1150;
    }

    public int probaRareEpic(){
        return 1000;
    }

    public int probaRareLegendaire(){
        return 350;
    }

    ////////////////////////////////////////////////////////////////////////////

    public int[] probaLegendaire(){
        int[] tab = new int[5];
        tab[0] = probaLegendaireCommun();
        tab[1] = probaLegendaireMoyen();
        tab[2] =  probaLegendaireRare();
        tab[3] = probaLegendaireEpic();
        tab[4] = probaLegendaireLegendaire();
        return tab;
    }

    public int probaLegendaireMax(){
        return (probaLegendaireCommun()+probaLegendaireMoyen()+probaLegendaireRare()+probaLegendaireEpic()+probaLegendaireLegendaire());
    }

    public int probaLegendaireCommun(){
        return 0;
    }

    public int probaLegendaireMoyen(){
        return 4000;
    }

    public int probaLegendaireRare(){
        return 2800;
    }

    public int probaLegendaireEpic(){
        return 2200;
    }

    public int probaLegendaireLegendaire(){
        return 1000;
    }

}
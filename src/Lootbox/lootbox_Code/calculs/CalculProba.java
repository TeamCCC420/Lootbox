package Lootbox.lootbox_Code.calculs;

public class CalculProba {

    private static CalculProba ourInstance = new CalculProba();

    /**
     * Auto-instance du singleton
     * @return rien, simplement l'instance
     */
    public static CalculProba getInstance(){
        return ourInstance;
    }

    /**
     * Fonction qui calcul le facteur binominal d'un evenemment
     * @param n Nombre d'itération
     * @param p Probabilité de l'événement succés à calculer
     * @param k Nombre de succés espérés (n>=k)
     * @return float Le facteur binominal d'un evenemment
     */
    public float binomiale(int n, float p, int k){
        float resultat;
        resultat = (float) (coeffBin(n,k) * Math.pow(p,k) * Math.pow(1-p,n-k));
        return resultat;
    }

    /**
     * Fonction calculant le binome de Newton de (n\k)
     * @param n  Nombre d'itération
     * @param k Nombre de succés espérés (n>=k)
     * @return int Le binome de Newton de (n\k)
     */
    public int coeffBin(int n, int k){
        if(k==0 || k==n) return 1;
        else return coeffBin(n-1, k) + coeffBin(n-1, k-1);
    }

    private float valeurXNormale(float ecartType, int nbvaleur, int nb, float moyenne){
        if (nbvaleur%2 == 0){
           nbvaleur++;
        }
        int nbSoustraction = nbvaleur/2;
        int facteur;
        if(nb == nbSoustraction){
            facteur = 0;
        }else{
            facteur = nb-nbSoustraction;
        }
        return moyenne + facteur*ecartType;
    }

    public float[] normale(int max, int nbvaleur, ValeurObject... val){
        if(nbvaleur%2==0){
            nbvaleur++;
        }
        float res[] = new float[nbvaleur];
        float ecartType = ecartType(max, val);
        float moyenne = moyenne(max, val);
        float x = 0, temp = 0, temp2 = 0;
        for(int i=0; i<nbvaleur; i++){
            x = valeurXNormale(ecartType,nbvaleur,i,moyenne);
            temp = (1/(float)(ecartType * Math.sqrt(2*Math.PI)));
            temp2 = (float) (-0.5 * (float)Math.pow(((x-moyenne)/ecartType),2));
            res[i] = (temp) * (float)Math.exp(temp2);
        }
        return res;
    }

    public float ecartType(int max, ValeurObject... val){
        return (float) Math.sqrt(variance(max,val));
    }

    public float variance(int max, ValeurObject... val){
        float res = 0;
        float moy = moyenne(max, val);
        for(ValeurObject o : val){
            res += o.getNbfois() * (float)Math.pow((o.getValeur() - moy),2);
        }
        return res/max;
    }

    public float moyenne(int max, ValeurObject... val){
        float res = 0;
        for(ValeurObject o : val){
            res += o.getNbfois() * o.getValeur();
        }
        return res/max;
    }
}

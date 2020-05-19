package Lootbox.lootbox_Code.outils;

public class Semaphore {

    private int sema = 0;

    private static Semaphore ourInstance = new Semaphore();

    /**
     * Auto-instance du singleton
     * @return rien, simplement l'instance
     */
    public static Semaphore getInstance() {
        return ourInstance;
    }

    public String getSema(){
        return "" + sema++;
    }
}

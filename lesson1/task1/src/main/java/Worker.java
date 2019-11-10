public class Worker extends Thread {
   public static final int amountOfGold = 3;
    GoldMine goldMine;

    public Worker(GoldMine goldMine) {
        setDaemon(true);
        this.goldMine = goldMine;
    }

    public void run() {
        System.out.println("hi, i am a new Worker (" + Thread.currentThread().getName() + ")");
        while (true) {
            try {
                System.out.println(Thread.currentThread().getName()+" - started mining : "+goldMine.getGold());
                if (goldMine.getGold() <= 3) {
                    mining(goldMine.getGold());
                } else {
                    mining(amountOfGold);
                }
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void mining(int goldPerSecond) {
        goldMine.setGold(goldMine.getGold() - goldPerSecond);
        System.out.println(goldMine.getGold() + " Gold Left In The Mine (" + Thread.currentThread().getName() + ")");
    }
}

package bank;

public class IDCounter {

    private static IDCounter counter;

    private int currentNr = 0;

    private IDCounter(){}

    public static IDCounter getInstance() {
        if (counter == null) {
            counter = new IDCounter();
        }
        return counter;
    }

    public void incrementCounter() {
        currentNr++;
    }

    public int getNr() {
        return this.currentNr;
    }

}

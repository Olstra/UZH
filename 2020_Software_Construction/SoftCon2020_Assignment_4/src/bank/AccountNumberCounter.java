package bank;

public class AccountNumberCounter {

    private static AccountNumberCounter counter;

    private int currentNr = 0;

    private AccountNumberCounter(){}

    public static AccountNumberCounter getInstance() {
        if (counter == null) {
            counter = new AccountNumberCounter();
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

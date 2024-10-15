package bank;

import bank.Customers.*;

import java.time.YearMonth;
import java.util.Random;

public class CreditCard {

    // customer related attributes
    private String ownerName;
    private String ownerSureName;
    private int serialNr;
    private int securityCode;
    private YearMonth expirationDate;
    private CustomerStatus type; // regular, golden, platinum
    private IDCounter counter = IDCounter.getInstance();

    public CreditCard(Customer customer) {
        this.ownerName = customer.getName();
        this.ownerSureName = customer.getSurname();
        this.serialNr = setSerialNr();
        this.securityCode = setSecurityCode();
        this.expirationDate = setExpirationDate();
        this.type = customer.getCustomerStatus();
    }

    private int setSecurityCode() {
        Random rand = new Random();
        int code = rand.nextInt(900) + 100;

        return code;
    }

    private int setSerialNr() {
        counter.incrementCounter();
        return counter.getNr();
    }

    /**
     * Note: since no specification for the expiration date was given
     * (other than it should have one)
     * we just assign "now" as expiration date
     * */
    private YearMonth setExpirationDate() {
        return YearMonth.now();
    }

    // getters
    /**
     * Note: in real world we wouldn't implement this method
     * but rather test the code with the actual functionality of the card.
     *
     * For simplicity in this case we did implement this method to be able to test it
     * since no further context on the usage of the card was given.
     * */
    public int getSecurityCode() { return this.securityCode; }

    public String getOwnerName() { return this.ownerName; }
    public String getOwnerSureName() { return this.ownerSureName; }
    public int getSerialNr() { return this.serialNr; }
    public CustomerStatus getType() { return this.type; }
    public YearMonth getExpirationDate() { return this.expirationDate; }


}

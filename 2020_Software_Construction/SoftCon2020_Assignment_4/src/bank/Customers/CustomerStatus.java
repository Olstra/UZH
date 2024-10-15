package bank.Customers;

public enum CustomerStatus {


    REGULAR(2000),
    GOLDEN(5000),
    PLATINUM(10000);

    private double limit;
    CustomerStatus(double limit) {
        this.limit = limit;
    }
    public double getLimit(){return limit;}
}

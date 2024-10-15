package bank.Customers;
import bank.CreditCard;
import bank.Individual;

import static bank.Individual.roles.CUSTOMER;
import bank.AccountNumberCounter;


//TODO see if we have to use casts if customer is up or degraded maybe in the employee class
//Reason for that is that we have to make sure that the correct Limit is chosen. for the transaciton.
public class Customer extends Individual{

    private final int age;

    private final int bankAccountNumber;
    private CustomerStatus status;
    private double savings = 0;
    private CreditCard creditCard;
    private double limit;

    AccountNumberCounter accountNrGenerator = AccountNumberCounter.getInstance();
    public Customer(String name,String surname, int age, CustomerStatus status ) throws IllegalArgumentException{
            super(name, surname);
            if (age < 0) {
                throw new IllegalArgumentException("The specified input for this Customer is invalid");
            }

            accountNrGenerator.incrementCounter();
            this.bankAccountNumber = accountNrGenerator.getNr();
            this.age = age;
            super.setRole(CUSTOMER);
            this.creditCard = new CreditCard(this);
            this.status = status;
            this.limit = status.getLimit();

    }

    //getter methods


    public int getAge(){
        return age;
    }

    public double getSavings() {
        return savings;
    }

    //used for the credit card payments
    public void setSavings(double savings){this.savings = savings;}

    public CustomerStatus getCustomerStatus(){
        return status; }

    public int getAccountNumber(){return bankAccountNumber;}

    public CreditCard getCreditCard(){ return creditCard; }

    public double getLimit(){ return limit;}


    //setter methods
    public void setCustomerStatus(CustomerStatus newStatus){
        this.status = newStatus;
    }

    public void setLimit(CustomerStatus status){this.limit = status.getLimit();}



    public void depositMoney(double amount) throws  IllegalArgumentException{
        if(amount < 0 ){
            throw new IllegalArgumentException("cannot deposit a negative amount of money");
        }
        savings += amount;
    }

    public double withdrawMoney(double amount) throws IllegalArgumentException{
        if( amount < 0 || amount > savings){
            throw new IllegalArgumentException("specified amount is invalid for withdrawMoney");
        }

        savings -= amount;
        return amount;
    }

    public void bankTransfer(double amount){
        if( amount < 0 || amount > savings){
            throw new IllegalArgumentException("specified amount is invalid for bankTransfer");
        }

        savings -= amount;

    }


    public void payByCreditCard(double amount) throws IllegalArgumentException {
        if(amount < 0 || amount > limit){
            throw new IllegalArgumentException();
        }
        savings = savings - amount;
    }

//    enum customerStatus{
//        REGULAR,
//        GOLDEN,
//        PLATINUM
//    }
}

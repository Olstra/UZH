package bank.Employees;

import bank.Customers.Customer;
import bank.Individual;

import static bank.Customers.CustomerStatus.*;

public class BankEmployee extends Individual {

    public BankEmployee(String name, String surname){
        super(name, surname);
    }

    public void upgradeToGolden(Customer customer) {
        if (customer.getCustomerStatus() == GOLDEN) {
            throw new IllegalArgumentException("This customer already has GOLDEN status");
        }
        if (customer.getCustomerStatus() == PLATINUM) {
            throw new IllegalArgumentException("This customer has PLATINUM status");
        }
        customer.setCustomerStatus(GOLDEN);
        customer.setLimit(customer.getCustomerStatus());

    }
}

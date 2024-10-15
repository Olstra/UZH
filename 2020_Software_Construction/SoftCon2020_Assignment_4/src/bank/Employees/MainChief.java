package bank.Employees;

import bank.Customers.CustomerStatus;
import bank.Customers.Customer;
import bank.Individual;

import static bank.Customers.CustomerStatus.*;

public class MainChief extends BankEmployee {

    public MainChief(String name, String surname){
        super(name, surname);
    };

    public void downgradeToRegular(Customer customer) {
        if (customer.getCustomerStatus() == REGULAR) {
            throw new IllegalArgumentException("This customer already has REGULAR status and cannot be downgraded");
        }
        customer.setCustomerStatus(CustomerStatus.REGULAR);
        customer.setLimit(customer.getCustomerStatus());
    }

    public void downgradeToGolden(Customer customer) {
        if (customer.getCustomerStatus() == GOLDEN) {
            throw new IllegalArgumentException("This customer already has GOLDEN status");
        }
        if (customer.getCustomerStatus() == REGULAR) {
            throw new IllegalArgumentException("This customer has REGULAR status and cannot be downgraded");
        }
        customer.setCustomerStatus(CustomerStatus.GOLDEN);
        customer.setLimit(customer.getCustomerStatus());
    }

    public void upgradeToPlatinum(Customer customer) {
        if (customer.getCustomerStatus() == PLATINUM) {
            throw new IllegalArgumentException("This customer already has PLATINUM status");
        }
        customer.setCustomerStatus(CustomerStatus.PLATINUM);
        customer.setLimit(customer.getCustomerStatus());
    }
}

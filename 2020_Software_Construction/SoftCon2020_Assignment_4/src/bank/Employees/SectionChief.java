package bank.Employees;

import bank.Customers.CustomerStatus;
import bank.Customers.Customer;
import bank.Individual;

import static bank.Customers.CustomerStatus.*;

public class SectionChief extends BankEmployee {
    public String city;

    public SectionChief(String name, String surname, String city){
        super(name, surname);
    }

    public void downgradeToRegular(Customer customer) {
        if (customer.getCustomerStatus() == REGULAR) {
            throw new IllegalArgumentException("This customer already has REGULAR status and cannot be downgraded");
        }
        customer.setCustomerStatus(CustomerStatus.REGULAR);
        customer.setLimit(customer.getCustomerStatus());
    }

    public void upgradeToPlatinum(Customer customer) {
        if (customer.getCustomerStatus() == PLATINUM) {
            throw new IllegalArgumentException("This customer already has PLATINUM status");
        }
        customer.setCustomerStatus(CustomerStatus.PLATINUM);
        customer.setLimit(customer.getCustomerStatus());
    }

    public String getCity(){
        return city;
    }
}

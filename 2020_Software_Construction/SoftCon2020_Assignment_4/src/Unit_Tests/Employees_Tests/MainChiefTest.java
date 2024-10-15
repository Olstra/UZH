package Unit_Tests.Employees_Tests;

import bank.Customers.Customer;
import bank.Customers.CustomerStatus;
import org.junit.jupiter.api.Test;

import static bank.Customers.CustomerStatus.GOLDEN;
import static bank.Customers.CustomerStatus.REGULAR;
import static bank.Customers.CustomerStatus.PLATINUM;
import static org.junit.jupiter.api.Assertions.*;
import bank.Employees.MainChief;

class MainChiefTest {

    // Employee test attributes
    private final String testName = "Amy";
    private final String testSurname = "Fisher";

    // Customer test attributes
    private final String customerName = "Brad";
    private final String customerSurname = "Pitt";
    private final int customerAge = 56;

    // Test employee and customer
    private final MainChief employee = new MainChief(testName, testSurname);
    private final Customer customer = new Customer(customerName, customerSurname, customerAge, PLATINUM);

    /**
     * Tests if the Main chief can downgrade a customer to Golden status
     * @return getCustomerStatus() returns the status
     *
     * Checks if the method updates to the expected Status
     */

    @Test
    void MainChiefDowngradesToGolden(){
        employee.downgradeToGolden(customer);
        CustomerStatus expected = GOLDEN;
        assertEquals(expected,customer.getCustomerStatus());
    }

    /**
     * Tests if the Main chief can downgrade a customer to Regular status
     * @return getCustomerStatus() returns the status
     *
     * Checks if the method updates to the expected Status
     */

    @Test
    void MainChiefDowngradesToRegular(){
        employee.downgradeToRegular(customer);
        CustomerStatus expected = REGULAR;
        assertEquals(expected,customer.getCustomerStatus());
    }

    /**
     * Tests if the Main chief can upgrade a customer to Platinum status
     * @return getCustomerStatus() returns the status
     *
     * Checks if the method updates to the expected Status
     */

    @Test
    void MainChiefUpgradesToPlatinum(){
        employee.upgradeToPlatinum(customer);
        CustomerStatus expected = PLATINUM;
        assertEquals(expected,customer.getCustomerStatus());
    }
}
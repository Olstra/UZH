package Unit_Tests.Employees_Tests;

import bank.Customers.Customer;
import bank.Customers.CustomerStatus;
import bank.Employees.BankEmployee;
import org.junit.jupiter.api.Test;

import static bank.Customers.CustomerStatus.*;
import static org.junit.jupiter.api.Assertions.*;

class BankEmployeeTest {

    // Employee test attributes
    private final String testName = "James";
    private final String testSurname = "White";

    // Customer test attributes
    private final String customerName = "Jennifer";
    private final String customerSurname = "Aniston";
    private final int customerAge = 51;

    // Test employee and customer
    private final BankEmployee employee = new BankEmployee(testName, testSurname);
    private final Customer customer = new Customer(customerName, customerSurname, customerAge, REGULAR);

    /**
     * Tests if the Bank Employee can upgrade a customer to Golden status
     * @return getCustomerStatus() returns the status
     *
     * Checks if the method updates to the expected Status
     */

    @Test
    void BankEmployeeUpgradesToGolden(){
        employee.upgradeToGolden(customer);
        CustomerStatus expected = GOLDEN;
        assertEquals(expected,customer.getCustomerStatus());
    }
}
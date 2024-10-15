package Unit_Tests.Employees_Tests;

import static bank.Customers.CustomerStatus.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import bank.Customers.Customer;
import bank.Customers.CustomerStatus;
import bank.Employees.MainChief;
import bank.Employees.RegularEmployee;

class RegularEmployeeTest {

    // Employee test attributes
    private final String testName = "Stephanie";
    private final String testSurname = "Schlipp";

    // Customer test attributes
    private final String customerName = "Sacha";
    private final String customerSurname = "Cohen";
    private final int customerAge = 49;

    // Test employee and customer
    private final MainChief employee = new MainChief(testName, testSurname);
    private final Customer customer = new Customer(customerName, customerSurname, customerAge, REGULAR);

    /**
     * Tests if the Regular Employee can upgrade a customer to Golden status
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
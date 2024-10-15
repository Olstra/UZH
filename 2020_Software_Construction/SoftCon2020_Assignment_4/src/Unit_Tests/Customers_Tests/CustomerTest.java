package Unit_Tests.Customers_Tests;

import bank.Customers.Customer;
import bank.Customers.CustomerStatus;
import org.junit.jupiter.api.Test;
import static bank.Customers.CustomerStatus.*;
import static org.junit.jupiter.api.Assertions.*;



class CustomerTest {

    // Test attributes
    private final String testName = "Maximilian";
    private final String testSurname = "Müller";
    private final int testAge = 25;

    // is tested on RegularCustomer but it will check the methods used in Customer, all the specific casese will
    // moved to their corresponding Testclasses.
    // name and surname are already tested in individual.
    private final Customer customer = new Customer(testName, testSurname, testAge,REGULAR);



    /**
     * Testcase sees if the customer has an age that is accepted i.e. not negative
     * @return age of customer
     **/
    @Test
    void CustomerHasAge() {
        assertNotNull(customer.getAge());
        assertTrue(customer.getAge() >= 0);
    }


    /**
     * Testcase sees if the customer has a bankaccount number using the method getAccountNr()
     * @return bankAccountNr of customer
     * Checks if the bank account number has been assigned
     **/
    @Test
    void CustomerHasBankAccountNr() {
        assertNotNull(customer.getAccountNumber());
    }

    /**
     * Testcase sees if the customer has savings using the method getSavings()
     * @return current savings of customer
     * Checks if the savings are returned correctly
     **/
    @Test
    void CustomerHasSavings() {
        double savings = 500;
        customer.depositMoney(savings);
        assertEquals(savings,customer.getSavings());
    }

    /**
     * Testcase sees if the customer has a creditcard using the method getCreditcard()
     * @return current credit card of customer
     * Checks if the creditcard assigned to the customer is returned
     **/
    @Test
    void CustomerHasCreditCard() {
    assertNotNull(customer.getCreditCard());
    }


    // Test actions
    // also test special and corner cases

    /**
     * Testcase tests the method depositMoney(double amount) in the Customer class.
     * The input "amount" specifies the amount that should be deposited onto the customers savings.
     * @exception IllegalArgumentException for invalid parameter input
     *
     * Checks if the field savings initialized in the Customer class actually changes its value
     * after depositing a specified amount of money.
     * Checks if negative values are rejected by the method.
     * */
    @Test
    void DepositMoney() {
        double currentSavings = customer.getSavings();
        double deposit = 200.55;
        customer.depositMoney(deposit);

        // assert if new money is successfully deposited onto savings
        assertEquals(currentSavings+deposit,customer.getSavings());
        // assert if negative deposits are rejected
        assertThrows(IllegalArgumentException.class ,() -> customer.depositMoney(-200));
    }


    @Test
    /**
     * Testcase tests if the assigned limit to Customer is there.
     * @return getLimit() returns the Limit
     *
     * Checks if the method returns the expected Limit
     */
    void CustomerHasLimit(){
        double expectedLimit = customer.getLimit();
        assertNotNull(customer.getLimit());
        assertEquals(expectedLimit, customer.getLimit());

    }

    /**
     * Testcase tests if the assigned Status to Customer is correct for every status.
     * @return getCustomerStatus() returns the status
     *
     * Checks if the method returns the expected Status
     */
    @Test
    void CustomerHasCorrectStatus(){
         CustomerStatus expected = REGULAR;
         assertEquals(expected,customer.getCustomerStatus());
         expected = GOLDEN;

         customer.setCustomerStatus(expected);
        assertEquals(expected,customer.getCustomerStatus());

        expected = PLATINUM;
        customer.setCustomerStatus(expected);
        assertEquals(expected,customer.getCustomerStatus());
    }

    /**
     *
     * Testcase tests the method payByCreditCard(double amount) in the GoldenCustomer class.
     * The GoldenCustomer has a card limit of CHF 5000.00.
     * The input "amount" specifies the amount that should be used for the transfer.
     * @exception IllegalArgumentException for invalid parameter input.
     *
     * Checks if the method rejects payments that are higher than the existing cardLimit
     * Checks if the method rejects negative values
     **/
    @Test
    void PayByCreditCard() {
        double limit = customer.getLimit();
        customer.depositMoney(500.00);
        double currentSavings = customer.getSavings();
        double amount = 501.00;
        customer.payByCreditCard(amount);
        /*
         * Checks the following things in order:
         * -checks deduction by credit card influcences savings
         * -restricts possible payments to be no higher than the given limits
         * -denies negative values as input
         */
        assertEquals(currentSavings-amount, customer.getSavings());
        assertThrows(IllegalArgumentException.class, ()-> customer.payByCreditCard(limit+20));
        assertThrows(IllegalArgumentException.class, ()-> customer.payByCreditCard(-200));
    }

    /**
     * Testcase tests the method withdrawMoney(double amount) in the Customer class.
     * The Input "amount" specifies the amount that should be withdrawn from the customers savings.
     * @return amount that was withdrawn
     * @exception IllegalArgumentException for invalid parameter input.
     *
     * Checks if withdrawal of money manipulates the customers savings.
     * Checks if the withdrawn amount is returned.
     * Checks if the method rejects withdrawals that are higher than the existing savings
     * Checks if the method rejects negative values
     */
    @Test
    void WithdrawMoney() {
        //deposit money so the account is not at zero
        customer.depositMoney(500);

        double currentSavings = customer.getSavings();
        double withdraw = 200.55;
        customer.withdrawMoney(withdraw);
        /*assert the following cases in order:
             - withdraw actually changes savings
             - withdraw returns the amount withdrawn
             - withdraw more money than savings is rejected
             - trying to withdraw a negative amount of money is rejected
         */
        assertEquals(currentSavings-withdraw,customer.getSavings());
        assertEquals(customer.withdrawMoney(withdraw) , withdraw);
        assertThrows(IllegalArgumentException.class, ()-> customer.withdrawMoney(customer.getSavings()+1));
        assertThrows(IllegalArgumentException.class, ()-> customer.withdrawMoney(-200.55));
    }

    /**
     * Testcase tests the method bankTransfer(double amount) in the Customer class.
     * The input "amount" specifies the amount that should be used for the transfer.
     * @exception IllegalArgumentException for invalid parameter input.
     *
     * Checks if withdrawal of money manipulates the customers savings.
     * Checks if the method rejects withdrawals that are higher than the existing savings
     * Checks if the method rejects negative values
     */
    @Test
    void PayWithBankTransfer() {
        // deposit money so the account is not at zero
        customer.depositMoney(500);

        double currentSavings = customer.getSavings();
        double payment = 200.55;
        customer.bankTransfer(payment);
        /* assert the following cases in order:
        *    - payment is subtracted from savings
        *    - payment is rejected if more money will be withdrawn than there are savings
        *    - trying to pay with a negative amount is rejected
        * */
        assertEquals(currentSavings-payment,customer.getSavings());
        assertThrows(IllegalArgumentException.class, ()-> customer.bankTransfer(customer.getSavings()+1));
        assertThrows(IllegalArgumentException.class, ()-> customer.bankTransfer(-200.55));
    }


}
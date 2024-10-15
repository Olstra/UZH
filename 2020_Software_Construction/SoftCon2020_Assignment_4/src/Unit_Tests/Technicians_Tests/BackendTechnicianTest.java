package Unit_Tests.Technicians_Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

import bank.Technicians.BackendTechnician;

class BackendTechnicianTest {

    private final BackendTechnician testTech = new BackendTechnician("TestName", "TestSureName");

    /**
     * Checks that the credit card contains the FixBackEnd method
     *
     * */
    @Test
    void HasFixBackEndMethod() {

        String methodName = "FixBackEnd";
        Method testMethod = null;

        try {
            testMethod = BackendTechnician.class.getMethod(methodName, (Class<?>[]) null);
        }
        catch (NoSuchMethodException | SecurityException e) {
            assertNotNull(testMethod); // TODO why this always null?
        }

        assertEquals(testMethod.getName(), methodName);
    }

    /**
     * Checks that we get an exception if the wrong ID was given
     *
     * */
    @Test
    public void FixBackEndWrongIDGiven() {

        int wrongID = -1389595623;

        Exception exception = assertThrows(Exception.class, () ->this.testTech.FixBackEnd(wrongID));

        assertEquals("wrong ID was provided", exception.getMessage());

    }

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    /**
     * Checks that the we get the correct message if the method could work correctly
     *
     * */
    @Test
    void FixBackEndCorrectInput() {

        String expectedMsg = "fixed!";
        int ID = this.testTech.getID();

        this.testTech.FixBackEnd(ID);

        assertEquals(expectedMsg, outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}
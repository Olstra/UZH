package Unit_Tests.Technicians_Tests;

import bank.Technicians.WebTechnician;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

class WebTechnicianTest {

    private final WebTechnician testTech = new WebTechnician("TestName", "TestSureName");


    /**
     * The only action a web-technician can perform is to fix the website
     * Tests that this method is given
     *
     */
    @Test
    public void HasMethodFixWebsite(){

        String methodName = "FixWebsite";
        Method testMethod = null;

        try {
            testMethod = WebTechnician.class.getMethod(methodName, (Class<?>[]) null);
        }
        catch (NoSuchMethodException | SecurityException e) {
            System.out.println("upsi!");
        }

        assert testMethod != null;
        assertEquals(testMethod.getName(), methodName);

    }

    /**
     * The method fix website should wait 30s
     *
     * */
    @Test
    void FixWebsiteWaits30s() {

        long expectedTime = 30; // milliseconds

        // set "maximum" timeout, we'll check the exact amount at the end of test
        assertTimeout(ofSeconds(expectedTime+1), () -> {
            long startTime = System.nanoTime();

            // method we want to check
            this.testTech.FixWebsite();

            long endTime = System.nanoTime();

            long dTime = endTime - startTime;

            long convert = TimeUnit.SECONDS.convert(dTime, TimeUnit.NANOSECONDS);

            // check that it was exactly the expected amount of time
            assertEquals(expectedTime, convert);

        });

    }

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }


    /**
     * The method fix website should print a message
     *
     * */
    @Test
    void FixWebsitePrintsMessage() throws InterruptedException {

        String expectedMsg = "reparations complete";

        this.testTech.FixWebsite();

        assertEquals(expectedMsg, outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}
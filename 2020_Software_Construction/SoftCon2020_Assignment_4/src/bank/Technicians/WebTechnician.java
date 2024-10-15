package bank.Technicians;

import java.util.Timer;


public class WebTechnician extends Technician{

    public WebTechnician(String name, String surname) throws IllegalArgumentException {
        super(name, surname);
    }

    public void FixWebsite() throws InterruptedException {

        // wait 30s
        Timer timer = new Timer();
        Thread.sleep(30000);

        // print message
        System.out.println("reparations complete");
        timer.purge();

    }
}

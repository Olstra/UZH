package App;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Scanner;

public class UserSimulator {
    private String testName = "Monty";
    private String testSurname = "Burns";
    private String testAddress = "SimulStreet ";
    private String testphone = "044 444 444";
    private Robot user= new Robot();


    public UserSimulator() throws AWTException {
       typeWord(testName);
       typeWord(testSurname);

    }



    private void typeWord(String input){
        try {
            user.delay(300);
            for (int idx = 0; idx < input.length(); idx++) {
                char current = input.charAt(idx);
                if (Character.isUpperCase(current)) {
                    user.keyPress(KeyEvent.VK_SHIFT);
                    user.keyPress((int) current);
                    user.keyRelease(KeyEvent.VK_SHIFT);
                    user.keyRelease((int) current);
                } else {
                    user.keyPress((int) Character.toUpperCase(current));
                    user.keyRelease((int) current);
                }
                user.delay(100);

            }
        } catch(Exception e){
            System.out.println("Something went wrong");
        }
    }
}

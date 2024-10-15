package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserSimulator {
    private String inputName = "Monty";
    private String inputSurname = "Burns";
    private String inputPhone = "0444444444";
    private String inputAddress1 = "Springfield 10";
    private String inputPhone2 = "041 771 77 77";
    private String inputAddress2 = "Atomfield 5";
    private String copyID;


    private Robot user = new Robot();

    public UserSimulator(EmployeesView view) throws AWTException {
//        Runtime run = Runtime.getRuntime();

        typeWord(inputName);
        movetoNext();
        typeWord(inputSurname);
        movetoNext();
        typeWord(inputAddress1);
        movetoNext();
        typeWord(inputPhone);
        view.defaultNewEmployee();
        pressEnter();
        copyID =  view.getEmpID();
        movetoNext();
        movetoNext();
        typeWord(copyID);
        view.defaultUpdatePhone();
        pressEnter();
        typeWord(inputPhone2);
        pressEnter();
        view.defaultUpdateAddress();
        pressEnter();
        typeWord(inputAddress2);
        pressEnter();

    }

    private void typeWord(String input) {
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
    }

    private void deleteWord(){
        user.delay(100);
        user.keyPress(KeyEvent.VK_CONTROL);
        user.keyPress(KeyEvent.VK_A);
        user.keyPress(KeyEvent.VK_DELETE);
        user.keyRelease(KeyEvent.VK_CONTROL);
        user.keyRelease(KeyEvent.VK_A);
        user.keyRelease(KeyEvent.VK_DELETE);
        user.delay(100);
    }

    private void movetoNext() {
        user.keyPress(KeyEvent.VK_TAB);
        user.keyRelease(KeyEvent.VK_TAB);
    }

    private void movetoPrevious() {
        user.keyPress(KeyEvent.VK_SHIFT);
        user.keyPress(KeyEvent.VK_TAB);
        user.keyRelease(KeyEvent.VK_TAB);
        user.keyRelease(KeyEvent.VK_SHIFT);
    }

    private void pressEnter(){
        user.delay(100);
        user.keyPress(KeyEvent.VK_ENTER);
        user.keyRelease(KeyEvent.VK_ENTER);
        user.delay(100);
            }
}
//    private void movetoNext(){
//        user.keyPress(KeyEvent.VK_TAB);
//        user.keyRelease(KeyEvent.VK_TAB);
//    }
//
//    private void movetoPrevious(){
//        user.keyPress(KeyEvent.VK_SHIFT);
//        user.keyPress(KeyEvent.VK_TAB);
//        user.keyRelease(KeyEvent.VK_TAB);
//        user.keyRelease(KeyEvent.VK_SHIFT);
//    }
////    private void pressEnter(){
////        user.keyPress(KeyEvent.VK_ENTER);
////        user.keyRelease(KeyEvent.VK_ENTER);
////            }
//
//
//
//}
//

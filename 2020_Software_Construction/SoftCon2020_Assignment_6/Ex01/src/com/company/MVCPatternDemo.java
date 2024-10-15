package com.company;

import java.awt.*;

public class MVCPatternDemo {

    public static void main(String[] args) {

        EmployeesView theView = new EmployeesView();
        EmployeesModel theModel = new EmployeesModel();
        EmployeesController theController = new EmployeesController(theView,theModel);

        theView.setVisible(true);

        // Simulation demonstration of App usage
        // According to assignment description
        try {
           UserSimulator user = new UserSimulator(theView);
       } catch( AWTException e){
           System.out.println("Something went wrong");
        }
    }
}

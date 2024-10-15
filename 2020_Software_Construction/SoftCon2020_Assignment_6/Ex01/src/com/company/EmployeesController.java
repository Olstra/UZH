package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EmployeesController {

    private EmployeesView theView;
    private EmployeesModel employeesDB;

    public EmployeesController(EmployeesView theView, EmployeesModel employeesDB) {
        this.theView = theView;
        this.employeesDB = employeesDB;

        this.theView.addEmployeeAddedListener(new ButtonListener());
        this.theView.addPhoneUpdatedListener(new PhoneUpdatedListener());
        this.theView.addAddressUpdatedListener(new AddressUpdatedListener());
        this.theView.addUpdateInfoListener(new UpdateInfoListener());
    }

    // Add new employee
    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            try {
                String name = theView.getEmpName();
                String surname = theView.getEmpSurname();
                String address = theView.getEmpAddress();
                String telephone = theView.getEmpPhone();

                Employee newEmployee = new Employee(name, surname, address, telephone);
                employeesDB.addEmployee(newEmployee);

                theView.displayEmpInfos(employeesDB.getEmployeeThroughID(newEmployee.getID()));

            } catch (NumberFormatException ex) {
                System.out.println(ex);
                theView.displayErrorMessage("ERROR");
            }
        }
    }

    // Update employee's information (either address or telephone)
    class UpdateInfoListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            try{
                String name = JOptionPane.showInputDialog(theView, "new value:", null);
            }
            catch (NumberFormatException ex) {
                System.out.println(ex);
                theView.displayErrorMessage("ERROR");
            }
        }
    }


    class PhoneUpdatedListener implements ActionListener{
        public void actionPerformed(ActionEvent e){

            try{
                String phoneNr = JOptionPane.showInputDialog(theView, "New phone number:", null);
                String ID = theView.getSearchID();

                // update ID
                Employee emp = employeesDB.getEmployeeThroughID(ID);
                emp.setTelephone(phoneNr);
                theView.displayEmpInfos(emp);

            }
            catch (NumberFormatException ex) {
                System.out.println(ex);
                theView.displayErrorMessage("ERROR");
            }
        }
    }

    class AddressUpdatedListener implements ActionListener{
        public void actionPerformed(ActionEvent e){

            try{
                String address = JOptionPane.showInputDialog(theView, "New address:", null);
                String ID = theView.getSearchID();

                // update ID
                Employee emp = employeesDB.getEmployeeThroughID(ID);
                emp.setAddress(address);
                theView.displayEmpInfos(emp);
            }
            catch (NumberFormatException ex) {
                System.out.println(ex);
                theView.displayErrorMessage("ERROR");
            }
        }
    }
}

package com.company;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class EmployeesView extends JFrame{

    private final int fieldLength = 10;

    private JLabel l_name = new JLabel("Name: ");
    private JTextField f_name = new JTextField(fieldLength);
    private JLabel l_name_e = new JLabel("");

    private JLabel l_surname = new JLabel("Surname: ");
    private JTextField f_surname = new JTextField(fieldLength);
    private JLabel l_surname_e = new JLabel("");

    private JLabel l_address = new JLabel("Address: ");
    private JTextField f_address = new JTextField(fieldLength);
    private JLabel l_address_e = new JLabel("");

    private JLabel l_phone = new JLabel("Telephone nr: ");
    private JTextField f_phone = new JTextField(fieldLength);
    private JLabel l_phone_e = new JLabel("");

    private JLabel l_ID = new JLabel("ID: ");
    private JLabel l_ID_placeholder = new JLabel();
    private JLabel l_ID_e = new JLabel("");

    // new Employee button
    private JButton b_newEmployee = new JButton("Create new employee");
    private JLabel l_placeholder1 = new JLabel();
    private JLabel l_placeholder2 = new JLabel();

    // update buttons
    private JLabel l_ID_search = new JLabel("Employee's ID: ");
    private JTextField f_ID_search = new JTextField(fieldLength);
    private JLabel l_ID_placeholder2 = new JLabel();
    private JButton b_update = new JButton("Update information");

    private JButton b_updateAddress = new JButton("Update address");
    private JButton b_updatePhoneNr = new JButton("Update phone number");
    private JLabel l_placeholder3 = new JLabel();

    // line
    private JLabel l_line1 = new JLabel("------------------------------------");
    private JLabel l_line2 = new JLabel("------------------------------------");
    private JLabel l_line3 = new JLabel("------------------------------------");



    EmployeesView() {
        // Set up the App.view and add the components
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);

        this.add(l_name);
        this.add(f_name);
        this.add(l_name_e);

        this.add(l_surname);
        this.add(f_surname);
        this.add(l_surname_e);

        this.add(l_address);
        this.add(f_address);
        this.add(l_address_e);

        this.add(l_phone);
        this.add(f_phone);
        this.add(l_phone_e);

        this.add(l_ID);
        this.add(l_ID_placeholder);
        this.add(l_ID_e);

        // button to add new employee
        this.add(l_placeholder1);
        this.add(b_newEmployee);
        this.add(l_placeholder2);

        // dividing line
        this.add(l_line1);
        this.add(l_line2);
        this.add(l_line3);

        // update info
        this.add(l_ID_search);
        this.add(f_ID_search);
        this.add(l_ID_placeholder2);

        this.add(l_placeholder3);
        this.add(b_updateAddress);
        this.add(b_updatePhoneNr);

        this.setLayout(new GridLayout(9,3));

    }

    // only used for the UserBot so it can access buttons
    public void defaultNewEmployee(){
        SwingUtilities.getRootPane(b_newEmployee).setDefaultButton(b_newEmployee);
    }
    public void defaultUpdateAddress(){
        SwingUtilities.getRootPane(b_updateAddress).setDefaultButton(b_updateAddress);
    }
    public void defaultUpdatePhone(){
        SwingUtilities.getRootPane(b_updatePhoneNr).setDefaultButton(b_updatePhoneNr);
    }

      //////////////////////////
     // get text from fields //
    //////////////////////////

    public String getEmpID(){
        return l_ID_e.getText();
    }

    public String getEmpName() {
        return f_name.getText();
    }

    public String getEmpPhone() {
        return f_phone.getText();
    }

    public String getEmpSurname() {
        return f_surname.getText();
    }

    public String getEmpAddress() {
        return f_address.getText();
    }

    public String getSearchID() { return f_ID_search.getText(); }

     ///////////////////////////
    // add buttons listeners //
   ///////////////////////////

    public void addEmployeeAddedListener(ActionListener listenForButton) {
        b_newEmployee.addActionListener(listenForButton);
    }

    public void addAddressUpdatedListener(ActionListener listenForButton) {
        b_updateAddress.addActionListener(listenForButton);
    }

    void addPhoneUpdatedListener(ActionListener listenForButton) {
        b_updatePhoneNr.addActionListener(listenForButton);
    }

    public void addUpdateInfoListener(EmployeesController.UpdateInfoListener listenForButton) {
        b_update.addActionListener(listenForButton);
    }

    /////////////////////////
    // display/update view //
   /////////////////////////

    void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    public void displayEmpInfos(Employee employee) {

        this.l_name_e.setText(employee.getName());
        this.l_surname_e.setText(employee.getSurname());
        this.l_address_e.setText(employee.getAddress());
        this.l_phone_e.setText(employee.getTelephone());
        this.l_ID_e.setText(employee.getID());

    }

//    public void displayNewNr(String telephone) {
//        l_phone_e.setText(telephone);
//    }
//
//    public void displayNewAddress(String address) {
//        l_address_e.setText(address);
//    }


}
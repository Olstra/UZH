package com.company;

public class Employee {

    private String name;
    private String surname;
    private String address;
    private String telephone;
    private String ID; // a sequence of 8 characters or numbers
    private IDGenerator idGenerator = IDGenerator.getInstance();

    public Employee(String name, String surname, String address, String telephone ) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephone = telephone;
        idGenerator.generateID();
        this.ID = idGenerator.getID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getID() {
        return ID;
    }


}

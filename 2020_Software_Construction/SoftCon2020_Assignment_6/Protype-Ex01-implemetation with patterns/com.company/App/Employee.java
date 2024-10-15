package App;

import com.company.IDGenerator;

public class Employee {

    private String name;
    private String surname;
    private String address;
    private String telephone;
    private String ID; // a sequence of 8 characters or numbers
    private IDGenerator idGenerator = IDGenerator.getInstance();

    public Employee(String name, String surname, String address, String telephone) {
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
    public String getSurname() {
        return surname;
    }
    public String getAddress() {
        return address;
    }
    public String getTelephone() {
        return telephone;
    }
    public String getID() {
        return ID;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

}

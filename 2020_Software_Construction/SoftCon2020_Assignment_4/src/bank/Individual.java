package bank;

public abstract class Individual {
    private String name;
    private String surname;
    private int ID;
    private roles role;

    IDCounter generateID = IDCounter.getInstance();

    public Individual(String name, String surname) throws IllegalArgumentException{
        if(name == null || surname == null){
            throw new IllegalArgumentException("Name or Surname input is invalid");
        }
        generateID.incrementCounter();
        this.name = name;
        this.surname = surname;
        this.ID = generateID.getNr();

    }

    // getters
    public String getName() {
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public int getID(){
        return ID;
    }
    //public roles getRole(){return role;}

    // setters
    private void setName(String name){
        this.name = name;
    }

    private void setSurname(String surname){
        this.surname = surname;
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public void setRole(roles role){
        this.role = role;
    }

    //Possible Roles an Individual can have
    public enum roles{
        CUSTOMER,EMPLOYE,TECHNICHIAN
    }
}


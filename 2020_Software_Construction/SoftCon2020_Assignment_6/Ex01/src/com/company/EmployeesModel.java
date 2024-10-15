package com.company;


public class EmployeesModel {

    private Employee[] employeesList = new Employee[100];
    private int employeeCounter;

    public EmployeesModel() {
        this.employeeCounter = 0;
    }

    public void createEmployee(String name, String surname, String address, String telephone){

        Employee newEmployee = new Employee(name, surname, address, telephone);

        if(employeeCounter < 100) {
            employeesList[employeeCounter] = newEmployee;
            employeeCounter++;
        }
        else{ System.out.println("Sorry, DB is full!"); }

    }

    public void addEmployee(Employee e){
        if(employeeCounter < 100) {
            employeesList[employeeCounter] = e;
            employeeCounter++;
        }
        else{ System.out.println("Sorry, DB is full!"); }
    }

    public Employee getEmployee(int idx){
        if(employeesList[idx] != null) {
            return employeesList[idx];
        }
        else{ System.out.println("Sorry, couldn't find that person!"); }

        return null;
    }

    public Employee getEmployeeThroughID(String ID){
        for(Employee e : employeesList){
            if( e.getID().equals(ID) ){
                return e;
            }
        }
        return null;
    }


//    public String getEmpInfos(int idx) {
//        String infos = "";
//
//        if(employeesList[idx] != null) {
//            infos += employeesList[idx].getName() + " "
//                    + employeesList[idx].getSurname() + " "
//                    + employeesList[idx].getAddress() + " "
//                    + employeesList[idx].getTelephone() + " "
//                    + employeesList[idx].getID();
//        }
//        else{ System.out.println("Sorry, couldn't find that person!"); }
//
//        return infos;
//    }

}

package App.viewStrategies;

import App.Employee;
import App.view.*;

public class EmployeeInfoView implements ViewStrategy {

    MainView mainView = new MainView();

    public EmployeeInfoView(Employee employee){

        Attributes att_name = new Attributes("1) Name: " + employee.getName());
        Attributes att_surname = new Attributes("2) Surname: " + employee.getSurname());
        Attributes att_ID = new Attributes("ID: TODO" + employee.getID());

        mainView.addToView(att_name);
        mainView.addToView(att_surname);
        mainView.addToView(att_ID);

    }

    @Override
    public void display() {
        this.mainView.display();
    }

}

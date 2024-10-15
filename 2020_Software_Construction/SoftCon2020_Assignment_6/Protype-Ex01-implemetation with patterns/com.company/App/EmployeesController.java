package App;

import App.view.*;
import App.viewStrategies.*;
import com.sun.tools.javac.Main;

public class EmployeesController {

    private MainView theView;
    private EmployeesModel theModel;

    public EmployeesController(MainView theView, EmployeesModel theModel) {
        this.theView = theView;
        this.theModel = theModel;
    }

    ////////////////////////////////////
    ////// Model related methods////////
    ////////////////////////////////////

    public void addEmployee(){}

    public Employee getEmployee(int idx){
        return null; // TODO
    }

    public void updateAddress(){}

    public void updateTelephone(){}

    ////////////////////////////////////
    ////// View related methods ////////
    ////////////////////////////////////
    // Strategy
    public void updateView(ViewStrategy viewStrategy){
        viewStrategy.display();
    }


}

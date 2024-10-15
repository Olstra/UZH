package App;

import App.view.MainView;
import App.viewStrategies.AddView;
import App.viewStrategies.EmployeeInfoView;

public class MVCPatternDemo {

    public static void main(String[] args) {

        // initialize objects
        MainView theView = new MainView();
        EmployeesModel model = new EmployeesModel();
        EmployeesController controller = new EmployeesController(theView, model);

        // Strategies for view
        AddView addView = new AddView();
        controller.updateView(addView);

        // create a new employee //
        controller.addEmployee();
        // TODO get user input

        // Print the employee name, surname and ID //
        EmployeeInfoView infoView = new EmployeeInfoView(controller.getEmployee(0));
        controller.updateView(infoView);

        // Update the employee address //
        controller.updateAddress();

        // Print the new address //
        controller.updateView(infoView);

        // Update the employee phone number //
        controller.updateTelephone();

        // Print the new phone number //
        controller.updateView(infoView);

        // Would simulate input as soon as it works with the console active
        // now it just randomly types Monty Burns where its possible
        try {
            UserSimulator user = new UserSimulator();
        } catch(Exception e ){
            System.out.println("something went wrong");
        }

    }
}

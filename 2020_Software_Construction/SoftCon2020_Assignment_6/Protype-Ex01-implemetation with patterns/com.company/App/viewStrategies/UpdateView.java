package App.viewStrategies;

import App.view.Attributes;
import App.view.*;

public class UpdateView implements ViewStrategy {

    MainView mainView = new MainView();

    public UpdateView(){

        Attributes att_question = new Attributes("Select the information you want to update: ");
        Attributes att_name = new Attributes("1) Name");
        Attributes att_surname = new Attributes("2) Surname");
        Attributes att_address = new Attributes("3) Address");
        Attributes att_phone = new Attributes("4) Telephone");
        Attributes att_ID = new Attributes("ID: TODO");

        mainView.addToView(att_question);
        mainView.addToView(att_name);
        mainView.addToView(att_surname);
        mainView.addToView(att_address);
        mainView.addToView(att_phone);
        mainView.addToView(att_ID);

    }

    @Override
    public void display() {
        this.mainView.display();
    }
}

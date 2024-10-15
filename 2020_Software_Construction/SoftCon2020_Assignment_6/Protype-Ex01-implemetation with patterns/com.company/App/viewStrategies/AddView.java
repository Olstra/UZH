package App.viewStrategies;

import App.view.*;


public class AddView implements ViewStrategy {

    MainView mainView = new MainView();

    public AddView(){

        Attributes att_name = new Attributes("1) Name: ");
        Attributes att_surname = new Attributes("2) Surname: ");
        Attributes att_address = new Attributes("3) Address: ");
        Attributes att_phone = new Attributes("4) Telephone: ");
        Attributes att_ID = new Attributes("ID: TODO");

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

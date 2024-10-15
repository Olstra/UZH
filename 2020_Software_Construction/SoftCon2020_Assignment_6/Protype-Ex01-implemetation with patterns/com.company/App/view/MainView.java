package App.view;

import java.util.ArrayList;

public class MainView extends ViewComponent{

    //public String text;
    public ArrayList<ViewComponent> viewItems = new ArrayList<>();

    public MainView(){
        this.text = "PLEASE SET TEXT";
    }

    public void display(){
        String consoleTxt = "";

        for(ViewComponent c : viewItems){
            consoleTxt += "\n" + c.getText();
        }

        System.out.println(consoleTxt);
    }

    //public String getText(){ return this.text; }

    public void addToView(ViewComponent newViewComponent){
        this.viewItems.add(newViewComponent);
    }

}

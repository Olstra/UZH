package bakery;

import bakery.cake.*;
import bakery.sandwich.*;

import java.util.Scanner;


public class BakeryNormal extends Bakery {


    public BakeryNormal(String name, String address) {
        super(name, address);
    }


    /**
     * Let's a customer order a sandwich with as many toppings as they want.
     * Final price ist then printed to the console.
     * Selection through nrs input.
     *
     * */
    @Override
    public void orderSandwich(){
        // create new sandiwch
        Sandwich sandwich = new Sandwich();

        Scanner userInput = new Scanner(System.in);
        int choice = 0;
        double cost = sandwich.cost();

        do {
            // add as many toppings as one wants
            System.out.println("What topping do you want? (type in number):\n1) Tomato\n2) Tuna\n3) Ham\n4) Cheese\n5) Finish order");
            choice = userInput.nextInt();

            switch (choice){
                case 1:
                    sandwich = new Tomatoes(sandwich);
                    break;
                case 2:
                    sandwich = new Tuna(sandwich);
                    break;
                case 3:
                    sandwich = new Ham(sandwich);
                    break;
                case 4:
                    sandwich = new Cheese(sandwich);
                    break;
                default: break;
            }
        }while(choice != 5);

        // print the price of the sandwich for customer
        System.out.println( sandwich.cost());
    }

    /**
     * Let's a customer order a cake with as many toppings as they want.
     * Final price ist then printed to the console.
     * Selection through nrs input.
     *
     * */
    @Override
    public void orderSweets() {
        // create new cake
        Cake cake = new Cake();

        Scanner userInput = new Scanner(System.in);
        int choice = 0;


        do {
            // add as many toppings as one wants
            System.out.println("What topping do you want? (type in number):\n1) Chocolate\n2) Cream\n3) Strawberries\n4) Finish order");
            choice = userInput.nextInt();

            switch (choice){
                case 1:
                    cake = new Chocolate(cake);
                    break;
                case 2:
                    cake = new Cream(cake);
                    break;
                case 3:
                    cake = new Strawberries(cake);
                    break;
                default: break;
            }
        }while(choice != 4);

        // print the price of the cake for customer
        System.out.println( cake.cost());

    }

}

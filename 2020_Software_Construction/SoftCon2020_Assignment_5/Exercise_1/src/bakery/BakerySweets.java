package bakery;

import bakery.cake.*;
import bakery.sandwich.*;

import java.util.Scanner;


public class BakerySweets extends Bakery {

    public BakerySweets(String name, String address) {
        super(name, address);
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
        double cost = cake.cost();

        do {
            // add as many toppings as one wants
            System.out.println("What topping do you want? (type in number):\n1) Chocolate\n2) Cream\n3) Strawberries\n4) Finish order");
            choice = userInput.nextInt();

            switch (choice){
                case 1:
                    cost += 2;
                    break;
                case 2:
                    cost += 1.5;
                    break;
                case 3:
                    cost += 1;
                    break;
                default: break;
            }
        }while(choice != 4);

        // print the price of the sandwich for customer
        System.out.println( String.valueOf(cost) );

    }
}

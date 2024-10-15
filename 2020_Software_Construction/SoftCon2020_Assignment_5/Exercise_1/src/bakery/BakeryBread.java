package bakery;

import bakery.sandwich.Sandwich;

import java.util.Scanner;

public class BakeryBread extends Bakery {

    public BakeryBread(String name, String address) {
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
                    cost += 1.5;
                    break;
                case 2:
                    cost += 3;
                    break;
                case 3:
                    cost += 2;
                    break;
                case 4:
                    cost += 1;
                    break;
                default: break;
            }
        }while(choice != 5);

        // print the price of the sandwich for customer
        System.out.println( String.valueOf(cost) );
    }

}

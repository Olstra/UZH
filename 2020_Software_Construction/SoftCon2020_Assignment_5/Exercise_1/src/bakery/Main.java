package bakery;

import bakery.sandwich.Sandwich;

public class Main {

    public static void main(String[] args) {

        BakeryNormal bake = new BakeryNormal("a", "b");

        bake.orderSweets();
        bake.orderSandwich();



    }
}
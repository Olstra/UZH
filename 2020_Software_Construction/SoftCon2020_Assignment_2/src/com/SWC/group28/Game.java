package com.SWC.group28;


import java.util.Scanner;

public class Game {

    private final int totalBoats = 10;
    Boat[] fleet = new Boat[totalBoats];
    private Board board = new Board();

    Game() {

        // create fleet, 10 boats total
        // 1 carrier
        this.fleet[0] = new Carrier();
        // 2 battleships
        this.fleet[1] = new Battleship();
        this.fleet[2] = new Battleship();
        // 3 submarines
        this.fleet[3] = new Submarine();
        this.fleet[4] = new Submarine();
        this.fleet[5] = new Submarine();
        // 4 patrol boats
        this.fleet[6] = new PatrolBoat();
        this.fleet[7] = new PatrolBoat();
        this.fleet[8] = new PatrolBoat();
        this.fleet[9] = new PatrolBoat();

        System.out.println("Welcome to Battleship!!");
        Scanner playerInput = new Scanner(System.in);
        String position = "";
        boolean validInput = false;

        // get coordinates of ships
        for (int i = 0; i < this.totalBoats; i++) {

            while(!validInput) {
                System.out.println("Please enter the position of your " + this.fleet[i].getName() + ": ");
                position = playerInput.nextLine();
                if( isValid(position, this.fleet[i].getSize()) ) { validInput = true; }
                else { System.out.println("The specified input is invalid"); }
            }

            this.fleet[i].setPosition(position);
            board.placeBoat(this.fleet[i]); // place the boat onto the board
            validInput = false; // reset for next iteration
            position = ""; // reset position for next pos input
        }
        // display the board after all inputs were filled correctly
        System.out.println("Your Board is: \n");
        board.showBoard();
    }

    public boolean isValid(String position, int boatSize) {
        return checkLenOfInput(position) && checkInputRespectsBoatSize(position, boatSize) && checkBoatsOverlapping(position) ;
    }


    // wrong length of input 0...n (e.g. no input was given, too many chars...)
    public boolean checkLenOfInput(String position) {
        if (position.length() == 5 && ('A' <= position.charAt(0) && position.charAt(0) <= 'J')
                && ('0' <= position.charAt(1) && position.charAt(1) <= '9')
                && ('A' <= position.charAt(3) && position.charAt(3) <= 'J')
                && ('0' <= position.charAt(4) && position.charAt(4) <= '9')){
            return true;
        } else {
            return false;}
    }


    public boolean checkBoatsOverlapping(String position) {
        //checks if there is already a boat at the preferred position.
        //returns false if a field is already full
        return board.boatOverlaps(position) ;
    }


    public boolean checkInputRespectsBoatSize(String position, int boatSize) {
        // check if boat is aligned vertically or horizontally
        // if the boat is aligned vertically, it means the letters/columns are the same
        // e.g. "A2 A5" -> check if (5 - 2) == boat.size
        // note: no need to check other validations inside this method
        // since "isValid()" will only return true, if ALL checks are true
        char start = ' ';
        char end = ' ';

        if ( boatAlignment(position).equals("vertical") ) {
            start = position.charAt(1);
            end = position.charAt(4);
        }
        else if ( boatAlignment(position).equals("horizontal") ) {
            // the boat is aligned horizontally:
            // "B4 E4" -> check if 'B'-'E' == boat.size
            start = position.charAt(0);
            end = position.charAt(3);
        }
        else { return false; }

        if ( (end-start)+1 == boatSize) { return true; }

        // all other cases should return false
        return false;
    }

    public String boatAlignment(String position) {

        if (position.charAt(1) == position.charAt(4)) { return "horizontal"; }
        else if (position.charAt(0) == position.charAt(3)) { return "vertical"; }

        return "wrong";
    }

}

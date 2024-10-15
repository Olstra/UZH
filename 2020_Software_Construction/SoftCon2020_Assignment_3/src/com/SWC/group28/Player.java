package com.SWC.group28;

import java.util.Scanner;

public class Player {

    // contains the players board
    // and the opponents board (from the players perspective)
    // keeps track of player remaining boats

    Board board = new Board();
    Board enemyBoard = new Board();

    Player(){
    }

    public void attack(String attackCoordinates, Enemy enemy) {

        //char charBeforeAttack = this.enemyBoard.getChar(attackCoordinates);

        char charBeforeAttack = enemy.personalBoard.getChar(attackCoordinates);
        char charAfterAttack;

        if (charBeforeAttack == 0) {
            System.out.println("Miss");
            charAfterAttack = 'O';
        }
        else if(charBeforeAttack == 'X' || charBeforeAttack == 'O'){
            System.out.println("You already tried that...");
            charAfterAttack = charBeforeAttack;
        }
        else{
            System.out.println("You hit a boat!");
            charAfterAttack = 'X';
        }

        // update enemy's board and player's enemy board
        enemy.personalBoard.setChar(attackCoordinates, charAfterAttack);
        this.enemyBoard.setChar(attackCoordinates, charAfterAttack);

    }

    public String getAttackCoordinates() {

        boolean validInput = false;
        String position = "";
        Scanner playerInput = new Scanner(System.in);
        String message = "\nEnter the position you want to attack:";
        char bbb;

        while (!validInput) {
            System.out.println(message);
            position = playerInput.nextLine();

            // check coordinates are inside board
            if (position.length() == 2 && ('A' <= position.charAt(0) && position.charAt(0) <= 'J')
                    && ('0' <= position.charAt(1) && position.charAt(1) <= '9')) {
                // check that position was not attacked before
                bbb = this.enemyBoard.getChar(position);
                if(bbb != 'O' || bbb != 'X') {
                    validInput = true;
                }
            } else {
                System.out.println("The specified input is invalid");
            }
        }

        return position;
    }




}

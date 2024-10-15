package com.SWC.group28;


import java.util.Scanner;

public class Game {

    private final int totalBoats = 10;
    Boat[] fleet = new Boat[totalBoats];
    private Board board = new Board();
    private boolean isOver;

    Player player = new Player();
    Enemy enemy;

    CurrentScoreboard scoreBoard = new CurrentScoreboard();

    Game() {
        // init the game (at the moment no separate init method is needed, since the game is only run once)

        // set game over variable to false
        this.isOver = false;

        // init scoreboard player boats = 9, destroyed boats = 0
        this.scoreBoard.update(9, 0);

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

        // get coordinates for ships positions
        System.out.println("Welcome to Battleship!!");
        Scanner playerInput = new Scanner(System.in);
        String position = "";

        // get user input for coordinates
        for (int i = 0; i < this.totalBoats; i++) {
            position = this.getBoatPosition(this.fleet[i]);
            this.fleet[i].setPosition(position);
            player.board.placeBoat(this.fleet[i]); // place the boat onto the board
        }

        enemy = new Enemy();

    }


    public void playTheGame() {

        while (!this.isOver) {

            // display boards
            System.out.println("Your board is:\n");
            player.board.showBoard();

            System.out.println("\nYour opponent's board is:\n");
            player.enemyBoard.showBoard();

            // display current score board
            this.scoreBoard.displayScoreboard();

            // player attacks
            player.attack( player.getAttackCoordinates(), enemy );

            // computer attacks
            enemy.attack( enemy.enemyAttack(), player.board);

            // check for game over
            if (this.scoreBoard.PlayerRemainingBoats <= 0){
                System.out.println("Sorry, you lost!");
                this.isOver = true;
            }
            else if (this.scoreBoard.EnemyBoatsDestroyed >= 9) {
                System.out.println("Congratulations, you won!");
                this.isOver = true;
            }

        }
    }

    public String getBoatPosition(Boat boat) {
        boolean validInput = false;
        String position = "";
        Scanner playerInput = new Scanner(System.in);

        while(!validInput) {
            System.out.println("Please enter the position of your " + boat.getName() + ": ");
            position = playerInput.nextLine();

            if( board.isValid(position, boat.getSize()) ) {
                validInput = true;
            }
            else {
                System.out.println("The specified input is invalid");
            }
        }

        return position;
    }



}

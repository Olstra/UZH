### Assignment 03
### Software Construction HS20
### Group 28: Julia Kostadinova, Madison Montgomery, Oliver Strassmann

### Exercise 3 pattern implementations

**Singleton**: We used the singleton pattern in the class SubmarineCounter to avoid multiple counter instances for submarines. We created a class for the SubmarineCounter that uses a private static constructor to restrict the instantiation of the counter from other classes and a public static method that returns the instance of the class for other classes to retrieve.  

**Observer**: We used the observer pattern for the implementation of the Scoreboard. We created Subject and Observer interfaces to implement the pattern and ScoreboardData and CurrentScoreboard classes to gather the data on changes to the Subject, and communicate the changes to the observer class (CurrentScoreboard). We chose this pattern for the scoreboard because the scoreboard would need to keep track of state changes for both the computer and the player's ship count and need to be updated continually after each turn.

**Iterator**: We used the iterator pattern to access elements of the Fleet class. We created a FleetIterator that accesses elements from the Fleet class for the Enemy class to use when instantiating the enemy fleet. We used this pattern to give the Enemy class the ability to create a fleet without giving it direct access to the details of the fleet collection.


! IMPORTANT NOTE:  
- the "attack" method of the player's and enemy's class are not quite finished yet. Here is an excerpt of the work in progress code:
-> this means the count of the sunken ships (+ the ckeck for game over in the game class) does not work yet.
-> the idea for this method was:
- every boat stores information on every single cell (their coordinates) it occupies
- when an attack occurs, we iterate through the player's/enemy's fleet and find out which boat was hit "if (attackCoordinates.equals(enemy.fleet[1].occupiedCells[i])"
- in the switch statement we find out which boat was hit
- afterwards we reduce 1 live from that boat "attackedBoat.lives--;"

```java
    public void attack(String attackCoordinates, Enemy enemy) {

        //char charBeforeAttack = this.enemyBoard.getChar(attackCoordinates);

        char charBeforeAttack = enemy.personalBoard.getChar(attackCoordinates);
        char charAfterAttack;
        Boat attackedBoat;

        if (charBeforeAttack == 0) {
            System.out.println("Miss");
            charAfterAttack = 'O';
        }
        else{
            switch (charBeforeAttack) {
                case 'B': // Battleship, can be either fleet[1] or fleet[2]
                    // check if coordinates is in fleet[1]
                    for(int i = 0; i < 4; i++) {
                        if (attackCoordinates.equals(enemy.fleet[1].occupiedCells[i])){
                            attackedBoat = enemy.fleet[1];
                            break;
                        }
                        else{ attackedBoat = enemy.fleet[2]; }
                    }
                    break;
                case 'C': // carrier = fleet[0]
                    attackedBoat = enemy.fleet[0];
                    break;
                case 'P':
                    break;
                case 'S':
                    break;
                default:
                    break;
            }
            attackedBoat.lives--;
            if(attackedBoat.lives <= 0) {
                System.out.println("You destroyed a " + attackedBoat.getName());
            }
            else{
                System.out.println("You hit a boat!");
            }
            charAfterAttack = 'X';
        }

        // update enemy's board and player's enemy board
        theEnemyBoard.setChar(attackCoordinates, charAfterAttack);
        // get boat
        //Boat attackedBoat = theEnemyBoard.get

        this.enemyBoard.setChar(attackCoordinates, charAfterAttack);

    }   
```

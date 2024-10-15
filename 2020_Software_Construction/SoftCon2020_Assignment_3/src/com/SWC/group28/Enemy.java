package com.SWC.group28;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Enemy {

    public Board personalBoard = new Board();
    public Board opponentsBoard = new Board();
    private char[] letterCoordinates = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    public Fleet fleet = new Fleet();

    // only the Board that is supposed to be played on
    // will need some sort way access boats

    public Enemy(){
        placeFleet();
    }

    private void placeFleet() {
        Iterator<Boat> boats = fleet.iterator();
        while(boats.hasNext()) {
          Boat current = boats.next();
            this.generatePosition(current);
            this.personalBoard.placeBoat(current);
        }
    }

    private void generatePosition(Boat boat) {

        int moveFields = boat.getSize() - 1;
        String startInput = generateCoordinate();
        String[] inputCandidates = new String[4];
        ArrayList<String> acceptableCandidates = new ArrayList<>();
        inputCandidates[0] = startInput + " " + permutateCoordinate(startInput, 0, moveFields);
        inputCandidates[1] = startInput + " " + permutateCoordinate(startInput, 0, -moveFields);
        inputCandidates[2] = startInput + " " + permutateCoordinate(startInput, moveFields, 0);
        inputCandidates[3] = startInput + " " + permutateCoordinate(startInput, -moveFields, 0);
        for (String possiblePosition : inputCandidates) {
            if (personalBoard.isValid( possiblePosition, boat.getSize())) {
                acceptableCandidates.add(possiblePosition);
            }
        }
        // select one position of the possible ones and set the boat if "possiblePosition" is nonempty
        int randomConstraint = acceptableCandidates.size();
        if (randomConstraint == 0) {
            generatePosition(boat);
        } else {
            Random random = new Random();
            boat.setPosition(acceptableCandidates.get(random.nextInt(randomConstraint)));

        }
    }

    // calls an attack
    public String enemyAttack() {
        // due to the nature of generate Coordinate the coordinate will always be in the field
        String potentialPosition = this.generateCoordinate();
        char fieldCoordinateBefore = this.opponentsBoard.getChar(potentialPosition);
        char fieldCoordinateAfter;
        if(fieldCoordinateBefore == 0){
          opponentsBoard.setChar(potentialPosition,'O');
        } else if(fieldCoordinateBefore == 'X' || fieldCoordinateBefore == 'O'){   // used for enemy attack so it does not attack the same place multiple times

           return enemyAttack();

        } else{
           opponentsBoard.setChar(potentialPosition,'X');
        }
        fieldCoordinateAfter = this.opponentsBoard.getChar(potentialPosition);
        return potentialPosition;
    }

    // possibly used later to make the AI smart.
    // tracks coordinates
//    private String[] tracker(String coordinate) {
//        ArrayList<String> hits = new ArrayList<String>();
//        ArrayList potentialNextHit = new ArrayList();
//        for(String hit : hits){
//            if(opponentsBoard.getChar(hit) != 'X') {
//                hits.remove(hit);
//            }
//            potentialNextHit.add(permutateCoordinate(hits.get(0),+1,0));
//            potentialNextHit.add( permutateCoordinate(hits.get(0),-1,0));
//            potentialNextHit.add(permutateCoordinate(hits.get(0),0,+1));
//            potentialNextHit.add(permutateCoordinate(hits.get(0),0,-1));
//            for (String potentialHit : potentialNextHit){
//                char caracterIdx = potentialHit.charAt(0);
//                int numericIdx = Character.getNumericValue(potentialHit.charAt(1));
//                if( caracterIdx < 'A' || caracterIdx > 'J'){ // checks letters
//                    potentialNextHit.remove(potentialHit);
//            } else if( numericIdx < 0 || numericIdx > 9){   // checks integers
//                    potentialNextHit.remove(potentialHit);
//                }
//
//            }
//        }
//        return null;
//
//    }

    //generates Coordinate
    public String generateCoordinate() {
        Random random = new Random();
        String coordinate = "" + letterCoordinates[random.nextInt(10)] + random.nextInt(10);
        return coordinate;
    }

    //used to permutate a given coordinate
    private String permutateCoordinate(String coordinate, int moveRow, int moveColumn) {
        char column = (char) (coordinate.charAt(0) + moveColumn);
        int row = Character.getNumericValue(coordinate.charAt(1)) + moveRow;

        return "" + column + row;
    }


    public void attack(String attackCoordinates, Board playerBoard) {
        char charBeforeAttack = playerBoard.getChar(attackCoordinates);
        char charAfterAttack;

        System.out.println("The Computer attacks position " + attackCoordinates);

        if (charBeforeAttack == 0) {
            System.out.println("The computer missed");
            charAfterAttack = 'O';
        }
        else{
            System.out.println("Your boat was hit!");
            charAfterAttack = 'X';
        }

        playerBoard.setChar(attackCoordinates, charAfterAttack);

    }


}

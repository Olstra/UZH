package com.SWC.group28;

import static java.lang.Integer.parseInt;

public class Board{

    //Letters is used to translate user input from letters to integers so the input can be used on the array without
    //giving information on the board

    private enum Letters {A(0),B(1),C(2),D(3),E(4),F(5),G(6),H(7),I(8),J(9);
        private int index;

        Letters(int i) {
            this.index = i;
        }
    }

    //NOTE: Class of the arraylist is not definitive, can change to take on other object
    // boards size is fixed as per assignment specifications.
    private final char[][] board = new char [10][10];

    public Board(){}

    //Prints the board. public or private may change
    public void showBoard(){
        System.out.println("   |[A][B][C][D][E][F][G][H][I][J]");
        System.out.println("---|------------------------------");

        // define var outside of loop... otherwise it'll get re-created every iteration
        String concatenation = " ";
        char element = ' ';

        for (int row = 0; row < 10; row++) {
            concatenation = "[" + row + "]|";
            // the problem is board[x] will always be null beacuse of double array?...
            for (int col = 0; col < 10; col++) {
                element = board[row][col];
                // https://stackoverflow.com/questions/21502859/how-can-i-check-if-the-char-array-has-an-empty-cell-so-i-can-print-0-in-it
                if (element == 0) {
                    concatenation += "[ ]";
                } else {
                    concatenation += "[" + element + "]";
                }
            }
            System.out.println(concatenation);
        }



    }

    //fills the board with the boat given
    //left the initial integers for readability

    public void placeBoat(Boat boat){
        // applied IDE recommendation: "replace C style array definition with java style"
        int[] indices = translateCoordinates(boat.getPosition());
        int startColumn = indices[0];
        int endColumn = indices[1];
        int startRow =  indices[2];
        int endRow= indices[3];

        char fillChar = boat.getChar();
        if(startColumn == endColumn){
            for(int rowWalker = startRow;rowWalker <= endRow;rowWalker++){
                board[rowWalker][startColumn]= fillChar;
            }
        } else{
            for(int columnWalker = startColumn;columnWalker<= endColumn;columnWalker++){
                board[startRow][columnWalker] = fillChar;
            }
        }


    }
    //translates the coordinates from the userinput and splits them into the specific indices
    // returns start and endindex of column and start and end index of rows
    private int[] translateCoordinates(String position){
        int[] translatedCoordinates = new int [position.length()];
        String[] singleIndices = new String[position.length()];


        for(int i = 0; i < position.length();i++){
            singleIndices[i]=position.substring(i,i+1);
        }
        translatedCoordinates[0] = Letters.valueOf(singleIndices[0]).index;
        translatedCoordinates[1] = Letters.valueOf(singleIndices[3]).index;
        translatedCoordinates[2] = parseInt(singleIndices[1]);
        translatedCoordinates[3] = parseInt(singleIndices[4]);

        return translatedCoordinates;
    }

    public boolean boatOverlaps(String position){

        int[] placingIndices = translateCoordinates(position);
        int startColumn = placingIndices[0];
        int endColumn = placingIndices[1];
        int startRow = placingIndices[2];
        int endRow = placingIndices[3];

        if(startColumn == endColumn){
            for(int rowWalker = startRow;rowWalker <= endRow; rowWalker++){
                if(board[rowWalker][startColumn] != 0){
                  return false;
                }
            }
        } else{
            for(int columnWalker = startColumn;columnWalker<= endColumn;columnWalker++){
                if(board[startRow][columnWalker] != 0){
                    return false;
                }
            }
        }

        return true;

    }


}

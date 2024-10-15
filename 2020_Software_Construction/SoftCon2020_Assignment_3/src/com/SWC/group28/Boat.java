package com.SWC.group28;



abstract class Boat implements Boats {

    // all boat types should have this attributes
    private int size;
    private String name;
    private char displayedChar;
    private String position;
    public String[] occupiedCells;

    // setter methods
    public void setSize(int size) { this.size = size; }
    public void setName(String name) { this.name = name; }
    public void setChar(char theChar) { this.displayedChar = theChar; }
    public void setPosition(String position) { this.position = position; }

    // getter methods
    public int getSize() { return this.size; }
    public String getName() { return this.name; }
    public char getChar() { return this.displayedChar; }
    public String getPosition() { return this.position; }

//    public void generateOccupiedCells(String position, int size) {
//
//
//        if(this.boatAlignment(position).equals("vertical")){
//            char colLetter = position.charAt(0);
//            for(int i = 0; i < size; i++) {
//                occupiedCells[i] = colLetter + ;
//            }
//            occupiedCells[0] = position.substring(0,2);
//            occupiedCells[1] = position.charAt(0) + String.valueOf(position.charAt(1)+1);
//            occupiedCells[2] = position.substring(3);
//        }
//        else if (this.boatAlignment(position).equals("horizontal")){
//            for(int i = 0; i < size; i++) {
//
//            }
//            occupiedCells[0] = position.substring(0,2);
//            occupiedCells[1] = position.charAt(0) + position.charAt(1);
//            occupiedCells[2] = position.substring(3);
//
//        }
//
//    }
//
//    public String boatAlignment(String position) {
//
//        if (position.charAt(1) == position.charAt(4)) { return "horizontal"; }
//        else if (position.charAt(0) == position.charAt(3)) { return "vertical"; }
//
//        return "wrong";
//    }

}

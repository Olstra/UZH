package com.SWC.group28;



abstract class Boat implements Boats {

    // all boat types should have this attributes
    private int size;
    private String name;
    private char displayedChar;
    private String position;

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

}

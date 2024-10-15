package com.SWC.group28;

public interface Boats {

    //takes on the String containing the coordinates
    //All boats need to have coordinates
    void setPosition(String position);

    //takes on an integer that states how many fields the boat needs.
    //All boats have to specify their size
    void setSize(int size);

    //Returns the assigned position of the boat.
    String getPosition();

    //Returns the amount of fields that a boat uses as an Integer.
    int getSize();
}

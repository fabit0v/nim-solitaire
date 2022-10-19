package com.tlglearning.nim.model;

public class Pile {

    //Fields
    private int removed;
    private int remaining;

    // TODO: 10/18/22 Define constructor that initializes remove to 0 and sets remaining to the value of a parameter

    //Constructor
    public Pile(int removed, int remaining) {
        this.removed = 0;
        this.remaining = remaining;
    }

    // TODO: 10/18/22 Define methods shown in nim-classes.svg as stubs

    //Methods
    public int remove(int quantity) {
        return quantity;
    }

    public boolean isEmpty() {
        return false;
    }


    // TODO: 10/18/22 Generate "getters" (accessors) for removed and remaining
    //Accessors (getter/setter)
    public int getRemoved() {
        return removed;
    }

    public int getRemaining() {
        return remaining;
    }

    // TODO: 10/18/22 Create a test class for Pile
}

package com.tlglearning.nim.model;

public class Pile {

    private static final String BAD_SIZE_FORMAT = "Invalid size: %d; must be non-negative.";
    //Fields
    private int removed;
    private int remaining;

    // DONE: 10/18/22 Define constructor that initializes remove to 0 and sets remaining to the value of a parameter

    //Constructor
//    public Pile(int removed, int remaining) {
//        this.removed = 0;
//        this.remaining = remaining;
//    }

    public Pile(int size) throws IllegalArgumentException {
        if (size < 0){
            throw  new IllegalArgumentException(String.format(BAD_SIZE_FORMAT, size));
        }
        removed = 0;
        remaining = size;
    }

    // DONE: 10/18/22 Define methods shown in nim-classes.svg as stubs

    //Methods
    public int remove(int quantity) throws IllegalArgumentException {
        if (quantity > remaining) {
            throw new IllegalArgumentException("Quantity to remove must not exceed quantity remaining");
        }
        removed += quantity;
        remaining -= quantity;
        return remaining;
    }

    public boolean isEmpty() { // DONE: implement logic
        return remaining == 0; //boolean expression (true/false)
    }


    // DONE: 10/18/22 Generate "getters" (accessors) for removed and remaining
    //Accessors (getter/setter)
    public int getRemoved() {
        return removed;
    }

    public int getRemaining() {
        return remaining;
    }

    // DONE: 10/18/22 Create a test class for Pile


    @Override
    public String toString() {
        return "Pile{" +
                "removed=" + removed +
                ", remaining=" + remaining +
                '}';
//        public
//        return String.format("Pile{removed=%d, remaining=%d}", removed, remaining);
    }
}



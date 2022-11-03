package com.tlglearning.nim.model;

import java.util.LinkedList;
import java.util.List;

public class Game {

    private List<Pile> piles;
    private State state;

    // DONE: 10/25/22 implement to create list of pile
    public Game(State state, int[] pileSizes) throws IllegalArgumentException {
        if (state.isTerminal()) {
            throw new IllegalArgumentException("game must start in non-terminal state");
        }
        List<Pile> piles = new LinkedList<>();
        for (int size : pileSizes) {
            piles.add(new Pile(size));
        }
        this.piles = piles;
        this.state = isFinished() ? state.nextMoveState().nextWinState() : state;
    }

    // DONE: 10/25/22 Implement to remove specified quantity from specified pile, and update State
    public void play(Pile pile, int quantity) throws IllegalArgumentException {
        if (state.isTerminal()){
            throw new IllegalStateException("Game already finished");
        }

        pile.remove(quantity);
        //ternary operator -boolean condition. if x ? x is true, then : (condition)
        state = isFinished() ? state.nextWinState() : state.nextMoveState();
//        if (isFinished()) {
//            state = state.nextWinState();
//
//        } else {
//            state = state.nextMoveState();
//        }
    }

    // DONE: 10/25/22 Checks all piles and return true if all are empty
    public boolean isFinished() {
        return piles.stream().allMatch(Pile::isEmpty);
    }

    // DONE: 10/25/22 Create getter/setter for piles and state
    public List<Pile> getPiles() {
        return piles;
    }

    public void setPiles(List<Pile> piles) {
        this.piles = piles;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }



    public static class Pile {

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



    public enum State {

        PLAYER1_MOVE {
            @Override
            public boolean isTerminal() {
                return false;
            }

            @Override
            public State nextMoveState() {
                return PLAYER2_MOVE;
            }

            @Override
            public State nextWinState() {
                return PLAYER1_WIN;
            }
        },
        PLAYER2_MOVE{
            @Override
            public boolean isTerminal() {
                return false;
            }

            @Override
            public State nextMoveState() {
                return PLAYER1_MOVE;
            }

            @Override
            public State nextWinState() {
                return PLAYER2_WIN;
            }
        },
        PLAYER1_WIN,
        PLAYER2_WIN;

        public boolean isTerminal() {
            return true;
        }

        public State nextMoveState() {
            return this;
        }

        public State nextWinState() {
            return this;
        }
    }
}

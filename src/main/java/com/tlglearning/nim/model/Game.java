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

    // TODO: 10/25/22 Implement to remove specified quantity from specified pile, and update State 
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
}

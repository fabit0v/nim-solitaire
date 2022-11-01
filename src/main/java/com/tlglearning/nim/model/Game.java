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
        if (isFinished()) {
            this.state = state.nextWinState(); //TODO: Explore whether this should be allowed
        }
    }

    // TODO: 10/25/22 Implement to remove specified quantity from specified pile, and update State 
    public void play(Pile pile, int quantity) throws IllegalArgumentException {
        if (isFinished()) {
            pile.remove(quantity);

        } else {
            state.nextMoveState();
        }

        throw new UnsupportedOperationException("not yet implemented");
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

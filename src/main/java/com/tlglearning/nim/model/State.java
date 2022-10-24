package com.tlglearning.nim.model;

//DONE: Implement Enum class with values and methods from svg diagram

public enum State {

    PLAYER2_MOVE,
    PLAYER1_MOVE,
    PLAYER1_WIN,
    PLAYER2_WIN;

    private boolean isTerminal() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void nextMoveState() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void nextWinState() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}

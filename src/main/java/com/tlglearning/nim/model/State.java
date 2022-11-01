package com.tlglearning.nim.model;

//DONE: Implement Enum class with values and methods from svg diagram

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

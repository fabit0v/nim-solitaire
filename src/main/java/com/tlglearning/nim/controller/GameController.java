package com.tlglearning.nim.controller;

import com.tlglearning.nim.model.Game;
import com.tlglearning.nim.model.Game.State;
import com.tlglearning.nim.view.GameView;

public class GameController {

    //private final Game game = new Game();
    private final GameView view = new GameView();

    public GameController(State initialState, int[] pileSizes) {
        //this.game = new Game();
        //view = new GameView();
    }
}

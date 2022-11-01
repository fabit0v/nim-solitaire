package com.tlglearning.nim.view;

import com.tlglearning.nim.model.Game;
import com.tlglearning.nim.model.Pile;

import java.util.function.Function;
import java.util.stream.Collectors;

class GameView {

    public String toString(Game game){
        //TODO: include state of the game in output
        PileView pileView = new PileView();
        return game.getPiles()
                .stream()
                .map(pileView::toString)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}

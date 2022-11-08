package com.tlglearning.nim.view;

import com.tlglearning.nim.model.Game;
import com.tlglearning.nim.model.Game.Pile;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GameView {

    private static final String PILE_SEPARATOR = System.lineSeparator().repeat(2);

    public String toString(Game game) {
        //TODO: include state of the game in output
        PileView pileView = new PileView();
        List<Pile> piles = game.getPiles();
        Iterator<Pile> iterator = piles.iterator();
        return Stream.concat(
                        IntStream
                                .rangeClosed(1, piles.size())
                                .mapToObj((num) -> String.format("%d: %s", num, pileView.toString(iterator.next()))),
                        Stream.of(game.getState().toString())
                )
                .collect(Collectors.joining(PILE_SEPARATOR));
    }

    public static class PileView {
        private final String REMAINING = "\u2503";
        private final String REMOVED = "\u2542";

        // DONE: 10/20/22 Construct and return a string using a combination of chars showing removed and remaining in pile
        public String toString(Pile pile) {
            return REMOVED.repeat(pile.getRemoved()) + " " + REMAINING.repeat(pile.getRemaining());


        }
    }
}

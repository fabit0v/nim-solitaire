package com.tlglearning.nim.view;

import com.tlglearning.nim.model.Pile;

public class PileView {
    private final String REMAINING = "\u2503";
    private final String REMOVED = "\u2542";

    // TODO: 10/20/22 Construct and return a string using a combination of chars showing removed and remaining in pile
    public String toString(Pile pile) {
        return REMOVED.repeat(pile.getRemoved()) + " " + REMAINING.repeat(pile.getRemaining());



    }
}

package com.tlglearning.nim.view;

import com.tlglearning.nim.model.Pile;

public class PileView {
    //private final char remaining = '\u2503';
    //private final char removed = '\u2542';

    // TODO: 10/20/22 Construct and return a string using a combination of chars showing removed and remaining in pile
    public String toString(Pile pile) {
        PileView v = new PileView();
        Pile p = new Pile(7- 2);
        char removed = '\u2542';
        char remaining = '\u2503';
        v.toString(p);

        //v.toString(pile);
        throw new UnsupportedOperationException("not yet implemented");
   //look up (unicode) unit code line drawing chars
    }
}

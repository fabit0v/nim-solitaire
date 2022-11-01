package com.tlglearning.nim.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class PileTest {

    @Test
    void constructor_valid(){
        assertThrows(IllegalArgumentException.class, () -> new Pile(10));
    }

    @Test
        //DONE: implement tests (with valid and invalid inputs) for remove
    void remove_valid() {
        Pile pile = new Pile(10); //give size of 10
        pile.remove(3); //remove 3
        assertEquals(3, pile.getRemoved()); // 3 got REMOVED
        assertEquals(7, pile.getRemaining()); // 7 is the remainder
    }

    @Test
    void remove_invalid() {
        Pile pile = new Pile(10);

        assertThrows(IllegalArgumentException.class, () -> { //Lambda, same as below
            pile.remove(11);
        });
//        assertThrows(IllegalArgumentException.class, new Executable() { //create instance of anonymous class
//            @Override
//            public void execute() throws Throwable { //class that creates executable method for illegal-Arg exception
//                pile.remove(11);
//            }
//        });
    }

    //DONE: 10/20/22 implement tests (with expected return values of true and false) for empty method of pile class
    @Test
    void isEmpty() {
        Pile pile = new Pile(10);
        pile.remove(10);
        assertTrue(pile.isEmpty());

        //fail("Test not yet implemented"); //***create empty true and empty false tests
        //pile of 10, remove 10. isempty = true. pile of 10, remove 3. isempty = false
    }

    @Test
    void isNotEmpty() {
        Pile pile = new Pile(10);
        pile.remove(5);
        assertFalse(pile.isEmpty());

    }
}
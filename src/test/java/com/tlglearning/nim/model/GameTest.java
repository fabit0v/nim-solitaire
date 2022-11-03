package com.tlglearning.nim.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {


    // DONE: 10/25/22 Create test class for Game, with methods to test consrtuctor, methods, and isfinished

    @Test
    void constructor_badState() {
        assertThrows(IllegalArgumentException.class,
                () -> new Game(Game.State.PLAYER1_WIN, new int[]{3, 5, 7}));
    }

    @Test
    void constructor_badPileSizes() {
        assertThrows(IllegalArgumentException.class,
                () -> new Game(Game.State.PLAYER1_MOVE, new int[]{-3, 5, 7}));
    }

    @Test
    void play_valid() {
        Game game = new Game(Game.State.PLAYER1_MOVE, new int[]{3, 5, 7});
        Game.Pile pile = game.getPiles().get(0);
        game.play(pile, pile.getRemaining());
        assertTrue(pile.isEmpty());
    }

    @Test
    void play_Invalid() {
        Game game = new Game(Game.State.PLAYER1_MOVE, new int[]{1, 2, 3});
        Game.Pile pile = game.getPiles().get(0);
        assertThrows(IllegalArgumentException.class,
                () -> game.play(pile, pile.getRemaining() + 1));
    }

    @Test
    void play_alreadyFinished() {
        Game game = new Game(Game.State.PLAYER1_MOVE, new int[]{3, 5, 7});
        for (Game.Pile pile : game.getPiles()) {
            game.play(pile, pile.getRemaining());
        }
        assertThrows(IllegalStateException.class,
                () -> game.play(game.getPiles().get(0), 1));
    }

    @Test
    void isFinished_some() {
        Game game = new Game(Game.State.PLAYER1_MOVE, new int[]{3, 5, 7});
        for (Game.Pile pile : game.getPiles()) {
            game.play(pile, pile.getRemaining() - 1);
        }
        assertFalse(game.isFinished());
    }

    @Test
    void isFinished_none() {
        Game game = new Game(Game.State.PLAYER1_MOVE, new int[]{3, 5, 7});
        for (Game.Pile pile : game.getPiles()) {
            game.play(pile, pile.getRemaining());
        }
        assertTrue(game.isFinished());
    }


    @DisplayName("GameTest.PileTest")
    static class PileTest {

        @Test
        void constructor_valid(){
            assertThrows(IllegalArgumentException.class, () -> new Game.Pile(-1));
        }

        @Test
            //DONE: implement tests (with valid and invalid inputs) for remove
        void remove_valid() {
            Game.Pile pile = new Game.Pile(10); //give size of 10
            pile.remove(3); //remove 3
            assertEquals(3, pile.getRemoved()); // 3 got REMOVED
            assertEquals(7, pile.getRemaining()); // 7 is the remainder
        }

        @Test
        void remove_invalid() {
            Game.Pile pile = new Game.Pile(10);

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
            Game.Pile pile = new Game.Pile(10);
            pile.remove(10);
            assertTrue(pile.isEmpty());

            //fail("Test not yet implemented"); //***create empty true and empty false tests
            //pile of 10, remove 10. isempty = true. pile of 10, remove 3. isempty = false
        }

        @Test
        void isNotEmpty() {
            Game.Pile pile = new Game.Pile(10);
            pile.remove(5);
            assertFalse(pile.isEmpty());

        }
    }
}
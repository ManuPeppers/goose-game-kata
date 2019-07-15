package main;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GooseGameTest {

    private GooseGame gooseGame;

    @Before
    public void setUp() throws Exception {
        gooseGame = new GooseGame();
    }


    @Test
    public void addOnePlayer(){

        gooseGame.addPlayer("add player Pippo");
        assertEquals("players: Pippo",gooseGame.exctractPartecipants());
    }

    @Test
    public void addTwoPlayers(){

        gooseGame.addPlayer("add player Pippo");
        gooseGame.addPlayer("add player Pluto");

        assertEquals("players: Pippo, Pluto",gooseGame.exctractPartecipants());
    }

    @Test
    public void verifyingIfPlayerExists(){

        gooseGame.addPlayer("add player Pippo");

        assertEquals("Pippo: already existing player",gooseGame.addPlayer("add player Pippo"));
    }

    @Test
    public void throwDices(){

        assertEquals("Pippo rolls 4, 2. Pippo moves from Start to 6",
                                  gooseGame.throwDices("move Pippo 4, 2"));
    }

    @Test
    public void throwDicesByAnotherPlayer(){
        assertEquals("Pluto rolls 7, 5. Pluto moves from Start to 12",
                                   gooseGame.throwDices("move Pluto 7, 5"));

    }

    @Test
    public void throwDicesTwoTimesAndSumPositions(){
        gooseGame.throwDices("move Pippo 3, 2");
        gooseGame.throwDices("move Pippo 3, 2");

        assertEquals("Pippo rolls 7, 5. Pippo" + " moves from 10 to 22",
                gooseGame.throwDices("move Pippo 7, 5"));
    }

    @Test
    public void throwDicesTwoPlayersAndMaintainPosition(){

        gooseGame.throwDices("move Pippo 3, 2");
        gooseGame.throwDices("move Pluto 3, 2");

        assertEquals("Pippo rolls 7, 5. Pippo" + " moves from 5 to 12",
                gooseGame.throwDices("move Pippo 7, 5"));

    }
}

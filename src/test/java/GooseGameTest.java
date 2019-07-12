import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GooseGameTest {

    GooseGame gooseGame;

    @Before
    public void setUp() {
        gooseGame = new GooseGame();
    }

    @Test
    public void insertOnePlayer() {
        gooseGame.addPlayer("add player Pippo");

        assertEquals("players: Pippo", gooseGame.extractParticipants());
    }

    @Test
    public void insertTwoPlayers() {
        gooseGame.addPlayer("add player Pippo");
        gooseGame.addPlayer("add player Pluto");

        assertEquals("players: Pippo, Pluto", gooseGame.extractParticipants());
    }

    @Test
    public void shouldReturnErrorIfPlayerAlreadyExists() {
        gooseGame.addPlayer("add player Pippo");

        assertEquals("Pippo: already existing player", gooseGame.addPlayer("add player Pippo"));
    }

    @Test
    public void movePlayer(){
        gooseGame.addPlayer("add player Pippo");

        assertEquals("Pippo rolls 4, 2. Pippo moves from Start to 6.", gooseGame.movePlayer("move Pippo 4, 2"));
    }
    @Test
    public void movePlayerAndWin(){
        gooseGame.addPlayer("add player Pippo");
        gooseGame.movePlayer("move Pippo 60, 0");
        assertEquals("Pippo rolls 1, 2. Pippo moves from 60 to 63. Pippo Wins!!", gooseGame.movePlayer("move Pippo 1, 2"));
    }

    @Test
    public void movePlayerAndBounce(){
        gooseGame.addPlayer("add player Pippo");
        gooseGame.movePlayer("move Pippo 60, 0");
        assertEquals("Pippo rolls 3, 2. Pippo moves from 60 to 63. Pippo bounces! Pippo returns to 61", gooseGame.movePlayer("move Pippo 3, 2"));
    }

    @Test
    public void throwDice(){
        int value = gooseGame.throwDice();
        boolean inRange = (value>=1) && (value<=6);
        assertTrue(inRange);
    }

    @Test
    public void dispatchCommandAdd(){
        gooseGame.dispatchCommand("add player Pippo");
        assertTrue(gooseGame.playerList.size()==1);
    }

    @Test
    public void dispatchCommandMove(){
        gooseGame.addPlayer("add player Pippo");
        gooseGame.dispatchCommand("move Pippo 4, 2");
        assertEquals("6",gooseGame.playerList.get(0).getPosition());
    }


}

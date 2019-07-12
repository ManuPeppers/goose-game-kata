import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerManagerTest {

    @Test
    public void insertOnePlayer(){
        PlayerManager playerManager =new PlayerManager();
        playerManager.addPlayer("add player Pippo");

        assertEquals("players: Pippo", playerManager.extractParticipants());
    }

    @Test
    public void insertTwoPlayers(){
        PlayerManager playerManager =new PlayerManager();
        playerManager.addPlayer("add player Pippo");
        playerManager.addPlayer("add player Pluto");

        assertEquals("players: Pippo, Pluto", playerManager.extractParticipants());
    }

}

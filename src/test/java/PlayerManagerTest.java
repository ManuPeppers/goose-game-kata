import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerManagerTest {

    PlayerManager playerManager;

    @Before
    public void setUp() {
        playerManager = new PlayerManager();
    }

    @Test
    public void insertOnePlayer() {
        playerManager.addPlayer("add player Pippo");

        assertEquals("players: Pippo", playerManager.extractParticipants());
    }

    @Test
    public void insertTwoPlayers() {
        playerManager.addPlayer("add player Pippo");
        playerManager.addPlayer("add player Pluto");

        assertEquals("players: Pippo, Pluto", playerManager.extractParticipants());
    }

    @Test
    public void shouldReturnErrorIfPlayerAlreadyExists() {
        playerManager.addPlayer("add player Pippo");

        assertEquals("Pippo: already existing player", playerManager.addPlayer("add player Pippo"));
    }
}

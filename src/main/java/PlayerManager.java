import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

    List<Player> playerList = new ArrayList<>();

    public void addPlayer(String input) {
        String name = input.split(" ")[2];
        playerList.add(new Player(name));
    }

    public String extractParticipants() {
        String participants = "players: ";

        for (Player playername : playerList) {
            participants += playername.name() + ", ";
        }

        return participants.substring(0, participants.length() - 2);
    }
}

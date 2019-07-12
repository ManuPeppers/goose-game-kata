import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

    List<Player> playerList = new ArrayList<>();

    public String addPlayer(String input) {
        String name = input.split(" ")[2];

        if (playerExists(name))
            return name + ": already existing player";

        playerList.add(new Player(name));

        return extractParticipants();
    }

    private boolean playerExists(String name) {
        for (Player player : playerList) {
            if (name.equals(player.name())) {
                return true;
            }
        }
        return false;
    }

    public String extractParticipants() {
        String participants = "players: ";

        for (Player playername : playerList) {
            participants += playername.name() + ", ";
        }

        return participants.substring(0, participants.length() - 2);
    }
}

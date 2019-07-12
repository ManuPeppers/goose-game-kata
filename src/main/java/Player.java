import java.util.Objects;

public class Player {

    private String playerName;
    private int position;

    public Player(String name) {
        this.playerName=name;
    }

    public String name() {
        return playerName;
    }

    public String getPosition(){
        return this.position == 0 ? "Start" : String.valueOf(this.position);
    }

    public void incrementPosition(int increment){
        this.position += increment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return Objects.equals(playerName, player.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerName);
    }
}

import java.lang.reflect.Array;
import java.util.*;

public class GooseGame {

    private boolean gameInProgress=true;

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

    public String movePlayer(String input) {
        String inputWords[] = input.split(" |, ");
        if(inputWords[0].equals("move")){
            String playerName = inputWords[1];

            String firstDie = String.valueOf(throwDice());
            String secondDie = String.valueOf(throwDice());

            if(inputWords.length > 2) {
                firstDie = inputWords[2];
                secondDie = inputWords[3];
            }


            String message = playerName + " rolls " + firstDie + ", " + secondDie + ". ";
            int increment = Integer.parseInt(firstDie) + Integer.parseInt(secondDie);
            for(Player player : playerList){
                message = incrementPositionAndWriteMessage(playerName, message, increment, player);
            }
            return message;
        }
        return "";
    }

    private String incrementPositionAndWriteMessage(String playerName, String message, int increment, Player player) {
        if(player.name().equals(playerName)){
            message += player.name() + " moves from " + player.getPosition();
            player.incrementPosition(increment);
            ArrayList<Integer> goosePosition = new ArrayList<Integer>(Arrays.asList(5, 9, 14, 18, 23, 27));

            int currentPosition = Integer.parseInt(player.getPosition());
            if(currentPosition >=63){
                if(currentPosition % 63 > 0){
                    message = doBounce(message, player, currentPosition);
                }
                else{
                    message = doWin(message, player);
                }
            }
            else if(currentPosition == 6){
                player.incrementPosition(6);
                message += " to The Bridge. " + playerName +" jumps to 12";
            } else if (goosePosition.contains(currentPosition)) {
                player.incrementPosition(increment);
                message += " to " + currentPosition + ", The Goose. " + playerName + " moves again and goes to " + player.getPosition();
            }
            else{
                message += " to " + player.getPosition()+".";
            }
        }
        return message;
    }

    private String doWin(String message, Player player) {
        message += " to " + player.getPosition()+".";
        message += " " + player.name() + " Wins!!";
        gameInProgress = false;
        return message;
    }

    private String doBounce(String message, Player player, int currentPosition) {
        player.incrementPosition((63-currentPosition)-(currentPosition%63));
        message += " to 63.";
        message += " " + player.name() + " bounces! " + player.name() + " returns to " + player.getPosition();
        return message;
    }

    public int throwDice() {
        Random random = new Random();
        int randomDice = random.nextInt(60) % 6 + 1;
        return randomDice;
    }

    public void start() {
        System.out.println("GOOSE GAME IS STARTING...\n\n");
        System.out.println("Type your command: ");
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextLine() && gameInProgress){
            String command = scanner.nextLine();
            this.dispatchCommand(command);
        }
    }

    public void dispatchCommand(String command) {

        if(command.startsWith("move")){
            System.out.println(movePlayer(command)+ "\n");
        }
        else if(command.startsWith("add")){
            System.out.print(addPlayer(command) + "\n");
        }
        else {
            System.out.println("Wrong Command");
        }

    }
}

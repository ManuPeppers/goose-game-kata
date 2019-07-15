package main;

import java.util.ArrayList;
import java.util.List;

public class GooseGame {

    private List<Player> playerList=new ArrayList<>();
    private int nowPositionPlayer =0;
    private String startingPosition="Start";


    public String addPlayer(String playerName) {

        String name=playerName.split(" ")[2];

        playerList.add(new Player(name));

        for (Player players:playerList){

            if(players.getName().equals(name)){

                return name + ": already existing player";
            }
        }

        playerList.add(new Player(name));

        return exctractPartecipants();
    }

    public String exctractPartecipants() {
        String participants="players: ";

        for (Player playerNames:playerList){

            participants+=playerNames.getName()+", ";
        }

        return formatParticapantsList(participants);
    }


    private String formatParticapantsList(String participants) {
        return participants.substring(0, participants.length()-2);
    }

    public String throwDices(String s) {

        String formatPosition=" ";
        String whosThrowing= " ";
        int diceOnePoints = Integer.parseInt(s.split(" |, ")[2]);
        int diceTwoPoints = Integer.parseInt(s.split(" |, ")[3]);
        int dicePointsSum = diceOnePoints + diceTwoPoints + nowPositionPlayer;

        whosThrowing=s.split(" |, ")[1];


        formatPosition = whosThrowing +
                            " rolls " +
                        diceOnePoints +
                                 ", " +
                    diceTwoPoints +
                                  ". "+
                         whosThrowing +
                        " moves from "+
                     startingPosition +
                               " to " +
                            dicePointsSum;

        startingPosition= String.valueOf(dicePointsSum);

                nowPositionPlayer = dicePointsSum;

        return formatPosition;
    }
}

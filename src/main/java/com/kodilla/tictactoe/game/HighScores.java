package com.kodilla.tictactoe.game;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HighScores implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final int HIGH_SCORES_LIMIT = 10;

    private List<PlayerScore> playersList = new ArrayList<>();

    public void addScore(PlayerScore playerScore)  {
        playersList.add(playerScore);
        Collections.sort(playersList);
        if(playersList.size() > HIGH_SCORES_LIMIT) {
            playersList = playersList.stream().limit(10).collect(Collectors.toList());
        }
        for(int i = 0; i < playersList.size(); i ++) {
            playersList.get(i).setRank(i+1);
        }
    }

    public List<PlayerScore> getPlayersList() {
        return playersList;
    }

    public void setPlayersList(List<PlayerScore> playersList) {
        this.playersList = playersList;
    }
}


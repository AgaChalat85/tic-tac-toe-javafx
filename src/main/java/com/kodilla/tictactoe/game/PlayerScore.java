package com.kodilla.tictactoe.game;

import com.kodilla.tictactoe.player.Player;

import java.io.Serializable;

public class PlayerScore implements Serializable, Comparable<PlayerScore> {

    private Integer rank;
    private String playerName;
    private Integer playerScore;

    public PlayerScore(Player player) {
        this.playerName = player.getName();
        this.playerScore = player.getScore();
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getPlayerName() {
        return playerName;
    }


    public Integer getPlayerScore() {
        return playerScore;
    }


    @Override
    public String toString() {
        return "PlayerScore{" +
                "rank=" + rank +
                ", playerName='" + playerName + '\'' +
                ", playerScore=" + playerScore +
                '}';
    }

    @Override
    public int compareTo(PlayerScore o) {
        int compareResult = -(Integer.compare(this.playerScore, o.playerScore));
        if (compareResult == 0) {
            compareResult = playerName.compareToIgnoreCase(o.playerName);
        }
        return compareResult;
    }
}

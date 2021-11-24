package com.kodilla.tictactoe.game;

import com.kodilla.tictactoe.player.Computer;
import com.kodilla.tictactoe.player.Player;

import java.io.Serializable;
import java.util.List;

public class GameState implements Serializable {

    private static final long serialVersionUID = 1L;
    private Player player;
    private Computer computer;
    private int draws;
    private List<String> fieldValues;
    private boolean saved;

    public GameState(Player player, Computer computer, int draws, List<String> fieldValues) {
        this.player = player;
        this.computer = computer;
        this.draws = draws;
        this.fieldValues = fieldValues;
        this.saved = true;
    }

    public void reset() {
        player = null;
        computer = null;
        this.draws = 0;
        this.fieldValues = null;
        saved = false;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public List<String> getFieldValues() {
        return fieldValues;
    }

    public void setFieldValues(List<String> fieldValues) {
        this.fieldValues = fieldValues;
    }

    public boolean isSaved() {
        return saved;
    }

    public void setSaved(boolean saved) {
        this.saved = saved;
    }

    @Override
    public String toString() {
        return "GameState{" +
                "player=" + player +
                ", computer=" + computer +
                ", draws=" + draws +
                ", fieldValues=" + fieldValues +
                ", saved=" + saved +
                '}';
    }
}

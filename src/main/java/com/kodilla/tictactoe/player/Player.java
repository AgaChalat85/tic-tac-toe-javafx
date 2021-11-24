package com.kodilla.tictactoe.player;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import java.io.Serializable;

public class Player implements Serializable {

    private String name;
    private String sign;
    private Integer score = 0;

    public String getSign() {

        return sign;
    }

    public Integer getScore() {

        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void incrementScore() {
        this.score++;
    }

    public boolean makeMove(Button button) {
        boolean moveExecuted = false;
        if (button.getText().isEmpty()) {
            button.setText(this.sign);
            button.setTextFill(Color.web("#3498DB"));
            moveExecuted = true;
        }
        return moveExecuted;
    }

}
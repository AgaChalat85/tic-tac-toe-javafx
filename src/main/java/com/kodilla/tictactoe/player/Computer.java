package com.kodilla.tictactoe.player;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;

import java.io.Serializable;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Computer implements Serializable {

    private String name;
    private String sign;
    private int score = 0;
    private Random random = new Random();

    public String getName() {
        return name;
    }

    public String getSign() {
        return sign;
    }

    public int getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void incrementScore() {
        this.score++;
    }

    public void makeMove(List<Button> buttons) {
        List<Button> emptyButtons = buttons.stream().filter(b -> b.getText().isEmpty()).collect(Collectors.toList());
        try {
            Button randomEmptyButton = emptyButtons.get(random.nextInt(emptyButtons.size()));
            randomEmptyButton.setText(sign);
            randomEmptyButton.setTextFill(Color.web("#E74C3C"));
        } catch (IllegalArgumentException e) {
            System.out.println("Draw");
        }
    }
}

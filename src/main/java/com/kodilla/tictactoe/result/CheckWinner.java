package com.kodilla.tictactoe.result;


import javafx.scene.control.Button;
import java.util.ArrayList;
import java.util.List;


public class CheckWinner {
    List<Combination> combinations;

    public CheckWinner(List<Button> buttons) {
        createCombination(buttons);
    }

    private void createCombination(List<Button> buttons) {
        combinations = new ArrayList<>();
        combinations.add(new Combination(buttons.get(0),buttons.get(1), buttons.get(2)));
        combinations.add(new Combination(buttons.get(3),buttons.get(4), buttons.get(5)));
        combinations.add(new Combination(buttons.get(6),buttons.get(7), buttons.get(8)));
        combinations.add(new Combination(buttons.get(0),buttons.get(3), buttons.get(6)));
        combinations.add(new Combination(buttons.get(1),buttons.get(4), buttons.get(7)));
        combinations.add(new Combination(buttons.get(2),buttons.get(5), buttons.get(8)));
        combinations.add(new Combination(buttons.get(0),buttons.get(4), buttons.get(8)));
        combinations.add(new Combination(buttons.get(2),buttons.get(4), buttons.get(6)));

    }

    public boolean checkIfXWins(String sign) {
       return  this.combinations.stream().anyMatch(combination -> combination.checkIfWin(sign));

    }

    public boolean checkIfDraw(List<Button> buttons) {
        return buttons.stream().noneMatch(b-> b.getText().isEmpty());
    }
}
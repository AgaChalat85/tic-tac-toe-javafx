package com.kodilla.tictactoe.result;

import javafx.scene.control.Button;
import javafx.scene.paint.Color;

public class Combination {

    private Button button1;
    private Button button2;
    private Button button3;


    public Combination(Button button1, Button button2, Button button3) {
        this.button1 = button1;
        this.button2 = button2;
        this.button3 = button3;
    }

    public boolean checkIfWin(String sign) {
        boolean result = button1.getText().equals(sign) && button2.getText().equals(sign) && button3.getText().equals(sign);
        if(result) {
            button1.setTextFill(Color.web("#FFFF00"));
            button2.setTextFill(Color.web("#FFFF00"));
            button3.setTextFill(Color.web("#FFFF00"));

        }
        return result;
    }

}


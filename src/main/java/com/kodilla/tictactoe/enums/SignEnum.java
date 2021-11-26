package com.kodilla.tictactoe.enums;

public enum SignEnum {
    X("#3498DB"),
    O("#E74C3C");

    private String color;

    private SignEnum(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}


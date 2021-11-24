package com.kodilla.tictactoe.game;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;


public class GameStateService {

    private final static Logger LOGGER = LogManager.getLogger(GameStateService.class);
    private final static String GAME_STATE_FILE_PATH = "src/main/resources/com/kodilla/tictactoe/savedGame.txt";
    private final static String HIGH_SCORE_FILE_PATH = "src/main/resources/com/kodilla/tictactoe/highScore.txt";

    public boolean saveState(GameState gameState) {

        try (FileOutputStream f = new FileOutputStream(new File(GAME_STATE_FILE_PATH));
             ObjectOutputStream o = new ObjectOutputStream(f)) {

            o.writeObject(gameState);
            System.out.println("Stan gry zostal poprawnie zapisany");

            return true;
        } catch (Exception e) {
            System.out.println("Podczas zapisu gry wystapil blad");
            return false;
        }
    }

    public GameState readState() {

        try (FileInputStream fi = new FileInputStream(new File(GAME_STATE_FILE_PATH));
             ObjectInputStream oi = new ObjectInputStream(fi)) {

            GameState gameState1 = (GameState) oi.readObject();

            System.out.println("Stan gry zostal poprawnie odczytany");

            return gameState1;

        } catch (Exception e) {
            System.out.println("Podczas odczytywania stanu gry wystapil blad");
            return null;

        }
    }

    public boolean saveHighScore(HighScores highScores) {

        try (FileOutputStream f = new FileOutputStream(new File(HIGH_SCORE_FILE_PATH));
             ObjectOutputStream o = new ObjectOutputStream(f)) {

            o.writeObject(highScores);
            System.out.println("Tablica wynikow zostala poprawnie zapisana");

            return true;
        } catch (Exception e) {
            System.out.println("Podczas zapisu tablicy wynikow wystapil blad");
            return false;
        }
    }

    public HighScores readHighScore() {

        try (FileInputStream fi = new FileInputStream(new File(HIGH_SCORE_FILE_PATH));
             ObjectInputStream oi = new ObjectInputStream(fi)) {

            HighScores highScores = (HighScores) oi.readObject();

            System.out.println("Tablica wynikow zostala poprawnie odczytany");

            return highScores;

        } catch (Exception e) {
            System.out.println("Podczas odczytywania tablicy wynikow  wystapil blad");
            return new HighScores();

        }
    }
}

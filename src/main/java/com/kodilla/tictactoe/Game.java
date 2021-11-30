package com.kodilla.tictactoe;

import static com.kodilla.tictactoe.util.DimensionsAndCoordinates.*;
import static com.kodilla.tictactoe.util.Messages.*;
import static com.kodilla.tictactoe.enums.SignEnum.*;

import com.kodilla.tictactoe.game.GameState;
import com.kodilla.tictactoe.game.GameStateService;
import com.kodilla.tictactoe.game.HighScores;
import com.kodilla.tictactoe.game.PlayerScore;
import com.kodilla.tictactoe.gui.GUICreator;
import com.kodilla.tictactoe.player.Computer;
import com.kodilla.tictactoe.player.Player;
import com.kodilla.tictactoe.result.CheckWinner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Game extends Application {

    private BorderPane startRoot;
    private Pane root;
    private Pane rankingScene;
    private GridPane settingScene;
    private List<Button> buttons;
    private Button playButton;
    private Button continueButton;
    private Button exitButton;
    private Button infoButton;
    private Button highScoresButton;
    private Button returnButton;
    private Button goButton;
    private Button restartButton;
    private Button playAgainButton;
    private Button endGameButton;
    private Button quitAndSaveButton;
    private RadioButton choiceSignX;
    private RadioButton choiceSignY;
    private Scene scene;
    private Scene scene2;
    private Scene scene3;
    private Scene scene4;
    private VBox vBox;
    private HBox hBox;
    private ToggleGroup toggleGroup = new ToggleGroup();
    private Player player = new Player();
    private Computer computer = new Computer();
    public CheckWinner checkWinner;
    private Label labelForNameField;
    private Label selectSignLabel;
    private Label playerLabel;
    private Label computerLabel;
    private Label drawLabel;
    private Label playerResultLabel;
    private Label computerResultLabel;
    private Label drawResultLabel;
    private Label gameResultLabel;
    private Label gameNameLabel;
    private TextField playerNameField;
    private int draw = 0;
    private Media victorySound;
    private Media loseSound;
    private Media drawSound;
    private MediaPlayer mediaPlayer1;
    private MediaPlayer mediaPlayer2;
    private MediaPlayer mediaPlayer3;
    private GameStateService gameStateService;
    private HighScores highScores = new HighScores();
    private GameState gameState;

    @Override
    public void start(Stage stage) throws IOException {
        readFromFiles();
        createGUI();
        setActions(stage);
        setCssStyles();
        setMediaPlayer();
        checkWinner = new CheckWinner(buttons);
        showStage(stage);
    }

    public static void main(String[] args) {
        launch();
    }

    private void readFromFiles() {
        gameStateService = new GameStateService();
        highScores = gameStateService.readHighScore();
        gameState = gameStateService.readState();

    }

    private void createGUI() {
        //create pane components
        this.startRoot = GUICreator.createStartScene();
        this.root = GUICreator.createGameScene();
        this.rankingScene = GUICreator.createRankingScene(highScores);
        this.settingScene = GUICreator.createSettingsScene();

        // create buttons components
        this.buttons = GUICreator.createButtons();
        this.playButton = GUICreator.createPlayButton();
        this.continueButton = GUICreator.createContinueButton();
        this.exitButton = GUICreator.createExitButton();
        this.infoButton = GUICreator.createInfoButton();
        this.highScoresButton = GUICreator.createHighScoresButton();
        this.returnButton = GUICreator.createReturnButton();
        this.choiceSignX = GUICreator.createSelectButtonX();
        this.choiceSignY = GUICreator.createSelectButtonY();
        this.goButton = GUICreator.createGoButton();
        this.playAgainButton = GUICreator.createPlayAgainButton();
        this.restartButton = GUICreator.createRestartButton();
        this.quitAndSaveButton = GUICreator.createQuitAndSaveButton();
        this.endGameButton = GUICreator.createEndGameButton();

        //create label components
        this.labelForNameField = GUICreator.createLabelForPlayerNameField();
        this.selectSignLabel = GUICreator.createSelectSignLabel();
        this.playerLabel = GUICreator.createPlayerLabel();
        this.computerLabel = GUICreator.createComputerLabel();
        this.drawLabel = GUICreator.createDrawLabel();
        this.playerResultLabel = GUICreator.createPlayerResultLabel();
        this.computerResultLabel = GUICreator.createComputerResultLabel();
        this.drawResultLabel = GUICreator.createDrawResultLabel();
        this.gameResultLabel = GUICreator.createResultLabel();
        this.gameNameLabel = GUICreator.createGameNameLabel();
        this.playerNameField = GUICreator.createNameField();

        // create scenes components
        this.scene = new Scene(startRoot, GAME_WIDTH, GAME_HEIGHT);
        this.scene2 = new Scene(settingScene, GAME_WIDTH, GAME_HEIGHT);
        this.scene3 = new Scene(root, GAME_WIDTH, GAME_HEIGHT);
        this.scene4 = new Scene(rankingScene, GAME_WIDTH, GAME_HEIGHT);

        if (!gameState.isSaved()) {
            this.continueButton.setDisable(true);
        }
        // create layout components
        this.vBox = GUICreator.createVBox();
        this.vBox.getChildren().addAll(playButton, continueButton, highScoresButton, exitButton);
        this.hBox = GUICreator.createHBox();
        this.hBox.getChildren().addAll(gameNameLabel, infoButton);

        // inject components to startroot
        this.startRoot.setCenter(vBox);
        this.startRoot.setBottom(hBox);

        // inject components to settingScene
        this.settingScene.add(labelForNameField, 0, 0);
        this.settingScene.add(playerNameField, 0, 1);
        this.settingScene.add(selectSignLabel, 0, 2);
        this.settingScene.add(choiceSignX, 0, 3);
        this.settingScene.add(choiceSignY, 0, 4);
        this.settingScene.add(goButton, 0, 6);


        this.choiceSignX.setToggleGroup(toggleGroup);
        this.choiceSignX.setSelected(true);
        this.choiceSignY.setToggleGroup(toggleGroup);

        //inject components to rankingScene
        this.rankingScene.getChildren().add(returnButton);

        // inject components to root
        this.root.getChildren().addAll(playAgainButton, restartButton, quitAndSaveButton, endGameButton, playerLabel, computerLabel,
                drawLabel, playerResultLabel, computerResultLabel, drawResultLabel, gameResultLabel);
        this.buttons.forEach(root.getChildren()::add);
    }

    private void setPlayers() {
        String playerSign = ((RadioButton) toggleGroup.getSelectedToggle()).getText();
        player.setName(playerNameField.getText());
        player.setSign(playerSign);
        player.setScore(0);
        String computerSign = playerSign.equals(X.name()) ? O.name() : X.name();
        computer.setName("Computer");
        computer.setScore(0);
        computer.setSign(computerSign);
    }

    private void setActions(Stage stage) {
        this.playButton.setOnAction(event -> stage.setScene(scene2));
        this.continueButton.setOnAction(event -> {
            readGameState();
            stage.setScene(scene3);
        });
        this.exitButton.setOnAction(event -> System.exit(0));
        this.infoButton.setOnAction(event -> getHostServices().showDocument(WIKI_TIC_TAC_TOE));
        this.highScoresButton.setOnAction(event -> stage.setScene(scene4));
        this.returnButton.setOnAction(event -> stage.setScene(scene));
        this.goButton.setOnAction(event -> {
            if (!playerNameField.getText().trim().isEmpty()) {
                setPlayers();
                stage.setScene(scene3);
            }
        });
        this.playAgainButton.setOnAction(event -> {
            for (Button button : this.buttons) {
                button.setDisable(false);
                button.setText("");
                gameResultLabel.setText("");
                mediaPlayer1.stop();
                mediaPlayer2.stop();
                mediaPlayer3.stop();
            }
        });
        this.restartButton.setOnAction(event -> {
            for (Button button : this.buttons) {
                button.setDisable(false);
                button.setText("");
                playerResultLabel.setText(ZERO);
                player.setScore(0);
                drawResultLabel.setText(ZERO);
                draw = 0;
                computerResultLabel.setText(ZERO);
                computer.setScore(0);
                gameResultLabel.setText("");
                mediaPlayer1.stop();
                mediaPlayer2.stop();
                mediaPlayer3.stop();
            }
        });

        this.quitAndSaveButton.setOnAction(event -> {
                    List<String> fieldValues = this.buttons.stream().map(button -> button.getText()).collect(Collectors.toList());
                    gameState = new GameState(player, computer, draw, fieldValues);
                    boolean saved = gameStateService.saveState(gameState);
                    if (saved) {
                        System.out.println(GAME_SAVED_SUCCESSFULLY);
                        System.exit(0);
                    } else {
                        System.out.println(GAME_SAVED_UNSUCCESSFULLY);
                    }
                }
        );

        this.endGameButton.setOnAction(b -> {
            PlayerScore playerScore = new PlayerScore(player);
            highScores.addScore(playerScore);
            gameStateService.saveHighScore(highScores);
            gameState.reset();
            gameStateService.saveState(gameState);
            System.exit(0);
        });


        for (Button button : this.buttons)
            button.setOnAction(event -> {
                // player makes move
                if (player.makeMove(button)) {
                    // check if player wins
                    if (checkWinner.checkIfXWins(player.getSign())) {
                        player.incrementScore();
                        playerResultLabel.setText(String.valueOf(player.getScore()));
                        gameResultLabel.setText(PLAYER_WINS);
                        mediaPlayer1.play();
                        buttons.forEach(b -> b.setDisable(true));

                    } else {
                        computer.makeMove(buttons);

                        if (checkWinner.checkIfXWins(computer.getSign())) {
                            computer.incrementScore();
                            computerResultLabel.setText(String.valueOf(computer.getScore()));
                            gameResultLabel.setText(COMPUTER_WINS);
                            mediaPlayer2.play();
                            buttons.forEach(b -> b.setDisable(true));

                        } else if (checkWinner.checkIfDraw(buttons)) {
                            draw++;
                            drawResultLabel.setText(String.valueOf(draw));
                            gameResultLabel.setText(DRAW);
                            mediaPlayer3.play();
                            buttons.forEach(b -> b.setDisable(true));
                        }
                    }
                }
            });
    }


    private void setCssStyles() {
        this.scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        this.scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        this.scene3.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        this.scene4.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
        //this.startRoot.getStyleClass().add("startRoot");

    }

    private void showStage(Stage stage) {
        stage.setResizable(false);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
        stage.show();
    }

    private void setMediaPlayer() {
        victorySound = new Media(getClass().getResource("MLDF4YC-positive-game-victory.mp3").toExternalForm());
        loseSound = new Media(getClass().getResource("mixkit-negative-answer-lose-2032.wav").toExternalForm());
        drawSound = new Media(getClass().getResource("mixkit-quick-positive-video-game-notification-interface-265.wav").toExternalForm());
        mediaPlayer1 = new MediaPlayer(victorySound);
        mediaPlayer2 = new MediaPlayer(loseSound);
        mediaPlayer3 = new MediaPlayer(drawSound);
    }

    private void readGameState() {
        if (gameState != null) {
            // set labels
            playerResultLabel.setText(String.valueOf(gameState.getPlayer().getScore()));
            computerResultLabel.setText(String.valueOf(gameState.getComputer().getScore()));
            drawResultLabel.setText(String.valueOf(gameState.getDraws()));

            // set variables
            player = gameState.getPlayer();
            computer = gameState.getComputer();
            draw = gameState.getDraws();

            // set buttons values
            if (gameState.getFieldValues() != null) {
                setButtonsValues(gameState);
            }
        }
    }

    private void setButtonsValues(GameState gameState) {
        for (int i = 0; i < gameState.getFieldValues().size(); i++) {
            String buttonValue = gameState.getFieldValues().get(i);
            this.buttons.get(i).setText(buttonValue);

            if (!buttonValue.isEmpty()) {
                String color = buttonValue.equals(X.name()) ? X.getColor() : O.getColor();
                this.buttons.get(i).setTextFill(Color.web(color));
            }
        }

        if (checkWinner.checkIfXWins(X.name()) || checkWinner.checkIfXWins(O.name())) {
            buttons.forEach(b -> b.setDisable(true));

        }
    }
}
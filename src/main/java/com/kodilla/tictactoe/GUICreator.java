package com.kodilla.tictactoe;

import static com.kodilla.tictactoe.util.Dimensions.*;

import com.kodilla.tictactoe.game.HighScores;
import com.kodilla.tictactoe.game.PlayerScore;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.ArrayList;
import java.util.List;

public class GUICreator {

    public static BorderPane createStartScene() {
        BorderPane startRoot = new BorderPane();
        Label label = new Label();
        Image image = new Image(GUICreator.class.getResourceAsStream("start-scene-image.png"));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(580);
        imageView.setFitHeight(490);
        label.setGraphic(imageView);
        startRoot.setLeft(label);

        return startRoot;
    }

    public static Button createPlayButton() {
        Button playButton = new Button("Play");
        playButton.setLayoutX(50);
        playButton.getStyleClass().add("playButton");

        return playButton;
    }

    public static Button createContinueButton() {
        Button continueButton = new Button("Continue");
        continueButton.getStyleClass().add("highScore");

        return continueButton;
    }

    public static Button createHighScoresButton() {
        Button highScores = new Button("High Scores");
        highScores.getStyleClass().add("highScore");

        return highScores;
    }

    public static Button createExitButton() {
        Button exitButton = new Button("Exit");
        exitButton.getStyleClass().add("exitButton");
        return exitButton;
    }

    public static Label createGameNameLabel() {
        Label gameNameLabel = new Label("Tic-Tac-Toe");
        gameNameLabel.getStyleClass().add("nameLabel");

        return gameNameLabel;
    }

    public static Button createInfoButton() {
        Button infoButton = new Button("Info");
        infoButton.getStyleClass().add("info");

        return infoButton;
    }

    public static VBox createVBox() {
        VBox vBox = new VBox(40);
        vBox.setAlignment(Pos.CENTER_LEFT);

        return vBox;
    }

    public static HBox createHBox() {
        HBox hBox = new HBox(20);
        hBox.setAlignment(Pos.CENTER_RIGHT);

        return hBox;
    }

    public static Pane createGameScene() {
        Pane root = new Pane();
        return root;
    }

    public static Pane createRankingScene(HighScores highScores) {
        Pane rankingScene = new Pane();
        Label rankingLabel = new Label("Top Ten Players");
        rankingLabel.setLayoutX(315);
        rankingLabel.setLayoutY(20);
        rankingLabel.getStyleClass().add("rankingLabel");

        TableView<PlayerScore> rankList = new TableView<>();
        rankList.setLayoutX(150);
        rankList.setLayoutY(80);

        TableColumn<PlayerScore, String> rankCol = new TableColumn<>("RANK");
        TableColumn<PlayerScore, String> playerNameCol = new TableColumn<>("PLAYER NAME");
        TableColumn<PlayerScore, String> scoreCol = new TableColumn<>("SCORE");

        rankCol.setPrefWidth(150);
        rankCol.setSortable(false);
        rankCol.setResizable(false);
        playerNameCol.setPrefWidth(300);
        playerNameCol.setResizable(false);
        playerNameCol.setSortable(false);
        scoreCol.setPrefWidth(150);
        scoreCol.setResizable(false);
        scoreCol.setSortable(false);

        rankCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getRank().toString()));
        playerNameCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPlayerName()));
        scoreCol.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getPlayerScore().toString()));
        ObservableList<PlayerScore> observableList = FXCollections.observableList(highScores.getPlayersList());
        rankList.setItems(observableList);

        rankList.getColumns().addAll(rankCol, playerNameCol, scoreCol);
        rankingScene.getChildren().addAll(rankList, rankingLabel);
        return rankingScene;
    }

    public static Button createReturnButton() {
        Button returnButton = new Button("Return");
        returnButton.getStyleClass().add("go-and-return");
        returnButton.setLayoutX(410);
        returnButton.setLayoutY(480);
        return returnButton;
    }

    public static GridPane createSettingsScene() {
        GridPane settingsScene = new GridPane();
        settingsScene.setPadding(new Insets(100));
        settingsScene.setVgap(30);

        return settingsScene;
    }

    public static Label createLabelForPlayerNameField() {
        Label labelForPlayerNameField = new Label("Please enter your name:");
        return labelForPlayerNameField;
    }

    public static TextField createNameField() {
        TextField nameField = new TextField();
        nameField.getStyleClass().add("info");
        nameField.setPrefColumnCount(2);
        return nameField;
    }

    public static Label createSelectSignLabel() {
        Label selectSignLabel = new Label("Please choice your sign: ");
        return selectSignLabel;

    }

    public static RadioButton createSelectButtonX() {
        RadioButton buttonX = new RadioButton("X");
        buttonX.getStyleClass().add("radio-button");

        return buttonX;
    }

    public static RadioButton createSelectButtonY() {
        RadioButton buttonY = new RadioButton("O");
        buttonY.getStyleClass().add("radio-button");

        return buttonY;
    }

    public static Button createGoButton() {
        Button goButton = new Button("Go");
        goButton.getStyleClass().add("go-and-return");
        goButton.setPrefSize(60, 30);
        return goButton;
    }

    public static Button createPlayAgainButton() {
        Button playAgainButton = new Button("Play Again");
        playAgainButton.getStyleClass().add("info");
        playAgainButton.setLayoutX(750);
        playAgainButton.setLayoutY(100);
        playAgainButton.setPrefWidth(170);

        return playAgainButton;
    }

    public static Button createRestartButton() {
        Button restartButton = new Button("Restart");
        restartButton.getStyleClass().add("info");
        restartButton.setLayoutX(750);
        restartButton.setLayoutY(200);
        restartButton.setPrefWidth(170);

        return restartButton;
    }

    public static Button createQuitAndSaveButton() {
        Button quitAndSaveButton = new Button("Save and Quit Game");
        quitAndSaveButton.getStyleClass().add("info");
        quitAndSaveButton.setLayoutX(750);
        quitAndSaveButton.setLayoutY(300);
        quitAndSaveButton.setPrefWidth(170);
        return quitAndSaveButton;
    }

    public static Button createQuitGameButton() {
        Button quitGameButton = new Button("End Game");
        quitGameButton.getStyleClass().add("info");
        quitGameButton.setLayoutX(750);
        quitGameButton.setLayoutY(400);
        quitGameButton.setPrefWidth(170);
        return quitGameButton;
    }


    public static Label createPlayerLabel() {
        Label playerLabel = new Label("Player");
        playerLabel.setLayoutX(240);
        playerLabel.setLayoutY(465);
        playerLabel.getStyleClass().add("label");

        return playerLabel;
    }

    public static Label createComputerLabel() {
        Label computerLabel = new Label("Computer");
        computerLabel.setLayoutX(530);
        computerLabel.setLayoutY(465);
        computerLabel.getStyleClass().add("label");

        return computerLabel;
    }

    public static Label createDrawLabel() {
        Label drawLabel = new Label("Draw");
        drawLabel.setLayoutX(405);
        drawLabel.setLayoutY(465);
        drawLabel.getStyleClass().add("label");

        return drawLabel;
    }

    public static Label createPlayerResultLabel() {
        Label playerResultLabel = new Label(String.valueOf(0));
        playerResultLabel.setLayoutX(270);
        playerResultLabel.setLayoutY(495);
        playerResultLabel.getStyleClass().add("resultLabel");

        return playerResultLabel;

    }

    public static Label createComputerResultLabel() {
        Label computerResultLabel = new Label(String.valueOf(0));
        computerResultLabel.setLayoutX(588);
        computerResultLabel.setLayoutY(495);
        computerResultLabel.getStyleClass().add("resultLabel");

        return computerResultLabel;

    }

    public static Label createDrawResultLabel() {
        Label drawResultLabel = new Label(String.valueOf(0));
        drawResultLabel.setLayoutX(430);
        drawResultLabel.setLayoutY(495);
        drawResultLabel.getStyleClass().add("resultLabel");

        return drawResultLabel;

    }

    public static Label createResultLabel() {
        Label gameResult = new Label();
        gameResult.setLayoutX(330);
        gameResult.setLayoutY(20);
        gameResult.getStyleClass().add("gameResult");

        return gameResult;
    }


    public static List<Button> createButtons() {

        List<Button> buttons = new ArrayList<>();
        int x = LAYOUT_X;
        int y = LAYOUT_Y;
        int style = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Button button = new Button();
                button.setPrefSize(BUTTON_SIZE, BUTTON_SIZE);
                button.setLayoutX(x);
                button.setLayoutY(y);
                button.getStyleClass().add("button" + style);
                buttons.add(button);
                style++;
                x += BUTTON_SIZE;
            }
            y += BUTTON_SIZE;
            x = LAYOUT_X;
        }

        return buttons;
    }
}

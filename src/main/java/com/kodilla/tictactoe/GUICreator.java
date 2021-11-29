package com.kodilla.tictactoe;

import static com.kodilla.tictactoe.util.DimensionsAndCoordinates.*;
import static com.kodilla.tictactoe.util.Messages.*;
import static com.kodilla.tictactoe.enums.SignEnum.*;

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
        Button playButton = new Button(PLAY_BUTTON);
        playButton.setLayoutX(50);
        playButton.getStyleClass().add(PLAY_BUTTON_CSS);

        return playButton;
    }

    public static Button createContinueButton() {
        Button continueButton = new Button(CONTINUE_BUTTON);
        continueButton.getStyleClass().add(CONTINUE_AND_HIGH_SCORE_BUTTON_CSS);

        return continueButton;
    }

    public static Button createHighScoresButton() {
        Button highScores = new Button(HIGH_SCORE_BUTTON);
        highScores.getStyleClass().add(CONTINUE_AND_HIGH_SCORE_BUTTON_CSS);

        return highScores;
    }

    public static Button createExitButton() {
        Button exitButton = new Button(EXIT_BUTTON);
        exitButton.getStyleClass().add(EXIT_BUTTON_CSS);

        return exitButton;
    }

    public static Label createGameNameLabel() {
        Label gameNameLabel = new Label(TIC_TAC_TOE_LABEL);
        gameNameLabel.getStyleClass().add(TIC_TAC_TOE_LABEL_CSS);

        return gameNameLabel;
    }

    public static Button createInfoButton() {
        Button infoButton = new Button(INFO_BUTTON);
        infoButton.getStyleClass().add(BUTTON_CSS_V2);

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
        Label rankingLabel = new Label(RANKING_LABEL);
        rankingLabel.setLayoutX(315);
        rankingLabel.setLayoutY(20);
        rankingLabel.getStyleClass().add(RANKING_LABEL_CSS);

        TableView<PlayerScore> rankList = new TableView<>();
        rankList.setLayoutX(150);
        rankList.setLayoutY(80);

        TableColumn<PlayerScore, String> rankCol = new TableColumn<>(COLUMN_RANK);
        TableColumn<PlayerScore, String> playerNameCol = new TableColumn<>(COLUMN_PLAYER_NAME);
        TableColumn<PlayerScore, String> scoreCol = new TableColumn<>(COLUMN_SCORE);

        rankCol.setPrefWidth(TABLE_COLUMN_WIDTH);
        rankCol.setSortable(false);
        rankCol.setResizable(false);
        playerNameCol.setPrefWidth(300);
        playerNameCol.setResizable(false);
        playerNameCol.setSortable(false);
        scoreCol.setPrefWidth(TABLE_COLUMN_WIDTH);
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
        Button returnButton = new Button(RETURN_BUTTON);
        returnButton.getStyleClass().add(GO_AND_RETURN_BUTTON_CSS);
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
        Label labelForPlayerNameField = new Label(ENTER_NAME_LABEL);
        return labelForPlayerNameField;
    }

    public static TextField createNameField() {
        TextField nameField = new TextField();
        nameField.getStyleClass().add(BUTTON_CSS_V2);

        return nameField;
    }

    public static Label createSelectSignLabel() {
        Label selectSignLabel = new Label(SELECT_SIGN_LABEL);
        return selectSignLabel;

    }

    public static RadioButton createSelectButtonX() {
        RadioButton buttonX = new RadioButton(X.name());
        buttonX.getStyleClass().add(RADIO_BUTTON_CSS);

        return buttonX;
    }

    public static RadioButton createSelectButtonY() {
        RadioButton buttonY = new RadioButton(O.name());
        buttonY.getStyleClass().add(RADIO_BUTTON_CSS);

        return buttonY;
    }

    public static Button createGoButton() {
        Button goButton = new Button(GO_BUTTON);
        goButton.getStyleClass().add(GO_AND_RETURN_BUTTON_CSS);
        goButton.setPrefSize(60, 30);
        return goButton;
    }

    public static Button createPlayAgainButton() {
        Button playAgainButton = new Button(PLAY_AGAIN_BUTTON);
        playAgainButton.getStyleClass().add(BUTTON_CSS_V2);
        playAgainButton.setLayoutX(BUTTON_SCENE3_LAYOUT_X);
        playAgainButton.setLayoutY(100);
        playAgainButton.setPrefWidth(BUTTON_WIDTH);

        return playAgainButton;
    }

    public static Button createRestartButton() {
        Button restartButton = new Button(RESTART_BUTTON);
        restartButton.getStyleClass().add(BUTTON_CSS_V2);
        restartButton.setLayoutX(BUTTON_SCENE3_LAYOUT_X);
        restartButton.setLayoutY(200);
        restartButton.setPrefWidth(BUTTON_WIDTH);

        return restartButton;
    }

    public static Button createQuitAndSaveButton() {
        Button quitAndSaveButton = new Button(SAVE_AND_QUIT_BUTTON);
        quitAndSaveButton.getStyleClass().add(BUTTON_CSS_V2);
        quitAndSaveButton.setLayoutX(BUTTON_SCENE3_LAYOUT_X);
        quitAndSaveButton.setLayoutY(300);
        quitAndSaveButton.setPrefWidth(BUTTON_WIDTH);
        return quitAndSaveButton;
    }

    public static Button createEndGameButton() {
        Button endGameButton = new Button(END_BUTTON);
        endGameButton.getStyleClass().add(BUTTON_CSS_V2);
        endGameButton.setLayoutX(BUTTON_SCENE3_LAYOUT_X);
        endGameButton.setLayoutY(400);
        endGameButton.setPrefWidth(BUTTON_WIDTH);
        return endGameButton;
    }


    public static Label createPlayerLabel() {
        Label playerLabel = new Label(PLAYER_LABEL);
        playerLabel.setLayoutX(240);
        playerLabel.setLayoutY(LABEL_LAYOUT_Y);
        playerLabel.getStyleClass().add(LABEL_CSS);

        return playerLabel;
    }

    public static Label createComputerLabel() {
        Label computerLabel = new Label(COMPUTER_LABEL);
        computerLabel.setLayoutX(530);
        computerLabel.setLayoutY(LABEL_LAYOUT_Y);
        computerLabel.getStyleClass().add(LABEL_CSS);

        return computerLabel;
    }

    public static Label createDrawLabel() {
        Label drawLabel = new Label(DRAW_LABEL);
        drawLabel.setLayoutX(405);
        drawLabel.setLayoutY(LABEL_LAYOUT_Y);
        drawLabel.getStyleClass().add(LABEL_CSS);

        return drawLabel;
    }

    public static Label createPlayerResultLabel() {
        Label playerResultLabel = new Label(String.valueOf(0));
        playerResultLabel.setLayoutX(270);
        playerResultLabel.setLayoutY(RESULT_LABEL_LAYOUT_Y);
        playerResultLabel.getStyleClass().add(RESULT_LABEL_CSS);

        return playerResultLabel;

    }

    public static Label createComputerResultLabel() {
        Label computerResultLabel = new Label(String.valueOf(0));
        computerResultLabel.setLayoutX(588);
        computerResultLabel.setLayoutY(RESULT_LABEL_LAYOUT_Y);
        computerResultLabel.getStyleClass().add(RESULT_LABEL_CSS);

        return computerResultLabel;

    }

    public static Label createDrawResultLabel() {
        Label drawResultLabel = new Label(String.valueOf(0));
        drawResultLabel.setLayoutX(430);
        drawResultLabel.setLayoutY(RESULT_LABEL_LAYOUT_Y);
        drawResultLabel.getStyleClass().add(RESULT_LABEL_CSS);

        return drawResultLabel;

    }

    public static Label createResultLabel() {
        Label gameResult = new Label();
        gameResult.setLayoutX(330);
        gameResult.setLayoutY(20);
        gameResult.getStyleClass().add(GAME_RESULT_LABEL_CSS);

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
                button.getStyleClass().add(BUTTON_CSS + style);
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

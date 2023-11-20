
package se.iths.TicTacToe;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;


public class GameController {


    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Label scoreLabel;

    public GameModel gameModel;


    public GameController() { //hämta modell från model-klassen?
        gameModel = new GameModel();
    }


    @FXML
    private void onButtonClick(ActionEvent event) { //datorn
        Button clickedButton = (Button) event.getSource(); //hämtar knapp
        int row = GridPane.getRowIndex(clickedButton);
        int col = GridPane.getColumnIndex(clickedButton);

        if (gameModel.makeMove(row, col)) { //kontrollera giltligt drag, om ledigt gör drag
            updateButton(row, col);

            if (gameModel.checkWin()) {
                String message = gameModel.getActivePlayer() + " WINS!";
                gameModel.showResult(message, this);
                resetGame();

            } else if (gameModel.checkDraw() && !gameModel.checkWin()) { //kontroll oavgjort
                String message = "It's a draw";
                gameModel.showResult(message, this);
                resetGame();

            } else {
                gameModel.flipPlayer();

                if (gameModel.getActivePlayer() == 'O') { //datorns drag
                    int[] computerMove = gameModel.makeComputerMove();
                    updateButton(computerMove[0], computerMove[1]);

                    if (gameModel.checkWin()) {
                        String message = gameModel.getActivePlayer() + " wins!";
                        gameModel.showResult(message, this);
                        resetGame();

                    } else if (gameModel.checkDraw()) {
                        String message = "It's a draw";
                        gameModel.showResult(message, this);
                        resetGame();

                    } else {
                        gameModel.flipPlayer();
                    }
                }

            }
            updateScoreLabel();
        }

    }

    private void updateButton(int row, int col) {
        Button button = getButtonAt(row, col);
        button.setText(String.valueOf(gameModel.getActivePlayer()));
        button.setDisable(true);

    }

    private Button getButtonAt(int row, int col) { //matcha rad och kolumn
        return switch (row) {
            case 0 -> switch (col) {
                case 0 -> button1;
                case 1 -> button2;
                case 2 -> button3;
                default -> null;
            };
            case 1 -> switch (col) {
                case 0 -> button4;
                case 1 -> button5;
                case 2 -> button6;
                default -> null;
            };
            case 2 -> switch (col) {
                case 0 -> button7;
                case 1 -> button8;
                case 2 -> button9;
                default -> null;
            };
            default -> null;
        };
    }


    public void resetGame() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = getButtonAt(row, col);
                assert button != null;
                button.setText("");
                button.setDisable(false);
            }
        }
        gameModel.resetGameState();
        updateScoreLabel();

    }


    public void updateScoreLabel() {
        scoreLabel.setText("Player X: " + gameModel.getPlayerXScore() + " | Player O: " + gameModel.getPlayerOScore());

    }


}








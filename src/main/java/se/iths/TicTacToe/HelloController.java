
package se.iths.TicTacToe;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;



public class HelloController {



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

    public Model model;



    public HelloController() { //hämta modell från model-klassen?
        model = new Model();
    }




    @FXML
    private void onButtonClick(ActionEvent event) { //datorn
        Button clickedButton = (Button) event.getSource(); //hämtar knapp
        int row = GridPane.getRowIndex(clickedButton);
        int col = GridPane.getColumnIndex(clickedButton);
        
            if (model.makeMove(row, col)) { //kontrollera giltligt drag, om ledigt gör drag
              updateButton(row, col);
            if (model.checkWin()) {
                String message = model.getActivePlayer() + " WINS!";
                System.out.println("Received message: " + message);
                model.showResult(message, this);

                //kontrollerar vinnare, om det finns - skriv ut
                //model.showResult(model.getActivePlayer() + " WINS!",this);
                resetGame();
            } else if (model.checkDraw() && !model.checkWin()) { //kontroll oavgjort
                String message = "It's a draw";
                System.out.println("Received message: " + message);
                model.showResult(message, this);

                // model.showResult("It´s a draw",this);
                resetGame();
            } else {
                model.flipPlayer();

                if (model.getActivePlayer() == 'O') { //datorns drag
                    int[] computerMove = model.makeComputerMove();
                    updateButton(computerMove[0], computerMove[1]);
                    if (model.checkWin()) {
                        String message = model.getActivePlayer() + " wins!";
                        System.out.println("Received message: " + message);
                        model.showResult(message, this);


                        // model.showResult(model.getActivePlayer() + " wins!",this);
                        resetGame();
                    } else if (model.checkDraw()) {
                        String message = "It's a draw";
                        System.out.println("Received message: " + message);
                        model.showResult(message, this);
                        //   model.showResult("It's a draw",this);
                        resetGame();
                    } else {
                        model.flipPlayer();
                    }
                }

            }
            updateScoreLabel();
        }

    }

    private void updateButton(int row, int col) {
        Button button = getButtonAt(row, col);
        button.setText(String.valueOf(model.getActivePlayer()));
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


 public void resetGame(){
     for (int row = 0; row < 3; row++) {
         for (int col = 0; col < 3; col++) {
             Button button = getButtonAt(row, col);
             assert button != null;
             button.setText("");
             button.setDisable(false);
         }
     }
     model.resetGameState(); // Återställ spelstatusen inom samma instans av Model
     updateScoreLabel(); // Uppdatera poängen

 }


    public void updateScoreLabel() {
        System.out.println("update score LAbel");
        scoreLabel.setText("Player X: " + model.getPlayerXScore() + " | Player O: " + model.getPlayerOScore());
        System.out.println("Player X Score: " + model.getPlayerXScore());
        System.out.println("Player O Score: " + model.getPlayerOScore());
    }


}








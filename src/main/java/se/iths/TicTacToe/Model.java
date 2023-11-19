package se.iths.TicTacToe;


import javafx.scene.control.Alert;


import java.util.Random;

public class Model {

    private final char[][] board;
    private char activePlayer;

    private int playerXScore = 0;
    private int playerOScore = 0;


    public Model() {
        board = new char[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }

        activePlayer = 'X';

    }


    public int getPlayerXScore() {
        return playerXScore;
    }

    public int getPlayerOScore() {
        return playerOScore;
    }


    public char getActivePlayer() {
        return activePlayer;
    }


    public void flipPlayer() {

        activePlayer = (activePlayer == 'X') ? 'O' : 'X';
    }


    public boolean makeMove(int row, int col) {
        if (board[row][col] == ' ') {
            board[row][col] = activePlayer;
            return true;
        }
        return false;
    }

    public boolean checkWin() {
        for (int row = 0; row < 3; row++) {
            if (board[row][0] != ' ' && board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
                return true;
            }
        }
        for (int col = 0; col < 3; col++) {
            if (board[0][col] != ' ' && board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
                return true;
            }
        }
        if (board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        }
        if (board[0][2] != ' ' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }

    public boolean checkDraw() { //Kollar om det är oavgjort,kollar tomma positioner
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public int[] makeComputerMove() {
        int[] move = new int[2];
        Random random = new Random();
        boolean found = false;


        if (activePlayer == 'O') {
            while (!found) {
                int row = random.nextInt(3);
                int col = random.nextInt(3);
                if (board[row][col] == ' ') {
                    board[row][col] = 'O';
                    move[0] = row;
                    move[1] = col;
                    found = true;
                }
            }
        }

        return move;
    }


    public void showResult(String message, HelloController controller) {




        System.out.println("Received message: " + message);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText(message);

        if (message.contains("X wins")) {
            playerXScore++;
            System.out.println("Player X Score: "+playerXScore);

        } else if (message.contains("O wins")) {
            playerOScore++;
            System.out.println("Player O Score; "+playerOScore);

        }
        alert.showAndWait();
        controller.updateScoreLabel();



    }


    public void resetGameState() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
        activePlayer = 'X';
    }


}





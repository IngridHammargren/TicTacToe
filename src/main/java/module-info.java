module se.iths.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;


    opens se.iths.TicTacToe to javafx.fxml;
    exports se.iths.TicTacToe;
}
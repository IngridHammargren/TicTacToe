package se.iths.TicTacToe;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

   private GameModel gameModel;

    @BeforeEach
    public void setUp(){
        gameModel = new GameModel();
    }

    @Test
    void testValidMove() {
        assertEquals('X', gameModel.getActivePlayer());
    }

    @Test
    void testInvalidMove() {
        assertFalse(gameModel.makeMove(0, 0));
    }

    @Test
    void testWin() {
        GameModel gameModel = new GameModel();
        gameModel.makeMove(0, 0);
        gameModel.makeMove(1, 1);
        gameModel.makeMove(0, 1);
        gameModel.makeMove(1, 2);
        gameModel.makeMove(0, 2);

        assertTrue(gameModel.checkWin());
    }

    @Test
    void testDraw() {
        GameModel gameModel = new GameModel();

        gameModel.makeMove(0, 0);
        gameModel.makeMove(0, 1);
        gameModel.makeMove(0, 2);
        gameModel.makeMove(1, 0);
        gameModel.makeMove(1, 2);
        gameModel.makeMove(1, 1);
        gameModel.makeMove(2, 0);
        gameModel.makeMove(2, 2);
        gameModel.makeMove(2, 1);

        assertTrue(gameModel.checkDraw());
    }


    }




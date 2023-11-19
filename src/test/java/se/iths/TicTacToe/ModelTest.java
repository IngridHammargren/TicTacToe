package se.iths.TicTacToe;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

   private Model model;

    @BeforeEach
    public void setUp(){
        model = new Model();
    }

    @Test
    void testValidMove() {
        assertEquals('X', model.getActivePlayer());
    }

    @Test
    void testInvalidMove() {
        assertFalse(model.makeMove(0, 0));
    }

    @Test
    void testWin() {
        Model model = new Model();
        model.makeMove(0, 0);
        model.makeMove(1, 1);
        model.makeMove(0, 1);
        model.makeMove(1, 2);
        model.makeMove(0, 2);

        assertTrue(model.checkWin());
    }

    @Test
    void testDraw() {
        Model model = new Model();

        model.makeMove(0, 0);
        model.makeMove(0, 1);
        model.makeMove(0, 2);
        model.makeMove(1, 0);
        model.makeMove(1, 2);
        model.makeMove(1, 1);
        model.makeMove(2, 0);
        model.makeMove(2, 2);
        model.makeMove(2, 1);

        assertTrue(model.checkDraw());
    }


    }




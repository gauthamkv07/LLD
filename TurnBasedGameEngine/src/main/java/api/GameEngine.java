package api;

import game.*;
import boards.TicTacToeBoard;

public class GameEngine {

    public Board start(String type) {
        if (type.equals("TicTacToe")) {
            return new TicTacToeBoard();
        }
        throw new IllegalArgumentException();
    }

    public void move(Board board, Move move) {
        if (board instanceof TicTacToeBoard) {
            board.move(move);
            return;
        }
        throw new IllegalArgumentException();
    }

}


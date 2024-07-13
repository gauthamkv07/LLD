import api.GameEngine;
import game.Board;
import game.Player;
import game.Cell;
import game.Move;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameEngine gameEngine = new GameEngine();
        Board board = gameEngine.start("TicTacToe");
        int row, col;
        Player computer = new Player("O"), opponent = new Player("X");

        while (!gameEngine.isComplete(board).isOver()) {
            System.out.println("Make your move");
            System.out.print(board);
            row = scanner.nextInt();
            col = scanner.nextInt();
            Move oppMove = new Move(new Cell(row, col));
            gameEngine.move(board, opponent, oppMove);
            if (!gameEngine.isComplete(board).isOver()) {
                Move computerMove = gameEngine.suggestMove(computer, board);
                gameEngine.move(board, computer, computerMove);
            }
        }
        System.out.println("GameResult: " + gameEngine.isComplete(board));
        System.out.print(board);
    }
}
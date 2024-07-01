import java.util.Scanner;

import gameEnigne.GameEngine;
import game.Board;
import game.Cell;
import game.Move;
import game.Player;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameEngine gameEngine = new GameEngine();
        Board board = gameEngine.gameEngineStart("TicTacToe");
        Player computer = new Player("O"), player = new Player("X");

        while (!gameEngine.isGameCompleate(board).isOver()) {
            System.out.println("Make your move!");
            System.out.println(board);
            int row = scanner.nextInt(), col = scanner.nextInt();
            Move oppMove = new Move(new Cell(row, col));
            gameEngine.makeMove(board,oppMove, player);
            if (!gameEngine.isGameCompleate(board).isOver()) {
                gameEngine.suggestMove(board, computer);
            }
        }
        System.out.println("Game Result:" + gameEngine.isGameCompleate(board));
        System.out.println(board);

        scanner.close();
    }
}

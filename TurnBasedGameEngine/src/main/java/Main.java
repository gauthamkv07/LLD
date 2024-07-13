import api.AIPlayer;
import api.GameEngine;
import api.RuleEngine;
import game.Board;
import game.Player;
import game.Cell;
import game.Move;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameEngine gameEngine = new GameEngine();
        AIPlayer aiPlayer = new AIPlayer();
        RuleEngine ruleEngine = new RuleEngine();
        Board board = gameEngine.start("TicTacToe");
        int row, col;
        Player computer = new Player("O"), human = new Player("X");

        while (!ruleEngine.getState(board).isOver()) {
            System.out.println("Make your move");
            System.out.print(board);
            row = scanner.nextInt();
            col = scanner.nextInt();
            Move oppMove = new Move(human, new Cell(row, col));
            gameEngine.move(board, oppMove);
            if (!ruleEngine.getState(board).isOver()) {
                Move computerMove = aiPlayer.suggestMove(computer, board);
                gameEngine.move(board, computerMove);
            }
        }
        System.out.println("GameResult: " + ruleEngine.getState(board));
        System.out.print(board);
    }
}
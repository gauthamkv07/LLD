import api.AIEngine;
import api.GameEngine;
import api.RuleEngine;
import game.Board;
import game.Cell;
import game.Move;
import game.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GamePlayTest {

    GameEngine gameEngine;
    AIEngine aiEngine;
    RuleEngine ruleEngine;
    Player computer, human;
    Board board;

    @Before
    public void setup() {
        gameEngine = new GameEngine();
        aiEngine = new AIEngine();
        ruleEngine = new RuleEngine();
        computer = new Player("O");
        human = new Player("X");
        board = gameEngine.start("TicTacToe");
    }

    @Test
    public void checkForRowWin() {
        int moves[][] = new int[][]{{1, 0}, {1, 1}, {1, 2}};
        playGame(moves);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForColWin() {
        int moves[][] = new int[][]{{0, 0}, {1, 0}, {2, 0}};
        playGame(moves);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForDiagWin() {
        int moves[][] = new int[][]{{0, 0}, {1, 1}, {2, 2}};
        playGame(moves);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForRevDiagWin() {
        int moves[][] = new int[][]{{0, 2}, {1, 1}, {2, 0}};
        playGame(moves);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "X");
    }

    @Test
    public void checkForComputerWin() {
        int moves[][] = new int[][]{{1, 0}, {1, 1}, {2, 0}};
        playGame(moves);
        Assert.assertTrue(ruleEngine.getState(board).isOver());
        Assert.assertEquals(ruleEngine.getState(board).getWinner(), "O");
    }

    private void playGame(int[][] moves) {
        int row, col, next = 0;
        while (!ruleEngine.getState(board).isOver()) {
            row = moves[next][0];
            col = moves[next][1];
            next++;
            Move oppMove = new Move(human, new Cell(row, col));
            gameEngine.move(board, oppMove);
            if (!ruleEngine.getState(board).isOver()) {
                Move computerMove = aiEngine.suggestMove(computer, board);
                gameEngine.move(board, computerMove);
            }
        }
    }
}
package api;

import boards.TicTacToeBoard;
import game.Board;
import game.GameResult;

public class RuleEngine {

    public GameResult getState(Board board) {
        if (board instanceof TicTacToeBoard) {
            String firstCharacter = "-";
            TicTacToeBoard board1 = (TicTacToeBoard) board;

            boolean rowComplete = true;
            for (int i = 0; i < 3; i++) {
                firstCharacter = board1.getCell(i, 0);
                rowComplete = firstCharacter != null;
                if (!rowComplete) continue;
                for (int j = 1; j < 3; j++) {
                    if (!firstCharacter.equals(board1.getCell(i, j))) {
                        rowComplete = false;
                        break;
                    }
                }
                if (rowComplete) break;
            }

            if (rowComplete) return new GameResult(true, firstCharacter);

            boolean colComplete = true;
            for (int i = 0; i < 3; i++) {
                firstCharacter = board1.getCell(0, i);
                colComplete = firstCharacter != null;
                if (!colComplete) continue;
                for (int j = 1; j < 3; j++) {
                    if (!firstCharacter.equals(board1.getCell(j, i))) {
                        colComplete = false;
                        break;
                    }
                }
                if (colComplete) break;
            }

            if (colComplete) return new GameResult(true, firstCharacter);

            firstCharacter = board1.getCell(0, 0);
            boolean diagComplete = firstCharacter != null;
            if (diagComplete) {
                for (int i = 1; i < 3; i++) {
                    if (!firstCharacter.equals(board1.getCell(i, i))) {
                        diagComplete = false;
                        break;
                    }
                }
            }

            if (diagComplete) return new GameResult(true, firstCharacter);

            firstCharacter = board1.getCell(0, 2);
            boolean revDiagComplete = firstCharacter != null;
            if (revDiagComplete) {
                for (int i = 1; i < 3; i++) {
                    if (!firstCharacter.equals(board1.getCell(i, 2 - i))) {
                        revDiagComplete = false;
                        break;
                    }
                }
            }

            if (revDiagComplete) return new GameResult(true, firstCharacter);

            int countFilledCells = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board1.getCell(i, j) != null) countFilledCells++;
                }
            }

            if (countFilledCells == 9) return new GameResult(true, "-");

            return new GameResult(false, "-");
        }
        return new GameResult(false, "");
    }
}

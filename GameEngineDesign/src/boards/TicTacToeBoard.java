package boards;

import game.Board;
import game.Cell;

public class TicTacToeBoard extends Board {
    String cells[][] = new String[3][3];

    public String getCell(int row, int col) {
        return cells[row][col];
    }

    public void setCell(Cell cell, String symbol) {
        cells[cell.getRow()][cell.getCol()] = symbol;
    }

    public String toString() {
        String res = "";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) res += cells[i][j] == null? "-": cells[i][j];
            res += "\n";
        }
        return res;
    }
}

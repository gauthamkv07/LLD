package boards;

import game.Board;

public class TicTacToeBoard  extends Board{
    private String[][] cells;

    public TicTacToeBoard() {
        cells = new String[3][3];
    }

    public void setCell(int i, int j, String val) {
        cells[i][j] = val;
    }

    public String getCell(int i, int j) {
        return cells[i][j];
    }

    public String toString() {
        String res = "";
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                res += cells[i][j] == null? "-": cells[i][j];
                res += " ";
            }
            res+="\n";
        }
        return res;
    }
}

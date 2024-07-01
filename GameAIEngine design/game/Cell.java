package game;

public class Cell {

    int row, col;

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

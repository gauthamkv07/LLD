package game;

public class GameResult {
    private boolean isOver;
    private String winner;

    public GameResult(boolean isOver, String winner) {
        this.isOver = isOver;
        this.winner = winner;
    }

    public boolean isOver() {
        return isOver;
    }

    public void setOver(boolean over) {
        isOver = over;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String toString() {
        return "GameResult{isOver =" + isOver + ", winner=" + winner + "}";
    }
}

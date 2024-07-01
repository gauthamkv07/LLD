package game;

public class GameResult {
    public boolean isOver;
    
    public boolean isOver() {
        return isOver;
    }

    public void setOver(boolean isOver) {
        this.isOver = isOver;
    }

    public String winner;

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public GameResult(boolean isOver, String winner) {
        this.isOver = isOver;
        this.winner = winner;
    }

    public String toString() {
        return "{isOver=" + isOver + ", winner = " + winner.toString() + "}"; 
    }
}

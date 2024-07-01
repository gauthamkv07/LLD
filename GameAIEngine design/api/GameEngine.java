package api;

import game.*;
import boards.*;

public class GameEngine {
    public static void main(String args[]) {
        
    }

    public Board start(String type) {
        if(type.equals("TicTacToe")) return new TicTacToeBoard();
        else throw new IllegalArgumentException();
    }

    public void move(Board board, Player player, Move move) {
        if(board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            board1.setCell(move.getCell(), player.symbol());
            return;
        }
        throw new IllegalArgumentException();
    }

    public GameResult isComplete(Board board) {
        if(board instanceof TicTacToeBoard) {

            boolean rowComplete = true, colComplete = true, diagComplete = true, revDiagComplete = true;
            String firstCharacter = "";
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            for(int i = 0; i < 3; i++) {
                firstCharacter = board1.getCell(i,0);
                rowComplete = firstCharacter != null;
                if(firstCharacter == null) continue;
                for(int j = 1; j < 3; j++) {
                    if(!firstCharacter.equals(board1.getCell(i,j))) {
                        rowComplete = false;
                        break;
                    }
                }

                if(rowComplete) break;
            }

            if(rowComplete) return new GameResult(true,firstCharacter);

            for(int i = 0; i < 3; i++) {
                firstCharacter = board1.getCell(0,i);
                colComplete = firstCharacter != null;
                if(firstCharacter == null) continue;
                for(int j = 1; j < 3; j++) {
                    if(!firstCharacter.equals(board1.getCell(j,i))) {
                        colComplete = false;
                        break;
                    }
                }

                if(colComplete) break;
            }

            if(colComplete) return new GameResult(true,firstCharacter);

            firstCharacter = board1.getCell(0,0);
            diagComplete = firstCharacter != null;
            for(int i = 1; i < 3; i++) {
                if(firstCharacter != null && !firstCharacter.equals(board1.getCell(i,i))) {
                    diagComplete = false;
                    break;
                }
            }

            if(diagComplete) return new GameResult(true, firstCharacter);

            firstCharacter = board1.getCell(0,2);
            revDiagComplete = firstCharacter != null;
            for(int i = 1; i < 3; i++) {
                if(firstCharacter != null && !firstCharacter.equals(board1.getCell(i,2-i))) {
                    revDiagComplete = false;
                    break;
                }
            }

            if(revDiagComplete) return new GameResult(true, firstCharacter);

            int count = 0;
            for(int i = 0; i < 3; i++) for(int j = 0; j < 3; j++) if(board1.getCell(i,j) != null) count++;

            if(count == 9) return new GameResult(true, "-");

            return new GameResult(false, "-");
        }
        return new GameResult(false, "-");
    }

    public Move suggestMove(Player computer, Board board) {
        if(board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(board1.getCell(i, j) == null) return new Move(new Cell(i,j));
                }
            }
            throw new IllegalStateException();
        }
        throw new IllegalArgumentException();
    }
}



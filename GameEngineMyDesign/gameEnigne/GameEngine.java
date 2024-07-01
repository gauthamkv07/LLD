package gameEnigne;

import boards.TicTacToeBoard;
import game.*;

public class GameEngine {
    
    public Board gameEngineStart(String type) {
        if(type.equals("TicTacToe")) return new TicTacToeBoard();
        throw new IllegalArgumentException();
    }

    public void makeMove(Board board, Move move, Player player) {
        if(board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            board1.setCell(move.cell.getRow(), move.cell.getCol(), player.symbol());
            return;
        }
        throw new IllegalArgumentException();
    }

    public void suggestMove(Board board, Player player) {
        if(board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;

            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++) {
                    if(board1.getCell(i, j) == null) {
                        Cell cell = new Cell(i,j);
                        Move move = new Move(cell);
                        board1.setCell(move.cell.getRow(), move.cell.getCol(), player.symbol());
                        return;
                    }
                }
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public GameResult isGameCompleate(Board board) {
        if(board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;

            boolean rowComplete = true;

            String firstCharacter = "";
            
            for(int i = 0; i < 3; i++){
                firstCharacter = board1.getCell(i, 0);
                rowComplete =  firstCharacter != null;
                if(firstCharacter == null) continue;
                for(int j = 1; j < 3; j++) {
                    if(!firstCharacter.equals(board1.getCell(i, j))) rowComplete = false;
                }
                if(rowComplete) return new GameResult(true, firstCharacter);
            }

            boolean colComplete = true;

            for(int i = 0; i < 3; i++) {
                firstCharacter = board1.getCell(0, i);
                colComplete =  firstCharacter != null;
                if(firstCharacter == null) continue;
                for(int j = 1; j < 3; j++) {
                    if(!firstCharacter.equals(board1.getCell(j, i))) colComplete = false;
                }
                if(colComplete) return new GameResult(true, firstCharacter);
            }

            boolean diagComplete = true;

            firstCharacter = board1.getCell(0, 0);
            diagComplete = firstCharacter != null;
            if(firstCharacter != null) {
                for(int i = 1; i < 3; i++) {
                    if(!firstCharacter.equals(board1.getCell(i, i))) diagComplete = false;
                }
            }

            if(diagComplete) return new GameResult(true, firstCharacter);

            firstCharacter = board1.getCell(0,2);
            diagComplete = firstCharacter != null;

            if(firstCharacter != null) {
                for(int i = 1; i < 3; i++) {
                    if(!firstCharacter.equals(board1.getCell(i, 2-i))) diagComplete = false;
                }
            }

            if(diagComplete) return new GameResult(true, firstCharacter);

            return new GameResult(false, firstCharacter); 
        }
        throw new IllegalArgumentException();
    }
}

package Chess.ChessPieces;

import BoardGame.Board;
import Chess.ChessPiece;
import Chess.ColorEnum;

public class King extends ChessPiece{

    public King(Board board, ColorEnum color) {
        super(board, color);
    }
    
    @Override
    public String toString(){
        return "K";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        return mat;
    }
}

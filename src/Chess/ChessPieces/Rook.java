package Chess.ChessPieces;

import BoardGame.Board;
import Chess.ChessPiece;
import Chess.ColorEnum;

public class Rook extends ChessPiece{

    public Rook(Board board, ColorEnum color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "R";
    }
    
}

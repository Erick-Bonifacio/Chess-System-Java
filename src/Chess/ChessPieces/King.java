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
}

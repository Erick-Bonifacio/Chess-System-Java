package Chess;

import BoardGame.Board;
import BoardGame.Piece;

public abstract class ChessPiece extends Piece{
    
    private ColorEnum color;

    public ChessPiece(Board board, ColorEnum color){
        super(board);
        this.color = color;
    }

    public ColorEnum getColor() {
        return color;
    }

        
}

package Chess;

import BoardGame.Board;
import BoardGame.Piece;
import BoardGame.Position;

public abstract class ChessPiece extends Piece{
    
    private ColorEnum color;

    public ChessPiece(Board board, ColorEnum color){
        super(board);
        this.color = color;
    }

    public ColorEnum getColor() {
        return color;
    }

    protected boolean isThereOpponentPiece(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != color;
    } 
}

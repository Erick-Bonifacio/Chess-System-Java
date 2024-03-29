package Chess;

import BoardGame.Board;
import BoardGame.Piece;
import BoardGame.Position;

public abstract class ChessPiece extends Piece{
    
    private ColorEnum color;
    private int moveCount;

    public ChessPiece(Board board, ColorEnum color){
        super(board);
        this.color = color;
    }

    public ColorEnum getColor() {
        return color;
    }

    public void increaseMoveCount(){
        moveCount++;
    }

    public void decreaseMoveCount(){
        moveCount--;
    }

    public int getMoveCount(){
        return moveCount;
    }

    public ChessPosition getChessPosition(){
        return ChessPosition.fromPosition(position);
    }

    protected boolean isThereOpponentPiece(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p != null && p.getColor() != color;
    } 
}

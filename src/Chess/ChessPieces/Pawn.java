package Chess.ChessPieces;

import BoardGame.Board;
import BoardGame.Position;
import Chess.ChessPiece;
import Chess.ColorEnum;

public class Pawn extends ChessPiece {

    public Pawn(Board board, ColorEnum color) {
        super(board, color);
    }

    @Override
    public String toString(){
        return "P";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        
        Position p = new Position(0, 0);

        if(getColor() == ColorEnum.WHITE){

            p.setValues(position.getRow() -1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
                p.setValues(position.getRow() -2, position.getColumn());
                if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0){
                mat[p.getRow()][p.getColumn()] = true;
                }
            }

            p.setValues(position.getRow() -1, position.getColumn() -1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() -1, position.getColumn() +1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
        }
        else{
            p.setValues(position.getRow() +1, position.getColumn());
            if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
                p.setValues(position.getRow() +2, position.getColumn());
                if(getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getMoveCount() == 0){
                mat[p.getRow()][p.getColumn()] = true;
                }
            }

            p.setValues(position.getRow() +1, position.getColumn() -1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() +1, position.getColumn() +1);
            if(getBoard().positionExists(p) && isThereOpponentPiece(p)){
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        return mat;
    }
    
    

}
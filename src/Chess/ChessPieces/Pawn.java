package Chess.ChessPieces;

import BoardGame.Board;
import BoardGame.Position;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ColorEnum;

public class Pawn extends ChessPiece {

    private ChessMatch chessMatch;
    private boolean enPassantVulnerablePiece = false;

    public void setEnPassantVulnerablePiece(boolean value){
        enPassantVulnerablePiece = value;
    }

    public boolean getEnPassantVulnerablePiece(){
        return enPassantVulnerablePiece;
    }

    public Pawn(Board board, ColorEnum color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
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

            //Enpassant white
            if(position.getRow() == 3){
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()){
                    mat[left.getRow()-1][left.getColumn()] = true;
                    }
                
            
                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()){
                    mat[right.getRow()-1][right.getColumn()] = true;   
                }
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

            //Enpassant black
            if(position.getRow() == 4){
                Position left = new Position(position.getRow(), position.getColumn() - 1);
                if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()){
                        mat[left.getRow()+1][left.getColumn()] = true;
                }
            
                Position right = new Position(position.getRow(), position.getColumn() + 1);
                if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()){
                    mat[right.getRow()+1][right.getColumn()] = true;
                }
            }
        }

        return mat;
    }
    
    

}
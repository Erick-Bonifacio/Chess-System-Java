package Chess;

import BoardGame.Board;
import BoardGame.Piece;
import BoardGame.Position;
import Chess.ChessPieces.King;
import Chess.ChessPieces.Rook;
import javafx.scene.paint.Color;

public class ChessMatch{
    
    private Board board;

    public ChessMatch(){
        board = new Board(8, 8);
        initialSetup();
    }
        
    public ChessPiece[][] getPieces(){
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for(int i = 0; i <board.getRows(); i++){
            for(int j = 0; j < board.getColumns(); j++){
                mat[i][j] = (ChessPiece) board.piece(i, j);
            }
        }
        return mat;
    }
    
    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        Piece capturedPiece = makeMove(source, target);
        return (ChessPiece) capturedPiece; 
    }

    private void validateSourcePosition(Position position){
        if (!board.thereIsAPiece(position)){
            throw new ChessException("There is no piece on source position");
        }

    }

    private Piece makeMove(Position source, Position target){
        Piece p = board.removePiece(source);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);
        return capturedPiece;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece){
        board.placePiece((piece), new ChessPosition(column, row).toPosition());
    }

    private void initialSetup(){
        placeNewPiece('c', 1, new Rook(board, ColorEnum.WHITE));
        placeNewPiece('c', 2, new Rook(board, ColorEnum.WHITE));
        placeNewPiece('d', 2, new Rook(board, ColorEnum.WHITE));
        placeNewPiece('e', 2, new Rook(board, ColorEnum.WHITE));
        placeNewPiece('e', 1, new Rook(board, ColorEnum.WHITE));
        placeNewPiece('d', 1, new King(board, ColorEnum.WHITE));

        placeNewPiece('c', 7, new Rook(board, ColorEnum.BLACK));
        placeNewPiece('c', 8, new Rook(board, ColorEnum.BLACK));
        placeNewPiece('d', 7, new Rook(board, ColorEnum.BLACK));
        placeNewPiece('e', 7, new Rook(board, ColorEnum.BLACK));
        placeNewPiece('e', 8, new Rook(board, ColorEnum.BLACK));
        placeNewPiece('d', 8, new King(board, ColorEnum.BLACK));
    }
}
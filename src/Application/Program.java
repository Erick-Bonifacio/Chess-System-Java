package Application;

import java.util.Scanner;

import BoardGame.Board;
import BoardGame.Position;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition; 

public class Program {

    public static void main(String[] args){

        ChessMatch chessMatch = new ChessMatch();
        Scanner sc = new Scanner(System.in);
        
        while(true){
            UI.printBoard(chessMatch.getPieces());
            System.out.println();
            System.out.println("Source:");
            ChessPosition source = UI.readChessPosition(sc);
            System.out.println();
            System.out.println("Target:");
            ChessPosition target = UI.readChessPosition(sc);

            ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
        }

    }
}

package Application;

import java.util.InputMismatchException;
import java.util.Scanner;

import BoardGame.Board;
import BoardGame.Position;
import Chess.ChessException;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition; 

public class Program {

    public static void main(String[] args){

        ChessMatch chessMatch = new ChessMatch();
        Scanner sc = new Scanner(System.in);
        
        while(true){
            try{
                UI.clearScreen();
                System.out.println();
                UI.printBoard(chessMatch.getPieces());
                System.out.println();
                System.out.println("Source:");
                ChessPosition source = UI.readChessPosition(sc);
                System.out.println();
                System.out.println("Target:");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            }
            catch(ChessException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
            catch(InputMismatchException e){
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }

    }
}

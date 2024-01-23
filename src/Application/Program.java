package Application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


import Chess.ChessException;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition; 

public class Program {

    public static void main(String[] args){

        ChessMatch chessMatch = new ChessMatch();
        Scanner sc = new Scanner(System.in);
        List<ChessPiece> captured = new ArrayList<>();
        
        
        while(!chessMatch.getCheckMate()){
            try{
                UI.clearScreen();
                System.out.println();
                UI.printMatch(chessMatch, captured);
                System.out.println();
                System.out.println("Source:");
                ChessPosition source = UI.readChessPosition(sc);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                System.out.println();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);
                
                System.out.println();
                System.out.println("Target:");
                ChessPosition target = UI.readChessPosition(sc);

                ChessPiece capturedPiece = chessMatch.performChessMove(source, target);
            
                if(capturedPiece != null){
                    captured.add(capturedPiece);
                }
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
        System.out.println();
        UI.clearScreen();
        UI.printMatch(chessMatch, captured);
    }
}

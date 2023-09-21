package com.game.tictactoe;

import ch.qos.logback.core.joran.sanity.Pair;
import com.game.tictactoe.entities.Board;
import com.game.tictactoe.entities.Player;
import com.game.tictactoe.entities.piece.PlayingPiece;
import com.game.tictactoe.entities.piece.PlayingPieceO;
import com.game.tictactoe.entities.piece.PlayingPieceX;
import lombok.NoArgsConstructor;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

@NoArgsConstructor
public class TicTacToeGame {

    Deque<Player> players;
    Board gameBoard;

    /**
     * Method to initialize tic-tac-toe game
     */
    public void initializeGame() {

        players = new LinkedList<>();
        PlayingPiece crossPiece = new PlayingPieceX();
        Player player1 = new Player("Player1", crossPiece);

        PlayingPiece noughtsPiece = new PlayingPieceO();
        Player player2 = new Player("Player2", noughtsPiece);

        players.add(player1);
        players.add(player2);

        //initializeBoard
        gameBoard = new Board(3);

    }

    /**
     * Method to start tic-tac-toe game
     * @return
     */
    public String startGame() {
        boolean noWinner = true;
        while(noWinner){

            //take out the player whose turn is and also put the player in the list back
            Player playerTurn = players.removeFirst();

            //get the free space from the board
            gameBoard.printBoard();
            List<Pair<Integer, Integer>> freeSpaces =  gameBoard.getFreeCells();
            if(freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }

            //read the user input
            System.out.print("Player:" + playerTurn.name + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            long inputRow = Integer.valueOf(values[0]);
            long inputColumn = Integer.valueOf(values[1]);

            //place the piece
            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow,inputColumn, playerTurn.playingPiece);
            if(!pieceAddedSuccessfully) {
                //player can not insert the piece into this cell, player has to choose another cell
                System.out.println("Incorrect position chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean winner = isThereWinner(inputRow, inputColumn, playerTurn.getPlayingPiece());
            if(winner) {
                return playerTurn.name;
            }
        }

        return "tie";

    }

    private boolean isThereWinner(long inputRow, long inputColumn, PlayingPiece playingPiece) {
        // TODO - Add logic for checking winner
        return false;
    }
}

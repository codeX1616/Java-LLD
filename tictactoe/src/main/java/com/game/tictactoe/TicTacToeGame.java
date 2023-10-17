package com.game.tictactoe;

import com.game.tictactoe.entities.Board;
import com.game.tictactoe.entities.Player;
import com.game.tictactoe.entities.piece.PieceType;
import com.game.tictactoe.entities.piece.PlayingPiece;
import com.game.tictactoe.entities.piece.PlayingPieceO;
import com.game.tictactoe.entities.piece.PlayingPieceX;
import lombok.NoArgsConstructor;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

@NoArgsConstructor
public class TicTacToeGame {

    Deque<Player> players;
    Board gameBoard;

    static {
        TicTacToeGame game = new TicTacToeGame();
        game.initializeGame();
        System.out.println("Winner of game is:" + game.startGame());
    }

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
     * @return {@link String}
     */
    public String startGame() {
        boolean noWinner = true;
        while(noWinner){

            //take out the player whose turn is and also put the player in the list back
            Player playerTurn = players.removeFirst();

            //get the free space from the board
            gameBoard.printBoard();
            Map<Integer, Integer> freeSpaces =  gameBoard.getFreeCells();
            if(freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }

            //read the user input
            System.out.print("Player:" + playerTurn.name + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);

            //place the piece
            boolean pieceAddedSuccessfully = gameBoard.addPiece(inputRow,inputColumn, playerTurn.playingPiece);
            if(!pieceAddedSuccessfully) {
                //player can not insert the piece into this cell, player has to choose another cell
                System.out.println("Incorrect position chosen, try again");
                players.addFirst(playerTurn);
                continue;
            }
            players.addLast(playerTurn);

            boolean winner = isThereWinner(inputRow, inputColumn, playerTurn.getPlayingPiece().pieceType);
            if(winner) {
                return playerTurn.name;
            }
        }

        return "tie";

    }

    /**
     * Method to decide if there is a winner
     * @param row {@link int}
     * @param column {@link int}
     * @param pieceType {@link PieceType}
     * @return boolean
     */
    private boolean isThereWinner(int row, int column, PieceType pieceType) {

        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antiDiagonalMatch = true;

        //need to check in row
        for(int i=0;i<gameBoard.size;i++) {
            if(gameBoard.board[row][i] == null || gameBoard.board[row][i].pieceType != pieceType) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<gameBoard.size;i++) {
            if(gameBoard.board[i][column] == null || gameBoard.board[i][column].pieceType != pieceType) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0, j=0; i<gameBoard.size;i++,j++) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0, j=gameBoard.size-1; i<gameBoard.size;i++,j--) {
            if (gameBoard.board[i][j] == null || gameBoard.board[i][j].pieceType != pieceType) {
                antiDiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antiDiagonalMatch;
    }
}

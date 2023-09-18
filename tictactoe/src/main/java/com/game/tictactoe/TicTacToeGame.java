package com.game.tictactoe;

import com.game.tictactoe.entities.Board;
import com.game.tictactoe.entities.Player;
import com.game.tictactoe.entities.piece.PlayingPiece;
import com.game.tictactoe.entities.piece.PlayingPieceO;
import com.game.tictactoe.entities.piece.PlayingPieceX;
import lombok.NoArgsConstructor;

import java.util.Deque;
import java.util.LinkedList;

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
        return "";
    }
}

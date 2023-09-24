package com.game.tictactoe.entities;

import ch.qos.logback.core.joran.sanity.Pair;
import com.game.tictactoe.entities.piece.PlayingPiece;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Board {

    public int size;
    public PlayingPiece[][] board;

    public Board(int size) {
        this.size = size;
    }

    /**
     * Method to print current tic-tac-toe board
     */
    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();
        }
    }

    public List<Pair<Integer, Integer>>  getFreeCells() {
        // TODO - Add logic to get free cells of board
        return List.of();
    }

    public boolean addPiece(long inputRow, long inputColumn, PlayingPiece playingPiece) {
        return false;
    }
}

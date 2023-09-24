package com.game.tictactoe.entities;

import ch.qos.logback.core.joran.sanity.Pair;
import com.game.tictactoe.entities.piece.PlayingPiece;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * Method to get free cells map
     * @return
     */
    public Map<Integer, Integer>  getFreeCells() {
        List<Pair<Integer, Integer>> freeCells = new ArrayList<>();
        Map<Integer, Integer> rowColumn = new HashMap<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == null) {
                    rowColumn = Map.ofEntries(
                            Map.entry(i, j)
                    );
                }
            }
        }

        return rowColumn;
    }

    public boolean addPiece(long inputRow, long inputColumn, PlayingPiece playingPiece) {
        return false;
    }
}

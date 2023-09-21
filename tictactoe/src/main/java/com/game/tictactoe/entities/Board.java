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

    public void printBoard() {
        // TODO - Add logic to print board
    }

    public List<Pair<Integer, Integer>>  getFreeCells() {
        // TODO - Add logic to get free cells of board
        return List.of();
    }

    public boolean addPiece(long inputRow, long inputColumn, PlayingPiece playingPiece) {
        return false;
    }
}

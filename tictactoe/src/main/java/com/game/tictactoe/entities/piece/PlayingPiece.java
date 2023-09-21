package com.game.tictactoe.entities.piece;

import lombok.AllArgsConstructor;

/**
 * Abstraction to support playing piece type information through class name
 */
@AllArgsConstructor
public abstract class PlayingPiece {
    public PieceType pieceType;
}
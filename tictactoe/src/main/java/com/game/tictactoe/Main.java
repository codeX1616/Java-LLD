package com.game.tictactoe;

public class Main {

    public static void main(String args[]) {
        TicTacToeGame game = new TicTacToeGame();
        game.initializeGame();
        System.out.println("Winner of game is:" + game.startGame());
    }

}

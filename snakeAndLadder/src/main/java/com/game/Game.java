package com.game;

import com.gameEntities.Board;
import com.gameEntities.Cell;
import com.gameEntities.Dice;
import com.gameEntities.Player;

import java.util.Deque;
import java.util.LinkedList;

public class Game {

    static {
        System.out.println("In Game method!");
        Game gameObj = new Game();
        gameObj.startGame();
    }

    private Board board;
    private Dice dice;
    private Deque<Player> playerList;
    private Player winner;

    /**
     * Game initializer constructor
     */
    public Game() {
        intializeGame();
    }

    /**
     * Game initializer method
     */
    private void intializeGame() {
        System.out.println("Initializing game");
        board = new Board(10, 5, 4);
        dice = new Dice(1);
        winner = null;
        initializePlayers();
    }

    /**
     * Players initializer method
     */
    private void initializePlayers() {
        Player p1 = new Player("p1", 0);
        Player p2 = new Player("p2", 0);
        playerList = new LinkedList<>();
        playerList.add(p1);
        playerList.add(p2);
    }

    /**
     * Game start method
     */
    public void startGame() {
        while (winner == null) {
            Player playerTurn = findPlayerTurn();
            System.out.println("Player turn is: " + playerTurn.getId() + " current position is: " + playerTurn.getCurrentPosition());
            int diceNumbers = dice.rollDice();

            int playerNewPosition = playerTurn.getCurrentPosition() + diceNumbers;
            playerNewPosition = jumpCheck(playerNewPosition);
            playerTurn.setCurrentPosition(playerNewPosition);
            System.out.println("Player turn is: " + playerTurn.getId() + " new Position is: " + playerNewPosition);

            int numberOfCells = board.getCells().length;
            if (playerNewPosition >= (numberOfCells * numberOfCells - 1)) {
                winner = playerTurn;
            }
        }
        System.out.println("Winner is: " + winner.getId());
    }

    /**
     * Method to check jump operation
     * @param playerNewPosition {@link int}
     */
    private int jumpCheck(int playerNewPosition) {
        if (playerNewPosition > board.getCells().length - 1)
            return playerNewPosition;
        Cell cell = board.getCell(playerNewPosition);
        if (cell.getJump()!=null && cell.getJump().getStart() == playerNewPosition) {
            String jumpBy = (cell.getJump().getStart() < cell.getJump().getEnd()) ? "ladder" : "snake";
            System.out.println("jump done by " + jumpBy);
            return cell.getJump().getEnd();
        }
        return -1;
    }

    /**
     * Method to find player turn
     */
    private Player findPlayerTurn() {
        Player playerTurns = playerList.removeFirst();
        playerList.addLast(playerTurns);
        return playerTurns;
    }
}

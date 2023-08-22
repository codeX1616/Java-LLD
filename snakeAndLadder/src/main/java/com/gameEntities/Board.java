package com.gameEntities;

import lombok.Getter;

import java.util.concurrent.ThreadLocalRandom;

@Getter
public class Board {
    private Cell[][] cells;

    /**
     * Snake and Ladder Board initializer constructor
     * @param boardSize
     * @param numberOfSnakes
     * @param numberOfLadders
     */
    public Board(int boardSize, int numberOfSnakes, int numberOfLadders) {
        System.out.println("Initializing cells");
        initializeCells(boardSize);
        addSnakesAndLadders(cells, numberOfSnakes, numberOfLadders);
    }

    /**
     * Initialize empty board cells
     * @param boardSize
     */
    private void initializeCells(int boardSize) {
        cells = new Cell[boardSize][boardSize];
        for (int i=0;i<boardSize;i++)
            for (int j=0;j<boardSize;j++)
                cells[i][j] = new Cell();
    }

    /**
     * Add snakes and ladders to board cells
     * @param cells
     * @param numberOfSnakes
     * @param numberOfLadders
     */
    private void addSnakesAndLadders(Cell[][] cells, int numberOfSnakes, int numberOfLadders) {
        System.out.println("Adding snakes and ladders to the board");
        while (numberOfSnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, cells.length-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, cells.length-1);
            if (snakeTail >= snakeHead) {
                continue;
            }
            Jump snakeObj = Jump.builder()
                    .start(snakeHead)
                    .end(snakeTail)
                    .build();
            Cell cell = getCell(snakeHead);
            cell.setJump(snakeObj);
            numberOfSnakes--;
        }
        while (numberOfLadders > 0) {
            int ladderHead = ThreadLocalRandom.current().nextInt(1, cells.length-1);
            int ladderTail = ThreadLocalRandom.current().nextInt(1, cells.length-1);
            if (ladderHead >= ladderTail) {
                continue;
            }
            Jump ladderObj = Jump.builder()
                    .start(ladderHead)
                    .end(ladderTail)
                    .build();
            Cell cell = getCell(ladderHead);
            cell.setJump(ladderObj);
            numberOfLadders--;
        }
    }

    /**
     * Method to get cell object from player position
     * @param playerPosition
     */
    public Cell getCell(int playerPosition) {
        int boardRow = playerPosition / cells.length;
        int boardCol = playerPosition % cells.length;
        return cells[boardRow][boardCol];
    }
}

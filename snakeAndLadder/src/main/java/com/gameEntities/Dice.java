package com.gameEntities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

@AllArgsConstructor
public class Dice {

    private int diceCount;
    private static final int MIN = 1;
    private static final int MAX = 6;

    /**
     * Method to calculate total sum of all dice values when rolling dice
     * @return {@link int}
     */
    public int rollDice() {
        int totalSum = 0;
        int diceUsed = 0;

        while (diceUsed < diceCount) {
            totalSum += ThreadLocalRandom.current().nextInt(MIN, MAX + 1);
            diceUsed += 1;
        }
        return totalSum;
    }

}

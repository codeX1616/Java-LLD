package com.example.splitwise.entity.expense.split;

import com.example.splitwise.entity.expense.ExpenseSplitType;

public class SplitFactory {

    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType) {
        return switch (splitType) {
            case EQUAL -> new EqualExpenseSplit();
            case UNEQUAL -> new UnequalExpenseSplit();
            case PERCENTAGE -> new PercentageExpenseSplit();
        };
    }

}

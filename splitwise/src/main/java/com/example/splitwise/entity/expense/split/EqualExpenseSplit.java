package com.example.splitwise.entity.expense.split;

import java.util.List;

public class EqualExpenseSplit implements ExpenseSplit {

    @Override
    public void validateSplitRequest(List<Split> splitList, double totalAmount) {
        double amountShouldBePresent = totalAmount/splitList.size();
        for(Split split: splitList) {
            if(split.getAmountOwe() != amountShouldBePresent) {
                //throw exception
            }
        }

    }

}

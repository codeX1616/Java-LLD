package com.example.splitwise.entity.expense.split;

import java.util.List;

public class EqualExpenseSplit implements ExpenseSplit {

    /**
     * Method to validate split request
     * @param splitList {@link List<Split>}
     * @param totalAmount {@link Double}
     */
    @Override
    public void validateSplitRequest(List<Split> splitList, Double totalAmount) {
        double amountShouldBePresent = totalAmount/splitList.size();
        for(Split split: splitList) {
            if(split.getAmountOwe() != amountShouldBePresent) {
                //throw exception
            }
        }

    }

}

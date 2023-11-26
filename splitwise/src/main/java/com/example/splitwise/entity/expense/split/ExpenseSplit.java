package com.example.splitwise.entity.expense.split;

import java.util.List;
import com.example.splitwise.entity.expense.split.Split;

public interface ExpenseSplit {

    /**
     * Interface Method to validate split Request
     * @param splitList {@link List<Split>}
     * @param totalAmount {@link Double}
     */
    public void validateSplitRequest(List<Split> splitList, Double totalAmount);

}

package com.example.splitwise.controller;

import com.example.splitwise.entity.expense.Expense;
import com.example.splitwise.entity.expense.ExpenseSplitType;
import com.example.splitwise.entity.expense.split.ExpenseSplit;
import com.example.splitwise.entity.expense.split.Split;
import com.example.splitwise.entity.user.User;

import java.util.List;

public class ExpenseController {

    BalanceSheetController balanceSheetController;
    public ExpenseController(){
        balanceSheetController = new BalanceSheetController();
    }

    /**
     * Controller method to create expense
     * @param expenseId {@link String}
     * @param description {@link String}
     * @param expenseAmount {@link Double}
     * @param splitDetails {@link List<Split>}
     * @param splitType {@link ExpenseSplitType}
     * @param paidByUser {@link User}
     * @return {@link Expense}
     */
    public Expense createExpense(String expenseId, String description, Double expenseAmount, List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser) {
        ExpenseSplit expenseSplit = SplitFactory.getSplitObject(splitType);
        expenseSplit.validateSplitRequest(splitDetails, expenseAmount);

        Expense expense = new Expense(expenseId, expenseAmount, description, paidByUser, splitType, splitDetails);

        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser, splitDetails, expenseAmount);

        return expense;

    }
}

package com.example.splitwise.controller;

import com.example.splitwise.entity.expense.Expense;
import com.example.splitwise.entity.expense.ExpenseSplitType;
import com.example.splitwise.entity.expense.split.Split;
import com.example.splitwise.entity.user.User;

import java.util.List;

public class ExpenseController {

    public Expense createExpense(String expenseId, String description, Double expenseAmount, List<Split> splitDetails, ExpenseSplitType splitType, User paidByUser) {
        // TODO - Add logic to create expense
        return null;
    }
}

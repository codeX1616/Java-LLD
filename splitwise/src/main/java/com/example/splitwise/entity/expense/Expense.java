package com.example.splitwise.entity.expense;

import com.example.splitwise.entity.expense.split.Split;
import com.example.splitwise.entity.user.User;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class Expense {
    private String expenseId;
    private String description;
    private double expenseAmount;
    private User paidByUser;
    private ExpenseSplitType splitType;
    private List<Split> splitDetails = new ArrayList<>();
}

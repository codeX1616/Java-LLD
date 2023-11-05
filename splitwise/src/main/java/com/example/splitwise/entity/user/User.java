package com.example.splitwise.entity.user;

import com.example.splitwise.entity.expense.UserExpenseBalanceSheet;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String userId;
    private String userName;
    private UserExpenseBalanceSheet userExpenseBalanceSheet;
}

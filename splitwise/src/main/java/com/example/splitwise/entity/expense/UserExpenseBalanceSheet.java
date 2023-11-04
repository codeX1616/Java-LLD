package com.example.splitwise.entity.expense;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class UserExpenseBalanceSheet {
    private Map<String, Balance> userVsBalance;
    private Double totalYourExpense;
    private Double totalPayment;
    private Double totalYouOwe;
    private Double totalYouGetBack;

    public UserExpenseBalanceSheet(){
        this.userVsBalance = new HashMap<>();
        this.totalYourExpense = (double) 0;
        this.totalYouOwe = (double) 0;
        this.totalYouGetBack = (double) 0;
    }

}

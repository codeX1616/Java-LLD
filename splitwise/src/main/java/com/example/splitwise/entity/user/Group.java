package com.example.splitwise.entity.user;

import com.example.splitwise.controller.ExpenseController;
import com.example.splitwise.entity.expense.Expense;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Group {

    private String groupId;
    private String groupName;
    private List<User> groupMembers;
    private List<Expense> expenseList;
    ExpenseController expenseController;

    Group(){
        groupMembers = new ArrayList<>();
        expenseList = new ArrayList<>();
        expenseController = new ExpenseController();
    }

    public void addMember(User member){
        groupMembers.add(member);
    }


}

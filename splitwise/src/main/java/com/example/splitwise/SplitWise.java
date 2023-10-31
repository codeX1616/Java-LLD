package com.example.splitwise;

import com.example.splitwise.controller.BalanceSheetController;
import com.example.splitwise.controller.GroupController;
import com.example.splitwise.controller.UserController;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SplitWise {

    private UserController userController;
    private GroupController groupController;
    private BalanceSheetController balanceSheetController;

    SplitWise() {
        userController = new UserController();
        groupController = new GroupController();
        balanceSheetController = new BalanceSheetController();
    }

    public void demo() {
        // TODO - Add logic
    }
}

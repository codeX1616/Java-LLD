package com.example.splitwise;

import com.example.splitwise.controller.BalanceSheetController;
import com.example.splitwise.controller.GroupController;
import com.example.splitwise.controller.UserController;
import com.example.splitwise.entity.user.Group;
import com.example.splitwise.entity.expense.split.Split;
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

    /**
     * demo method for splitwise
     */
    public void demo() {
        setupUserAndGroup();

        //Step1: add members to the group
        Group group = groupController.getGroup("G1001");
        group.addMember(userController.getUser("U2001"));
        group.addMember(userController.getUser("U3001"));

        //Step2. create an expense inside a group
        List<Split> splits = new ArrayList<>();
        Split split1 = new Split(userController.getUser("U1001"), 300);
        Split split2 = new Split(userController.getUser("U2001"), 300);
        Split split3 = new Split(userController.getUser("U3001"), 300);
        splits.add(split1);
        splits.add(split2);
        splits.add(split3);
        group.createExpense("Exp1001", "Breakfast", 900, splits, ExpenseSplitType.EQUAL, userController.getUser("U1001"));

    }

    private void setupUserAndGroup() {
    }
}

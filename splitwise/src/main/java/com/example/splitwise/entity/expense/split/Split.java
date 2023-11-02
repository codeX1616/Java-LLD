package com.example.splitwise.entity.expense.split;

import com.example.splitwise.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Split {
    User user;
    double amountOwe;
}

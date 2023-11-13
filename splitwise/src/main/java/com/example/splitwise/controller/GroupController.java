package com.example.splitwise.controller;

import com.example.splitwise.entity.user.Group;
import com.example.splitwise.entity.user.User;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GroupController {

    private List<Group> groupList;

    public GroupController(){
        groupList = new ArrayList<>();
    }

    /**
     * Controller method to create new group
     * @param groupId {@link String}
     * @param groupName {@link String}
     * @param createdByUser {@link User}
     */
    public void createNewGroup(String groupId, String groupName, User createdByUser) {

        //create a new group
        Group group = new Group();
        group.setGroupId(groupId);
        group.setGroupName(groupName);

        //add the user into the group, as it is created by the USER
        group.addMember(createdByUser);

        //add the group in the list of overall groups
        groupList.add(group);
    }

    /**
     * Controller method to get group
     * @param groupId {@link String}
     * @return {@link Group}
     */
    public Group getGroup(String groupId){
        for(Group group: groupList) {
            if(group.getGroupId().equals(groupId)){
                return group;
            }
        }
        return null;
    }

}

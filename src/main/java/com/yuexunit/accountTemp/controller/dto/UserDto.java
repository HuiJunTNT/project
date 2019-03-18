package com.yuexunit.accountTemp.controller.dto;

import com.yuexunit.accountTemp.db.User;

import java.util.List;

/**
 * @author 曾惠君
 * @date 2018/12/4
 * @time 13:41
 */
public class UserDto {

    private List<User> users;

    public UserDto() {
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}


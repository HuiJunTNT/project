package com.yuexunit.accountTemp.service;


import com.yuexunit.accountTemp.db.User;

import java.util.List;

/**
 * @author 曾惠君
 * @date 2018/10/11
 * @time 11:23
 */

public interface UserService {

    User tologin(String username, String passWord);

    List<User> getList();

}

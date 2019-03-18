package com.yuexunit.accountTemp.serviceImpl;


import com.yuexunit.accountTemp.dao.UserMapper;
import com.yuexunit.accountTemp.db.User;
import com.yuexunit.accountTemp.db.UserExample;
import com.yuexunit.accountTemp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author 曾惠君
 * @date 2018/10/11
 * @time 11:24
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User tologin(String phone, String passWord) {
        UserExample user =new UserExample();
        user.createCriteria().andPasswordEqualTo(passWord).andPhoneEqualTo(phone);
        List<User> users = userMapper.selectByExample(user);
        return users.isEmpty()?null:users.get(0);
    }

    @Override
    public List<User> getList() {
        UserExample example=new UserExample();
        return userMapper.selectByExample(example);
    }
}

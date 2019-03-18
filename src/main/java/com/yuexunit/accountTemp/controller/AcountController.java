package com.yuexunit.accountTemp.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yuexunit.accountTemp.db.User;
import com.yuexunit.accountTemp.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * @author 曾惠君
 * @date 2018/10/11
 * @time 11:16
 */
@RestController
@RequestMapping(value = "/account")
public class AcountController {

    Logger logger = LoggerFactory.getLogger(AcountController.class);

    @Autowired
    UserService userService;




    @RequestMapping(value = "toLogin" ,produces="application/json;charset=UTF-8",method = RequestMethod.GET)
    public User  toLogin(String phone, String passWord,HttpServletRequest request) {
        User user = userService.tologin(phone,passWord);
        request.getSession().setAttribute("userSession",user);
        return user;

    }



    @RequestMapping(value = "getList" ,produces="application/json;charset=UTF-8",method = RequestMethod.GET)
    public  PageInfo<User>  getList(Integer pageIndex,Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<User> user = userService.getList();
        return new PageInfo<User>(user);
    }



}

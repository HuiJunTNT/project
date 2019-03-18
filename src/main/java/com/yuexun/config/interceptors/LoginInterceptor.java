package com.yuexun.config.interceptors;

import com.yuexun.utils.ProperTiesUtil;
import com.yuexunit.accountTemp.db.User;
import com.yuexunit.accountTemp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 曾惠君
 * @date 2018/10/11
 * @time 11:31
 */
@Component
public class LoginInterceptor  implements HandlerInterceptor {

    @Autowired
    UserService userService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        User user =(User)request.getSession().getAttribute("userSession");
        if(user==null){
            response.sendRedirect(ProperTiesUtil.getLoginUrl());
            return false;
        }
        System.err.println("========================================="+user.getUsername());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

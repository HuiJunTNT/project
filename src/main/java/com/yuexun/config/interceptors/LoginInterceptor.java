package com.yuexun.config.interceptors;

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
//        String uuid = request.getParameter("uuid");
//        if(uuid==null){
//            return false;
//        }
//        User user = userService.getUserInfoByUUid(uuid.split("-")[0]);
//        if(user==null){
//            response.sendRedirect("/static/manageHtml/login.html?msg=error");
//            return false;
//        }
//        HttpSession session = request.getSession();
//        session.setAttribute("user",user);



        System.err.println("=========================================================");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}

package com.yuexun.config.interceptors;

import com.github.pagehelper.StringUtil;
import com.yuexun.utils.DateNewUtil;
import com.yuexun.utils.webutil.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author 曾惠君
 * @date 2018/11/2
 * @time 14:08
 */
@Component
public class OperatorLog   implements HandlerInterceptor {

   private  Logger logger=LoggerFactory.getLogger(OperatorLog.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String method = request.getServletPath();
        if(StringUtil.isNotEmpty(method)&&!"/favicon.ico".equals(method)){
            String remoteIP = WebUtil.getRemoteIP(request);
            Date date = new Date();
            logger.info("[ip :"+remoteIP+" : "+DateNewUtil.format(date,"yyyy-MM-dd HH:mm:ss") +"] : "+method);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
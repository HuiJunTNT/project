package com.yuexun.config;

import com.yuexun.config.interceptors.LoginInterceptor;
import com.yuexun.config.interceptors.OperatorLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author 曾惠君
 * @date 2018/10/11
 * @time 13:34
 */

@Configuration
public class WebConfigurer extends WebMvcConfigurationSupport {

    @Autowired
    LoginInterceptor loginInterceptor=new LoginInterceptor();
    @Autowired
    OperatorLog operatorLog=new OperatorLog();

    /**
     *    这个方法是用来配置静态资源的，比如html，js，css，等等
      */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/");
        super.addResourceHandlers(registry);
    }
    /**
     *
     * 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
     */

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns("/**") 表示拦截所有的请求
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/account/toLogin","/**");
        registry.addInterceptor(operatorLog).addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}

package com.yuexun.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author 曾惠君
 * @date 2019/3/18
 * @time 16:20
 */

@Configuration
@PropertySource("classpath:attribute.properties")
public class ProperTiesUtil {
  private static   Logger logger =LoggerFactory.getLogger(ProperTiesUtil.class);

    @Value("${login.html}")
    private static String loginUrl;

    public  static  String getLoginUrl() {
        try{
            System.err.println(loginUrl);
            return loginUrl;
        }catch (Exception e){
            logger.info("loginUrl-IO错误！");
        }
    return null;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

package com.nfgj.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;

/**
 * @author nanfgj
 * @create 2022-07-26 15:50
 */
public class DefaultFeignConfiguration {
    @Bean
    public Logger.Level feignLogLevel(){
        return Logger.Level.BASIC; //日志级别为basic
    }
}

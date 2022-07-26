package com.nfgj.feign.client;


import com.nfgj.feign.config.DefaultFeignConfiguration;
import com.nfgj.feign.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author nanfgj
 * @create 2022-07-26 15:40
 */
@FeignClient(value = "userservice",configuration = DefaultFeignConfiguration.class)
public interface UserClient {
    @GetMapping("/user/{id}")
    User findById(@PathVariable("id") Long id);
}

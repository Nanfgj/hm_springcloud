package com.xn2001.order.service;

import com.xn2001.order.mapper.OrderMapper;
import com.xn2001.order.pojo.Order;
import com.xn2001.order.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private RestTemplate restTemplate;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //2.查询用户
//        String url = "http://localhost:8081/user/"+order.getUserId();
        String url = "http://userservice/user/"+order.getUserId();
        User user = restTemplate.getForObject(url, User.class);
        //封装信息
        order.setUser(user);
        // 4.返回
        return order;
    }
}

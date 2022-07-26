package com.xn2001.order.service;


import com.nfgj.feign.client.UserClient;
import com.nfgj.feign.pojo.User;
import com.xn2001.order.mapper.OrderMapper;
import com.xn2001.order.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private UserClient userClient;


    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        //2.根据feign远程调用 查询用户
        User user = userClient.findById(order.getUserId());
        //3.封装信息
        order.setUser(user);
        // 4.返回
        return order;
    }

//    @Autowired
//    private RestTemplate restTemplate;
//
//    public Order queryOrderById(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//        //2.查询用户
////        String url = "http://localhost:8081/user/"+order.getUserId();
//        String url = "http://userservice/user/"+order.getUserId();
//        User user = restTemplate.getForObject(url, User.class);
//        //封装信息
//        order.setUser(user);
//        // 4.返回
//        return order;
//    }
}

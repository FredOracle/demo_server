package com.example.orderservice.controller;

import com.example.common.config.OrderConfigProperties;
import com.example.common.entity.Order;
import com.example.common.entity.User;
import com.example.orderservice.business.OrderBusiness;
import com.example.orderservice.remote.UserClient;
import com.google.common.collect.Lists;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/order")
public class OrderRestController {

    @Resource
    private OrderBusiness orderBusiness;

    @Resource
    private OrderConfigProperties properties;

    @Resource
    private UserClient userClient;

    @HystrixCommand
    @RequestMapping(value = "/msg", method = RequestMethod.GET)
    public String msg(){
//        Order order = orderBusiness.create(Order.builder().createtime(new Date()).status(1).updatetime(new Date()).build());
//
//        String userMessage = userClient.msg();
//        User user = userClient.findById(userMessage.split("=")[0]);
//        user.setOrders(Lists.newArrayList(order));
//        userClient.update(user);

        return properties.getMessage() + "::::" + UUID.randomUUID().toString();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Order create(@RequestBody Order order){
        return orderBusiness.create(order);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Order update(@RequestBody Order order){
        return orderBusiness.update(order);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Order update(@PathVariable("id") String id){
        Order order = orderBusiness.findById(id);
        order.setStatus(100);
        return orderBusiness.update(order);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") String id){
        orderBusiness.deleteById(id);
        return ResponseEntity.ok().body("SUCCESS");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<Order> list(){
        return orderBusiness.findAll();
    }
}

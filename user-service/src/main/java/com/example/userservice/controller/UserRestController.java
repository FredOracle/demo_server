package com.example.userservice.controller;

import com.example.common.entity.User;
import com.example.userservice.business.UserBusiness;
import com.example.userservice.remote.CommonClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping(value = "/user")
public class UserRestController {


    @Resource
    private UserBusiness business;

    @Resource
    private CommonClient commonClient;

    @HystrixCommand
    @RequestMapping(value = "/msg", method = RequestMethod.GET)
    public String msg(){
//        User user = business.create(User.builder().name(UUID.randomUUID().toString()).age(100).password(UUID.randomUUID().toString()).description("").createtime(new Date()).updatetime(new Date()).build());
        return commonClient.msg();
                //UUID.randomUUID().toString() + ":::::::::::::::::::";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public User create(@RequestBody User user){
        user = business.create(User.builder().name(UUID.randomUUID().toString()).age(100).password(UUID.randomUUID().toString()).description("").createtime(new Date()).updatetime(new Date()).build());
        return user;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public User update(@RequestBody User user){
        return business.update(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User update(@PathVariable("id") String id){
        User user = business.findById(id);
        user.setName("Fred");
        user.setDescription("updated");
        return business.update(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") String id){
        return business.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable("id") String id){
        business.deleteById(id);
        return ResponseEntity.ok().body("SUCCESS");
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<User> list(){
        return business.findAll();
    }
}

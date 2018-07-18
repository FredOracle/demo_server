package com.example.userservice.business;

import com.example.common.entity.User;
import com.example.userservice.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserBusinessImpl extends UserBusiness {

    @Resource
    private UserRepository repository;


}

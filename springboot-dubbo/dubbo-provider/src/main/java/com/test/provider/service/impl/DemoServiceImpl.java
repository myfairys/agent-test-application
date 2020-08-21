package com.test.provider.service.impl;

import com.test.api.entity.User;
import com.test.api.service.DemoService;
import com.test.api.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.annotation.Service;

@Service
public class DemoServiceImpl implements DemoService {

    @Reference
    UserService userService;
    @Override
    public String print(String name) {
        return "hello " + name;
    }

    @Override
    public User getUserById(Integer id) {
        return userService.selectById(id);
    }
}

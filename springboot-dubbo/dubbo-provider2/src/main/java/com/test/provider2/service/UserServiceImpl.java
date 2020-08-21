package com.test.provider2.service;

import com.test.api.entity.User;
import com.test.api.service.UserService;
import com.test.provider2.mapper.UserMapper;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User selectById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int insertOne(User user) {
        return userMapper.insertSelective(user);
    }
}

package com.test.api.service;

import com.test.api.entity.User;

public interface UserService {
    User selectById(Integer id);

    int insertOne(User user);
}

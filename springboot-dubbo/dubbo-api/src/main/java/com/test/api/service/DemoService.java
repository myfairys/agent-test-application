package com.test.api.service;

import com.test.api.entity.User;

public interface DemoService {
    String print(String name);

    User getUserById(Integer id);
}

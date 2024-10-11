package com.springboot.springboot.service;

import com.springboot.springboot.domain.User;

public interface UserService {
    User loginService(String username, String password);
    User registerService(User user);//user主键必须为空！
}

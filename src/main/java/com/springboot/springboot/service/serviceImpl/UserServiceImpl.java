package com.springboot.springboot.service.serviceImpl;

import com.springboot.springboot.domain.User;
import com.springboot.springboot.repository.UserDao;
import com.springboot.springboot.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public User loginService(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, password);
        if(user!=null){
            user.setPassword("");
        }
        return user;
    }

    @Override
    public User registerService(User user) {
        if(userDao.findByUsername(user.getUsername())!=null){
            return null;
        }else{
            User newUser = userDao.save(user);
            if(newUser != null){
                newUser.setPassword("");
            }
            return newUser;
        }
    }
}

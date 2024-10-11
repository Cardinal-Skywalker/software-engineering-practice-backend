package com.springboot.springboot.controller;

import com.springboot.springboot.domain.User;
import com.springboot.springboot.service.UserService;
import com.springboot.springboot.utils.Result;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")//这个控制器类的基路由
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("/login")//user/login
    public Result<User> loginController(@RequestParam String username, @RequestParam String password){
        User user = userService.loginService(username, password);
        if(user != null){
            return Result.success(user,"登录成功");
        }else{
            return Result.error("123","账号或密码错误");
        }
    }

    @PostMapping("/register")
    public Result registController(@RequestBody User newUser){
        User user = userService.registerService(newUser);
        if(user!=null){
            return Result.success(user,"注册成功！");
        }else{
            return Result.error("456","用户名已存在！");
        }
    }

}

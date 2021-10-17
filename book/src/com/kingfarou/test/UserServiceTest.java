package com.kingfarou.test;

import com.kingfarou.pojo.User;
import com.kingfarou.service.impl.UserService;
import com.kingfarou.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null, "bbj168", "666666", "bbj168@qq.com"));
        userService.registerUser(new User(null, "abc168", "666666", "abc168@qq.com"));
    }

    @Test
    public void login() {
        if(userService.login(new User(null, "wzg168", "123456", "wzg168@qq.com")) == null){
            System.out.println("登录失败");
        } else {
            System.out.println("登录成功");
        }
    }

    @Test
    public void existsUsername() {
        if(userService.existsUsername("abc168")){
            System.out.println("用户名已存在");
        } else {
            System.out.println("用户名不存在，可注册");
        }
    }
}
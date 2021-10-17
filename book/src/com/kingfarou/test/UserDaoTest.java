package com.kingfarou.test;

import com.kingfarou.dao.UserDao;
import com.kingfarou.dao.impl.UserDaoImpl;
import com.kingfarou.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void queryUserByUsername() {
        UserDao userDao = new UserDaoImpl();
        if(userDao.queryUserByUsername("admin123") == null){
            System.out.println("用户名可用");
        } else {
            System.out.println("用户名已存在");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        UserDao userDao = new UserDaoImpl();
        if(userDao.queryUserByUsernameAndPassword("admin", "admin123") == null){
            System.out.println("用户名或密码错误");
        } else {
            System.out.println("登录成功");
        }
    }

    @Test
    public void saveUser() {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.saveUser(new User(null, "wzg168", "123456", "wzg168@qq.com")));
    }
}
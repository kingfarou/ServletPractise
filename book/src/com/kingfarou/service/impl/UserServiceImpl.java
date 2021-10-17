package com.kingfarou.service.impl;

import com.kingfarou.dao.UserDao;
import com.kingfarou.dao.impl.UserDaoImpl;
import com.kingfarou.pojo.User;

public class UserServiceImpl implements UserService{

    UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        return userDao.queryUserByUsername(username) != null;
    }
}

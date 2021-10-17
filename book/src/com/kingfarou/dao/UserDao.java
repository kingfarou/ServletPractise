package com.kingfarou.dao;

import com.kingfarou.pojo.User;

public interface UserDao {

    User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户
     * @param username 用户名
     * @param password 密码
     * @return 如果用户名或密码错误，返回null
     */
    User queryUserByUsernameAndPassword(String username, String password);

    public int saveUser(User user);
}

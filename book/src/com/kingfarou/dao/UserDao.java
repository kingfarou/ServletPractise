package com.kingfarou.dao;

import com.kingfarou.pojo.User;

public interface UserDao {

    /**
     * 根据用户名查询用户
     * @param username
     * @return null：用户不存在；成功则返回用户信息
     */
    User queryUserByUsername(String username);

    /**
     * 根据用户名和密码查询用户
     * @param username 用户名
     * @param password 密码
     * @return null：用户名或密码错误；成功则返回用户信息
     */
    User queryUserByUsernameAndPassword(String username, String password);

    /**
     * 保存（新增）一条用户记录
     * @param user
     * @return
     */
    public int saveUser(User user);
}

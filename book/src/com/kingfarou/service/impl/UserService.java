package com.kingfarou.service.impl;

import com.kingfarou.pojo.User;

/**
 * 用户信息，接口
 */
public interface UserService {

    /**
     * 注册
     * @param user
     */
    void registerUser(User user);

    /**
     * 登录
     * @param user
     * @return null：登录失败；登陆成功返回实体对象
     */
    User login(User user);

    /**
     * 判断用户名是否存在
     * @param username
     * @return true：用户已存在，不可重复注册；false：用户名不存在
     */
    boolean existsUsername(String username);
}

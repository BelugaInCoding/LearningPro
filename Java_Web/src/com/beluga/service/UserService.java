package com.beluga.service;

import com.beluga.pojo.User;

/**
 * @author Beluga
 * @createTime 2022/11/1 -- 23:05
 */
public interface UserService {

    /**
     * 注册
     * @param user
     */
    public void registerUser(User user);

    /**
     * 登录
     * @param user
     */
    public User login(User user);

    /**
     * 检查用户名是否存在
     * @param user
     * @return true:用户名存在；false:用户名可用
     */
    public boolean isUsernameExist(User user);
}
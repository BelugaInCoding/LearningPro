package com.beluga.dao;

import com.beluga.pojo.User;

import java.util.List;

/**
 * @author Beluga
 * @createTime 2022/8/15 -- 22:36
 */
public interface UserDao {
    /**
     * 根据用户名称查询用户
     * @param userName 用户名
     * @return 返回用户对象 null则无此用户
     */
    public User queryUserByUsername(String userName);

    /**
     * 根据用户名和密码查询用户
     * @param userName 用户名
     * @param pwd 用户密码
     * @return 返回用户对象 null为无此用户
     */
    public User queryUserByUsernameAndPassword(String userName, String pwd);

    /**
     * 用户数据存入数据库
     * @param user 用户对象
     * @return 1为成功 -1为失败
     */
    public int saveUser(User user);

    /**
     * 获取所有用户信息
     * @return
     */
    public List<User> queryAllUser();
}

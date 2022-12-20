package com.beluga.service;

import com.beluga.pojo.User;

import java.util.List;

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

    /**
     * 获取所有用户信息
     * @return  所有用户信息的List
     */
    public List<User> getAllUser();

    /**
     * 分页获取用户信息
     * @param pageNo 第几页
     * @return  用户信息List 默认一页 2 条
     */
    public List<User> getAllUserAsPage(int pageNo);

    /**
     *  通过用户的id获取所有用户信息
     * @param user  只有id为有效值 其余为null
     * @return  返回该用户对象
     */
    public User getUserByUserId(User user);

    /**
     * 获取用户总数
     * @return 用户总记录条数
     */
    public int getUserCount();

    /**
     * 修改用户信息
     * @param user 修改后的用户对象
     * @return  修改是否成功
     */
    public boolean changeUserInfo(User user);

    /**
     * 删除用户信息
     * @param user 带用户id的用户对象
     * @return true：删除成功 false：删除失败
     */
    public boolean deleteUser(User user);
}

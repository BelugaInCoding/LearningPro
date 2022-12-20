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
     * 根据用户id查询用户
     * @param uId 用户id
     * @return 返回对应的用户 若无返回null
     */
    public User queryUserByUserId(int uId);

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

    /**
     * 分页获取用户信息
     * @param pageNo 页数
     * @return 当前页用户List 默认一页 2 条
     */
    public List<User> queryAllUserAsPage(int pageNo);

    /**
     * 获取用户总记录数
     * @return  用户总记录数
     */
    public Integer queryUserCount();

    /**
     *通过用户id检索用户 并修改用户信息
     * @param user  修改后的用户对象 带id
     * @return  1:修改成功  其他:修改失败
     */
    public int updateUserById(User user);

    /**
     * 删除用户信息
     * @param user 带用户id的用户对象
     * @return 1：删除成功 其他：删除失败
     */
    public int deleteUserById(User user);
}

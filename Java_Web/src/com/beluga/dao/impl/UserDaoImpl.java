package com.beluga.dao.impl;

import com.beluga.dao.UserDao;
import com.beluga.pojo.User;

import java.util.List;

/**
 * @author Beluga
 * @createTime 2022/8/15 -- 23:21
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByUsername(String userName) {
        String sql = "select id, username, pwd, email from t_user where username=?";
        return queryForOne(User.class, sql, userName);
    }

    @Override
    public User queryUserByUsernameAndPassword(String userName, String pwd) {
        String sql = "select id, username, pwd, email from t_user where username=? and pwd=?";
        return queryForOne(User.class, sql, userName, pwd);
    }

    @Override
    public User queryUserByUserId(int uId) {
        String sql = "select id, username, pwd, email from t_user where id=?";
        return queryForOne(User.class, sql, uId);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user(username, pwd, email) " +
                    "values(?,?,?)";
        return update(sql, user.getUsername(), user.getPwd(), user.getEmail());
    }

    @Override
    public List<User> queryAllUser() {
        String sql = "select * from t_user";
        return queryForList(User.class, sql, null);
    }

    @Override
    public List<User> queryAllUserAsPage(int pageNo) {
        String sql = "select * from t_user limit ? , 5";
        return queryForList(User.class, sql, (pageNo - 1)*5);
    }

    @Override
    public Integer queryUserCount() {
        String sql = "select count(*) from t_user";
        Object count = queryForSingleValue(sql, null);
        return Integer.parseInt(count.toString());
    }

    @Override
    public int updateUserById(User user) {
        String sql ="update t_user set username=?,pwd=?,email=? where id=?";
        return update(sql, user.getUsername(), user.getPwd(), user.getEmail(), user.getId());
    }

    @Override
    public int deleteUserById(User user) {
        String sql = "delete from t_user where id = ?";
        return update(sql, user.getId());
    }
}

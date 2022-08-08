package com.beluga.dao.impl;

import com.beluga.dao.UserDao;
import com.beluga.pojo.User;

/**
 * @author Beluga
 * @createTime 2022/8/15 -- 23:21
 */
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByUsername(String userName) {
        String sql = "select 'id', 'username', 'pwd', 'email' from t_user where username=?;";
        return queryForOne(User.class, sql, userName);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user('username', 'pwd', 'email') " +
                    "values(?,?,?);";
        return update(sql, user.getUsername(), user.getPwd(), user.getEmail());
    }
}

package com.beluga.service.impl;

import com.beluga.dao.UserDao;
import com.beluga.dao.impl.UserDaoImpl;
import com.beluga.pojo.User;
import com.beluga.service.UserService;

/**
 * @author Beluga
 * @createTime 2022/11/2 -- 23:40
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public void registerUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassword(user.getUsername(),user.getPwd());
    }

    @Override
    public boolean isUsernameExist(User user) {
        if (userDao.queryUserByUsername(user.getUsername())!=null){
            return true;
        }
        return false;
    }
}

package com.beluga.service.impl;

import com.beluga.dao.UserDao;
import com.beluga.dao.impl.UserDaoImpl;
import com.beluga.pojo.User;
import com.beluga.service.UserService;

import java.util.List;

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
    public User getUserByUserId(User user) {
        return userDao.queryUserByUserId(user.getId());
    }

    @Override
    public int getUserCount(String keyWord) {
        return userDao.queryUserCount(keyWord);
    }

    @Override
    public List<User> getUserByKeyword(String keyWord) {
        return userDao.queryUserByKeyword(keyWord);
    }


    @Override
    public boolean changeUserInfo(User user) {
        int flag = userDao.updateUserById(user);
        if (flag==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        int flag = userDao.deleteUserById(user);
        if (flag==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean isUsernameExist(User user) {
        if (userDao.queryUserByUsername(user.getUsername())!=null){
            return true;
        }
        return false;
    }

    @Override
    public List<User> getAllUser() {
        return userDao.queryAllUser();
    }

    @Override
    public List<User> getAllUserAsPage(String keyword, int pageNo) {
        return userDao.queryAllUserAsPage(keyword,pageNo);
    }
}

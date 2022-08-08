package com.beluga.test;

import com.beluga.dao.UserDao;
import com.beluga.dao.impl.UserDaoImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Beluga
 * @createTime 2022/8/15 -- 23:43
 */
public class UserDaoTest {

    @Test
    public void queryUserByUsername() {
        UserDao userDao = new UserDaoImpl();
        System.out.println(userDao.queryUserByUsername("admin"));;
    }

    @Test
    public void saveUser() {
    }
}
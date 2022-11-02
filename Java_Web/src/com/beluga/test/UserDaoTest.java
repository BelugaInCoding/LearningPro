package com.beluga.test;

import com.beluga.dao.UserDao;
import com.beluga.dao.impl.UserDaoImpl;
import com.beluga.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Beluga
 * @createTime 2022/11/1 -- 22:40
 */
public class UserDaoTest {

    UserDao userdao = new UserDaoImpl();

    @Test
    public void queryUserByUsername() {
        if (userdao.queryUserByUsername("admin123") == null){
            System.out.println("用户名可用");
        } else {
            System.out.println("用户名不可用");
        }
    }

    @Test
    public void queryUserByUsernameAndPassword() {
        System.out.println(userdao.queryUserByUsernameAndPassword("admin","admin"));
    }

    @Test
    public void saveUser() {
        System.out.println(userdao.saveUser(new User(
                null, "iwen", "123456","testEmail")));
    }
}
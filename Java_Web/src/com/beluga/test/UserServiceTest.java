package com.beluga.test;

import com.beluga.pojo.User;
import com.beluga.service.UserService;
import com.beluga.service.impl.UserServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Beluga
 * @createTime 2022/11/2 -- 23:45
 */
public class UserServiceTest {

    UserService userService = new UserServiceImpl();

    @Test
    public void registerUser() {
        userService.registerUser(new User(null,"baluga", "123456", "testEmail@123.com"));
    }

    @Test
    public void login() {
        User u = new User(null,"baluga", "123456", "testEmail@123.com");
        System.out.println(userService.login(u));
    }

    @Test
    public void isUsernameExist() {
        boolean flag = userService.isUsernameExist(new User(null,"baluga", "123456", "testEmail@123.com"));
        System.out.println(flag);
    }
}
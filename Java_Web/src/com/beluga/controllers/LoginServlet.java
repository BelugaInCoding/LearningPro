package com.beluga.controllers; /**
 * @author Beluga
 * @createTime 2022/12/19 -- 22:29
 */

import com.alibaba.fastjson.JSONObject;
import com.beluga.pojo.User;
import com.beluga.service.UserService;
import com.beluga.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();
    JSONObject responseData = new JSONObject();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();

        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");

        PrintWriter writer = response.getWriter();

        if (userService.login(new User(null, username, pwd, null)) != null){
            System.out.println("登陆成功");
            writer.write("登陆成功");
        }else{
            System.out.println("登陆失败");
        }
        writer.flush();
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

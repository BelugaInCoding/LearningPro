package com.beluga.servlets; /**
 * @author Beluga
 * @createTime 2022/8/4 -- 22:09
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("uName");
        String pwd = request.getParameter("pwd");

        System.out.println("登陆账号为："+name);
        System.out.println("登陆密码为："+pwd);

        Object key = request.getAttribute("key");
        if (key=="OK"){
            System.out.println("Do Sth");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

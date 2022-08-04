package com.beluga.servlets; /**
 * @author Beluga
 * @createTime 2022/8/4 -- 22:17
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String name = request.getParameter("uName");
        String pwd = request.getParameter("pwd");

        System.out.println("注册注册账号为："+name);
        System.out.println("注册密码为："+pwd);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

package com.beluga.controllers.test; /**
 * @author Beluga
 * @createTime 2022/8/4 -- 22:17
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class TestRegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("test/html; charset=utf-8");
        String uName = request.getParameter("uName");
        String pwd = request.getParameter("pwd");
        String remoteIp = request.getRemoteHost();//获取访问IP

        System.out.println("注册注册账号为："+uName);
        System.out.println("注册密码为："+pwd);
        System.out.println("访问IP为："+remoteIp);

//        请求转发
        if (uName.equals("Beluga") && pwd.equals("123")){
            request.setAttribute("key", "OK");
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/loginServlet");
            requestDispatcher.forward(request, response);
        }

//        重定向
        if (uName.equals("redict") && pwd.equals("123")){
            response.sendRedirect("http://localhost:8080/Java_Web/responseIOServlet");
            //重定向后 request域中的数据不会共享 因为相当于是重新访问
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}

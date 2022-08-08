package com.beluga.servlets; /**
 * @author Beluga
 * @createTime 2022/8/4 -- 22:09
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class TestLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String name = request.getParameter("uName");
        String pwd = request.getParameter("pwd");

        System.out.println("登陆账号为："+name);
        System.out.println("登陆密码为："+pwd);

        PrintWriter writer = response.getWriter();

        Object key = request.getAttribute("key");
        if (key=="OK"){
            writer.write("从register到login的请求转发"+ name);
        }else{
            writer.write("登陆账号为：" + name);
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

package com.beluga.servlets.test;
/**
 * @author Beluga
 * @createTime 2022/8/7 -- 17:56
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

public class TestResponseIOServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 字节流字符流不能同时使用 会报错
        //response.getOutputStream(); //字节流 用于文件传输
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
        // 同时设置服务器和客户端以及请求头编码方式为UTF-8 但一定要写在流对象获取前
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String statue = "0";
        String uName = request.getParameter("uName");
        String pwd = request.getParameter("pwd");

        PrintWriter writer = response.getWriter();//字符流  用于字符串传输

        if (Objects.equals(uName, "Beluga") && Objects.equals(pwd, "123")){
            statue = "1";
        }
        writer.write(statue);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

package com.beluga.web; /**
 * @author Beluga
 * @createTime 2022/8/8 -- 22:19
 */

import com.beluga.pojo.User;
import com.beluga.service.UserService;
import com.beluga.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {

    private UserService userService= new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String userName = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        PrintWriter writer = response.getWriter();

        if ("asdf".equalsIgnoreCase(code)){
            if (userService.isUsernameExist(new User(null, userName, pwd, email))){
                request.getRequestDispatcher("pages/register.html").forward(request, response);
                System.out.println("用户已存在");
            }else {
                userService.registerUser(new User(null, userName, pwd, email));
            }
        }else{
            //  请求转发
            request.getRequestDispatcher("pages/register.html").forward(request, response);
            // 重定向
            //response.sendRedirect("pages/register.html");
            System.out.println("验证码错误");
        }

        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

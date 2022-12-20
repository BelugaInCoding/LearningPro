package com.beluga.servlets;
/**
 * @author Beluga
 * @createTime 2022/12/27 -- 13:13
 */

import com.beluga.pojo.User;
import com.beluga.service.UserService;
import com.beluga.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", value = "/update.do")
public class UpdateServlet extends ViewBaseServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        String uidStr = request.getParameter("uid");
        int uid = Integer.parseInt(uidStr);
        String name = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        String email = request.getParameter("email");

        userService.changeUserInfo(new User(uid, name, pwd, email));

        response.sendRedirect("indexer");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

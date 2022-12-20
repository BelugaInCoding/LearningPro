package com.beluga.servlets;
/**
 * @author Beluga
 * @createTime 2022/12/20 -- 22:24
 */

import com.beluga.pojo.User;
import com.beluga.service.UserService;
import com.beluga.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet", value = "/indexer")
public class IndexServlet extends ViewBaseServlet {

    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        int pageNo = 1;
        String pageNoStr = request.getParameter("pageNo");
        if (pageNoStr!=null && !"".equals(pageNoStr)){
            pageNo = Integer.parseInt(pageNoStr);
        }

        HttpSession session = request.getSession();

        // 获取全部用户数据
        // List<User> allUser = userService.getAllUser();
        // session.setAttribute("allUser",allUser);

        // 分页获取用户数据
        session.setAttribute("pageNo", pageNo);

        int userCount = userService.getUserCount();
        int pageCount = (userCount+5-1)/5;
        session.setAttribute("pageCount", pageCount);
        List<User> pageUser = userService.getAllUserAsPage(pageNo);
        session.setAttribute("allUser", pageUser);

        super.processTemplate("thymeleaf", request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

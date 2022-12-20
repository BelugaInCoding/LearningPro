package com.beluga.servlets; /**
 * @author Beluga
 * @createTime 2022/12/27 -- 22:36
 */

import com.beluga.pojo.User;
import com.beluga.service.UserService;
import com.beluga.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/delete.do")
public class DeleteServlet extends ViewBaseServlet {
    UserService userService = new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String uidStr = request.getParameter("uid");
        int uid = Integer.parseInt(uidStr);

        userService.deleteUser(new User(uid, null, null, null));

        response.sendRedirect("indexer");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

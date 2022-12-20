package com.beluga.servlets; /**
 * @author Beluga
 * @createTime 2022/12/26 -- 23:09
 */

import com.beluga.pojo.User;
import com.beluga.service.UserService;
import com.beluga.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "EditServlet", value = "/edit.do")
public class EditServlet extends ViewBaseServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String uIdStr = request.getParameter("uid");
        if (uIdStr != null && !"".equals(uIdStr)){
            int uId = Integer.parseInt(uIdStr);
            User user = userService.getUserByUserId(new User(uId, null, null, null));
            request.setAttribute("user", user);
            super.processTemplate("edit", request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}

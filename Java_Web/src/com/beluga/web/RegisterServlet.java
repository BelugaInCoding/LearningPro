package com.beluga.web; /**
 * @author Beluga
 * @createTime 2022/8/8 -- 22:19
 */

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        String userName = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        String email = request.getParameter("email");

        System.out.println(userName+"__"+pwd+"__"+email);

        PrintWriter writer = response.getWriter();
        writer.write(userName + "--" + pwd + "--" + email);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

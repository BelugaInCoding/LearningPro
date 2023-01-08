package com.beluga.controllers;
/**
 * @author Beluga
 * @createTime 2023/1/3 -- 12:30
 */

import com.beluga.pojo.User;
import com.beluga.service.UserService;
import com.beluga.service.impl.UserServiceImpl;
import com.beluga.utils.StringUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.apache.log4j.spi.Configurator.NULL;

public class UserController extends ViewBaseServlet {

    private ServletContext servletContext;

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
        try {
            super.init(servletContext);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
/*        String operate = request.getParameter("operate");
        if (!StringUtils.isNotEmpity(operate)){
            operate = "index";
        }

        Method[] methods = this.getClass().getDeclaredMethods();
        for (Method m: methods){
            String methodName = m.getName();
            if (operate.equals(methodName)){
                try {
                    m.invoke(this, request, response);
                    return;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        throw new RuntimeException("operate非法");
*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    // IndexServlet
    private void index(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession();

        int pageNo = 1;
        String keyWord = null;

        String operate = request.getParameter("operate");
        if (StringUtils.isNotEmpity(operate) && "search".equals(operate)){
            pageNo = 1;
            keyWord = request.getParameter("keyWord");
            if (!StringUtils.isNotEmpity(keyWord)){
                keyWord = "";
            }
            session.setAttribute("keyWord", keyWord);
        }else {
            String pageNoStr = request.getParameter("pageNo");
            if (pageNoStr != null && !"".equals(pageNoStr)) {
                pageNo = Integer.parseInt(pageNoStr);
            }
            Object keyWordObj = session.getAttribute("keyWord");
            if (keyWordObj != null){
                keyWord = (String)keyWordObj;
            }else {
                keyWord = "";
            }
        }

        // 获取全部用户数据
        // List<User> allUser = userService.getAllUser();
        // session.setAttribute("allUser",allUser);

        // 分页获取用户数据
        session.setAttribute("pageNo", pageNo);

        int userCount = userService.getUserCount(keyWord);
        int pageCount = (userCount+5-1)/5;
        session.setAttribute("pageCount", pageCount);
        List<User> pageUser = userService.getAllUserAsPage(keyWord,pageNo);
        session.setAttribute("allUser", pageUser);

        super.processTemplate("thymeleaf", request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws IOException {
        index(request, response);
    }
    // RegisterServlet/AddServlet
    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        String email = request.getParameter("email");
        String code = request.getParameter("code");

        String codeFlag = "asdf";

        if (codeFlag.equalsIgnoreCase(code)){
            if (userService.isUsernameExist(new User(null, userName, pwd, email))){
                request.getRequestDispatcher("pages/register.html").forward(request, response);
            }else {
                userService.registerUser(new User(null, userName, pwd, email));
                response.sendRedirect("user.do");
            }
        }else{
            //  请求转发
            request.getRequestDispatcher("pages/register.html").forward(request, response);
            // 重定向
            //response.sendRedirect("pages/register.html");
            System.out.println("验证码错误");
        }

    }

    // DeleteServlet
    private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uidStr = request.getParameter("uid");
        int uid = Integer.parseInt(uidStr);

        userService.deleteUser(new User(uid, null, null, null));

        response.sendRedirect("user.do");
    }

    // EditServlet
    private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uIdStr = request.getParameter("uid");
        if (StringUtils.isNotEmpity(uIdStr)){
            int uId = Integer.parseInt(uIdStr);
            User user = userService.getUserByUserId(new User(uId, null, null, null));
            request.setAttribute("user", user);
        }
        // 不管uid是否拿到都跳转到edit
        // 如果经过上面的if 则request里面会有user参数 但user可能会为null
        // 如果不经过 则request里面连user字段都不会有
        super.processTemplate("edit", request, response);
    }

    // UpdateServlet
    private void update(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uidStr = request.getParameter("uid");
        int uid = Integer.parseInt(uidStr);
        String name = request.getParameter("uname");
        String pwd = request.getParameter("pwd");
        String email = request.getParameter("email");

        userService.changeUserInfo(new User(uid, name, pwd, email));

        response.sendRedirect("user.do");
    }

}

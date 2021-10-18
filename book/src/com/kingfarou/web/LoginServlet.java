package com.kingfarou.web;

import com.kingfarou.pojo.User;
import com.kingfarou.service.UserService;
import com.kingfarou.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.login(new User(null, username, password, null));
        //登录失败
        if(user == null){
            req.getRequestDispatcher("/pages/user/login.html").forward(req, resp);
        } else {
            req.getRequestDispatcher("/pages/user/login_success.html").forward(req, resp);
        }
    }
}

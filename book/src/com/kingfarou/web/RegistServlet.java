package com.kingfarou.web;

import com.kingfarou.pojo.User;
import com.kingfarou.service.impl.UserService;
import com.kingfarou.service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        //验证码是否正确（还没学到验证码生成，先写死）
        if("abcde".equalsIgnoreCase(code)){
            System.out.println("验证码正确");
            //用户是否已存在，不可重复注册
            if(userService.existsUsername(username)){
                System.out.println("用户名已存在");
                req.getRequestDispatcher("/pages/user/regist.html").forward(req, resp);
            } else {
                System.out.println("用户名可用，注册成功");
                userService.registerUser(new User(null, username, password, email));
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/user/regist_success.html");
                requestDispatcher.forward(req, resp);
            }
        } else {
            System.out.println("验证码错误");
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/user/regist.html");
            requestDispatcher.forward(req, resp);
        }
    }
}

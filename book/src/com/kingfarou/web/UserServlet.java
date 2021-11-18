package com.kingfarou.web;

import com.kingfarou.pojo.User;
import com.kingfarou.service.UserService;
import com.kingfarou.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if("login".equals(action)){
            String username = req.getParameter("username");
            String password = req.getParameter("password");

            User user = userService.login(new User(null, username, password, null));
            //登录失败
            if (user == null) {
                System.out.println("登录失败");
                req.setAttribute("msg", "用户名或密码错误");
                req.setAttribute("username", username);
                req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            } else {
                //登录成功
                System.out.println("登录成功");
                req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
            }
        } else if("regist".equals(action)){
            String code = req.getParameter("code");
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String email = req.getParameter("email");

            //验证码写死，作为测试
            if(!"abcdef".equals(code)){
                System.out.println("验证码错误");
                req.setAttribute("msg", "验证码错误");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
                return;
            }

            //用户已存在，不可重复注册
            if(userService.existsUsername(username)){
                System.out.println("用户名已存在");
                req.setAttribute("msg", "用户名已存在，不可重复注册");
                req.setAttribute("username", username);
                req.setAttribute("email", email);
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
                return;
            }

            System.out.println("注册成功");
            userService.registerUser(new User(null, username, password, email));
            req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
        }
    }
}

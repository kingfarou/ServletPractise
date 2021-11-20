package com.kingfarou.web;

import com.kingfarou.pojo.User;
import com.kingfarou.service.UserService;
import com.kingfarou.service.impl.UserServiceImpl;
import com.kingfarou.utils.WebUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();

    /**
     * 注册
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        if (user == null) {
            System.out.println("注入异常");
            req.setAttribute("msg", "服务器异常");
            req.setAttribute("username", req.getParameter("username"));
            req.setAttribute("email", req.getParameter("email"));
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            return;
        }

        //验证码写死，作为测试
        if (!"abcdef".equals(req.getParameter("code"))) {
            System.out.println("验证码错误");
            req.setAttribute("msg", "验证码错误");
            req.setAttribute("username", user.getUsername());
            req.setAttribute("email", user.getEmail());
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            return;
        }

        //用户已存在，不可重复注册
        if (userService.existsUsername(user.getUsername())) {
            System.out.println("用户名已存在");
            req.setAttribute("msg", "用户名已存在，不可重复注册");
            req.setAttribute("username", user.getUsername());
            req.setAttribute("email", user.getEmail());
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req, resp);
            return;
        }

        System.out.println("注册成功");
        userService.registerUser(user);
        req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req, resp);
    }

    /**
     * 登录
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = WebUtils.copyParamToBean(req.getParameterMap(), new User());
        if (user == null) {
            System.out.println("登录失败");
            req.setAttribute("msg", "服务器异常");
            req.setAttribute("username", req.getParameter("username"));
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            return;
        }

        User loginUser = userService.login(user);
        //登录失败
        if (loginUser == null) {
            System.out.println("登录失败");
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", user.getUsername());
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        } else {
            //登录成功
            System.out.println("登录成功");
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req, resp);
        }
    }
}

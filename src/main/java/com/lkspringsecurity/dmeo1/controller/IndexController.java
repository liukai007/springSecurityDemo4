package com.lkspringsecurity.dmeo1.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  <p> 初次体验Spring Security </p>
 *
 * @author：  zhengqing <br/>
 * @date：  2019/9/30$ 9:37$ <br/>
 * @version：  <br/>
 */
@RestController
public class IndexController {

    @GetMapping("/")
    public ModelAndView showHome() {
        return new ModelAndView("home.html");
    }

    @GetMapping("/index")
    public String index() {
        return "Hello World ~";
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login.html");
    }

    @GetMapping("/home")
    public String home() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("登陆人：" + name);
        return "Hello~ " + name;
    }

    @GetMapping(value ="/admin")
    // 访问路径`/admin` 具有`crud`权限
    @PreAuthorize("hasPermission('/admin','crud')")
    public String admin() {
        return "Hello~ 管理员";
    }

    @GetMapping("/test")
//    @PreAuthorize("hasPermission('/test','t')")
    public String test() {
        return "Hello~ 测试权限访问接口";
    }

    /**
     * 登录异常处理 - 前后端一体的情况下
     * @param request
     * @param response
     */
    @RequestMapping("/login/error")
    public void loginError(HttpServletRequest request, HttpServletResponse response) {
        AuthenticationException e = (AuthenticationException) request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
        System.out.println(e.getMessage());
//        ResponseUtils.out(response, ApiResult.fail(e.getMessage()));
    }

}

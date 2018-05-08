package com.xrom.server.controller;

import com.xrom.server.response.WebResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.xrom.server.response.WebResponse.success;


/**
 * @author: XRom
 * @date: 2018-04-23 10:42:31
 */
@Controller
@RequestMapping(value = "admin/user")
public class UserController {

    /**
     * 登录页面
     * @return
     */
    @GetMapping(value = "/login")
    public String goLogin() {
        return "login";
    }

    /**
     * 用户登录
     * @param username  用户名
     * @param password  用户密码
     * @return
     */
    @PostMapping(value = "/login")
    public WebResponse login(String username, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        return success();
    }

    /**
     * 拥有user:view权限才能访问此接口
     * @return  json数据
     */
    @GetMapping(value = "/auth")
    @ResponseBody
    @RequiresPermissions("user:view")
    public WebResponse auth() {
        return success();
    }
}

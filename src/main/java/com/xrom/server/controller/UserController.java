package com.xrom.server.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author: XRom
 * @date: 2018-04-23 10:42:31
 */
@Controller
@RequestMapping(value = "/user")
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
     * @param modelMap
     * @param username  用户名
     * @param password  用户密码
     * @return
     */
    @PostMapping(value = "/login")
    public String login(ModelMap modelMap, String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            modelMap.addAttribute("msg", "用户不存在");
            return "index";
        } catch (IncorrectCredentialsException e) {
            modelMap.addAttribute("msg", "用户密码错误");
            return "index";
        }
        modelMap.addAttribute("msg", "登陆成功");
        return "index";
    }
}

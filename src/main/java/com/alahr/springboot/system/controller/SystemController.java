package com.alahr.springboot.system.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sys")
public class SystemController {
    @RequestMapping(value = "/login")
    public String login(@RequestParam("userName")String userName, @RequestParam("password")String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

        subject.login(token);

        System.out.println(subject.getPrincipal().toString());

        if(null != subject.getSession().getId()){
            return "success, sessionId="+subject.getSession().getId();
        }

        return "error";
    }
}

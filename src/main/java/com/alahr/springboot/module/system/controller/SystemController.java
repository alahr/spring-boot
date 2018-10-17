package com.alahr.springboot.module.system.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sys")
public class SystemController {
    private Logger logger = LoggerFactory.getLogger(SystemController.class);

    @RequestMapping(value = "/login")
    public String login(@RequestParam("userName")String userName, @RequestParam("password")String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

        try {
            subject.login( token );
            logger.info("principal : {}. ", subject.getPrincipal().toString());

            if(subject.hasRole("admin")){
                logger.info("I am an admin user");
            }
            else{
                logger.info("I am common user");
            }

            if(null != subject.getSession().getId()){
                return "success, sessionId="+subject.getSession().getId();
            }
        } catch ( UnknownAccountException uae ) {
            logger.error("username wasn't in the system, show them an error message", uae);
        } catch ( IncorrectCredentialsException ice ) {
            logger.error("password didn't match, try again", ice);
        } catch ( LockedAccountException lae ) {
            logger.error("account for that username is locked - can't login.  Show them a message", lae);
        } catch ( AuthenticationException ae ) {
            logger.error("unexpected condition - error", ae);
        }

        return "error";
    }
}

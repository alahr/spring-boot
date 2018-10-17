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
public class SystemController {
    private Logger logger = LoggerFactory.getLogger(SystemController.class);

    @RequestMapping(value = "/login")
    public String login(@RequestParam("userName")String userName, @RequestParam("password")String password){
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);

        try {
            subject.login(token);
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
        } catch (UnknownAccountException uae) {
            logger.error("There is no user with username of " + token.getPrincipal());
        } catch (IncorrectCredentialsException ice) {
            logger.error("Password for account " + token.getPrincipal() + " was incorrect!");
        } catch (LockedAccountException lae) {
            logger.error("The account for username " + token.getPrincipal() + " is locked.  " +
                    "Please contact your administrator to unlock it.");
        }
        // ... catch more exceptions here (maybe custom ones specific to your application?
        catch (AuthenticationException ae) {
            logger.error("unexpected condition?  error?");
        }
        return "error";
    }


    @RequestMapping(value = "/home")
    public String home(){
        return "Welcome to the Spring Boot!";
    }

    @RequestMapping(value = "/unauthorized")
    public String unauthorized(){
        return "you do not have the authorization to open this page.";
    }
}

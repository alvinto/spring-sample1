package com.ws.web;

import com.ws.entity.User;
import com.ws.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by alvin on 2016/5/7.
 */
//标注成为一个springmvc的controller
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index.html")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value="/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request,LoginCommand loginCommand){
        boolean isValidUser = userService.hasMatchUser(loginCommand.getUsername(),loginCommand.getPassword());
        if(!isValidUser){
            return new ModelAndView("login","error","用户名密码错误");
        }
        User user = userService.findUserByName(loginCommand.getUsername());
        user.setLastIp(request.getLocalAddr());
        user.setLastVisit(new Date());
        userService.loginSuccess(user);
        request.getSession().setAttribute("user",user);
        return new ModelAndView("main");
    }
}

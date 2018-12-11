package org.xd.newsplatform.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.xd.newsplatform.pojo.user;
import org.xd.newsplatform.service.userService;

import javax.servlet.http.HttpSession;
/**
 *
 * registerStatus包在httpSession里用来传递注册状态
 * check用来判断注册是否成功，以及失败的愿因
 * 1 成功
 * 2 账号已存在
 * 3 用户名已存在
 *
 */

@Controller
public class RegisterPage {
    @Autowired
    userService userService;
    @Autowired
    HttpSession httpSession;

    @PostMapping("/register")
    public String Register( @RequestParam("account")String account,
                            @RequestParam("password")String password,
                            @RequestParam("name")String name){
        user user=new user();
        user.setAccount(account);
        user.setName(name);
        user.setPassword(password);
        user.setUserRight(1);
        int check=userService.registerAccount(user);

        switch (check){
            case 2:httpSession.setAttribute("registerStatus",2);
                return "redirect:/register";
            case 3:httpSession.setAttribute("registerStatus",3);
                return "redirect:/register";
        }
        httpSession.setAttribute("registerStatus",1);
        return "redirect:/login";
    }

    @GetMapping("/register")
    public ModelAndView Register(){

        ModelAndView mov=new ModelAndView("registerPage");

        if(httpSession.getAttribute("registerStatus")==null){
            mov.addObject("check","请注册");
        }
        else {
            int check=(int)httpSession.getAttribute("registerStatus");
            switch (check){
                case 2:mov.addObject("check","账号已存在，请重试");
                case 3:mov.addObject("check","用户名已存在，请重试");
            }
            httpSession.removeAttribute("registerStatus");
        }
        return mov;
    }
}

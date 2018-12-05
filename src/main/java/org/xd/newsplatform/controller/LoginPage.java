package org.xd.newsplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.xd.newsplatform.pojo.news;
import org.xd.newsplatform.pojo.user;
import org.xd.newsplatform.service.newsService;
import org.xd.newsplatform.service.userService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * check用来判断登陆状态
 *
 */

@Controller
public class LoginPage {
    @Autowired
    userService userService;
    @Autowired
    newsService newsService;
    @Autowired
    HttpSession httpSession;

    @PostMapping("/login")
    public String Login(@RequestParam("account")String account,
                              @RequestParam("password")String password){

        user user=new user();
        user.setAccount(account);
        user.setPassword(password);

        int check=userService.login(user);
        if(check==0){
            httpSession.setAttribute("loginError",0);
            return "redirect:/login";
        }
        else if(check==2){
            httpSession.setAttribute("loginError",2);
            return "redirect:/login";
        }
        else {
            user sessionUser=userService.getUser(account);
            httpSession.setAttribute("user",sessionUser);
            httpSession.setAttribute("userRight",sessionUser.getUserRight());
            httpSession.removeAttribute("loginError");
            return "redirect:/";
        }
    }

    @GetMapping("/login")
    public ModelAndView Login(){
        if(httpSession.getAttribute("loginError")==null){
            if(httpSession.getAttribute("registerStatus")!=null){
                ModelAndView mov=new ModelAndView("loginPage");
                mov.addObject("check","注册成功请登录");
                httpSession.removeAttribute("registerStatus");
                return mov;
            }
            else {
                ModelAndView mov=new ModelAndView("loginPage");
                mov.addObject("check","请登陆");
                return mov;
            }
        }
        else if((int)httpSession.getAttribute("loginError")==0){
            ModelAndView mov=new ModelAndView("loginPage");
            mov.addObject("check","账号不存在，请重试");
            return mov;
        }
        else {
            ModelAndView mov=new ModelAndView("loginPage");
            mov.addObject("check","密码不正确，请重试");
            return mov;
        }
    }
}

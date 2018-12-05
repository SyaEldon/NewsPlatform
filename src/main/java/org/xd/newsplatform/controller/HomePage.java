package org.xd.newsplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.xd.newsplatform.pojo.news;
import org.xd.newsplatform.pojo.user;
import org.xd.newsplatform.service.newsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomePage {

    @Autowired
    newsService newsService;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/")
    public ModelAndView homePage(){
        System.out.println(httpSession.getId());
        user checkUser=new user();
        if(httpSession.getAttribute("user")==null)
            httpSession.setAttribute("userRight",0);
        else {
            checkUser=(user)httpSession.getAttribute("user");
        }
        int userRight=(int)httpSession.getAttribute("userRight");
        List<news> newsList=newsService.getNewsList();
        ModelAndView mov=new ModelAndView("homePage");

        switch (userRight){
            case 0: mov.addObject("userRight","游客");
                    mov.addObject("loginButton","block");
                    mov.addObject("logoutButton","none");
                    break;
            case 1: mov.addObject("userRight","(注册用户)"+checkUser.getName());
                    mov.addObject("loginButton","none");
                    mov.addObject("logoutButton","block");
                    break;
            case 2: mov.addObject("userRight","(管理员)"+checkUser.getName());
                    mov.addObject("loginButton","none");
                    mov.addObject("logoutButton","block");
                    break;
        }

        mov.addObject("list",newsList);
        return mov;
    }

    @GetMapping("/logout")
    public String logout(){
        httpSession.invalidate();
        return "redirect:/";
    }

}


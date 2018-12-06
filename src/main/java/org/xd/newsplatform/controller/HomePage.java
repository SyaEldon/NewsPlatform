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
    public String init(){
        return "redirect:/homepage?type=1";
    }

    @GetMapping("/homepage")
    public ModelAndView homePage(news news){
        System.out.println(httpSession.getId());
        user checkUser=new user();
        if(httpSession.getAttribute("user")==null)
            httpSession.setAttribute("userRight",0);
        else {
            checkUser=(user)httpSession.getAttribute("user");
        }
        int userRight=(int)httpSession.getAttribute("userRight");

        List<news> newsList=newsService.getNewsListByType(news.getType());
        ModelAndView mov=new ModelAndView("homePage");

        switch (userRight){
            case 0: mov.addObject("userRight","游客")
                    .addObject("buttonFunction","login()")
                    .addObject("postNews","")
                    .addObject("administrator","")
                    .addObject("buttonContent","登陆/注册");
                    break;
            case 1: mov.addObject("userRight","(注册用户)"+checkUser.getName())
                    .addObject("buttonFunction","logout()")
                    .addObject("postNews","")
                    .addObject("administrator","")
                    .addObject("buttonContent","退出");
                    break;
            case 2: mov.addObject("userRight","(新闻发布员)"+checkUser.getName())
                    .addObject("buttonFunction","logout()")
                    .addObject("postNews","<a href=\"/postNewsPage\"  target=\"_blank\" >发布新文章</a>")
                    .addObject("administrator","")
                    .addObject("buttonContent","退出");
                    break;
            case 3: mov.addObject("userRight","(管理员)"+checkUser.getName())
                    .addObject("buttonFunction","logout()")
                    .addObject("postNews","<a href=\"/postNewsPage\" id=\"loginButton\" target=\"_blank\" >发布新文章</a>")
                    .addObject("administrator","<a href=\"/administratorPage\"  target=\"_blank\" >发布新文章</a>")
                    .addObject("buttonContent","退出");
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


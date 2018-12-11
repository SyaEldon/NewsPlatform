package org.xd.newsplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.xd.newsplatform.pojo.news;
import org.xd.newsplatform.pojo.user;
import org.xd.newsplatform.service.newsService;

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
        user checkUser=new user();
        if(httpSession.getAttribute("user")==null)
            httpSession.setAttribute("userRight",0);
        else {
            checkUser=(user)httpSession.getAttribute("user");
        }

        List<news> newsList=newsService.getNewsListByType(news.getType());
        ModelAndView mov=new ModelAndView("homePage");
        mov.addObject("user",checkUser);
        mov.addObject("list",newsList);
        return mov;
    }

    @GetMapping("/logout")
    public String logout(){
        httpSession.invalidate();
        return "redirect:/";
    }

}


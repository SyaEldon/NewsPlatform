package org.xd.newsplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.xd.newsplatform.pojo.news;
import org.xd.newsplatform.pojo.page;
import org.xd.newsplatform.pojo.user;
import org.xd.newsplatform.service.newsService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomePageController {

    @Autowired
    newsService newsService;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/")
    public String init(){
        return "redirect:/homepage?type=1&pageNum=1";
    }

    @GetMapping("/homepage")
    public ModelAndView homePage(@RequestParam("type")int type,
                                 @RequestParam("pageNum")int pageNum){
        user checkUser=new user();
        if(httpSession.getAttribute("user")==null){
            httpSession.setAttribute("userRight",0);
        }
        else {
            checkUser=(user)httpSession.getAttribute("user");
        }

//        List<news> newsList=newsService.getNewsListByType(news.getType());
        page<news> page=newsService.getNewsPageListByType(type,pageNum);
        ModelAndView mov=new ModelAndView("homePage");
        mov.addObject("user",checkUser);
//        mov.addObject("list",newsList.getList());
        mov.addObject("page",page);
        mov.addObject("type",type);
        return mov;
    }

    @GetMapping("/logout")
    public String logout(){
        httpSession.invalidate();
        return "redirect:/";
    }

}


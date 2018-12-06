package org.xd.newsplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.xd.newsplatform.pojo.news;
import org.xd.newsplatform.pojo.user;
import org.xd.newsplatform.service.newsService;

import javax.servlet.http.HttpSession;

@Controller
public class postNewsPage {

    @Autowired
    HttpSession httpSession;

    @Autowired
    newsService newsService;

    @GetMapping("/postNewsPage")
    public ModelAndView postNewsPage(){

        if((int)httpSession.getAttribute("userRight")<=1){
            ModelAndView mov=new ModelAndView("errorPage");
            return mov;
        }
        else {
            ModelAndView mov=new ModelAndView("postNewsPage");
            return mov;
        }
    }

    @PostMapping("/postNews")
    public String postNews(@RequestParam("newsTitle")String newsTitle,
                                 @RequestParam("newsContent")String newsContent,
                                 @RequestParam("newsTypeNum")String newsTypeNum){

        news postNews=new news();

        postNews.setTitle(newsTitle);
        postNews.setContent(newsService.contentReplaca(newsContent));
        postNews.setType(Integer.valueOf(newsTypeNum));
        postNews.setViewCount(0);
        postNews.setUserAccount(((user)httpSession.getAttribute("user")).getAccount());
        postNews.setVisible(1);

        newsService.insertNews(postNews);

        return "redirect:/";
    }

}

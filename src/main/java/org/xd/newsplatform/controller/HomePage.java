package org.xd.newsplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.xd.newsplatform.pojo.news;
import org.xd.newsplatform.service.newsService;

import java.util.List;

@Controller
public class HomePage {

    @Autowired
    newsService newsService;

    @RequestMapping("/hello")
    public String init(){
        return "hello";
    }

    @GetMapping("/")
    public ModelAndView homePage(){
        List<news> newsList=newsService.getNewsList();
        ModelAndView mov=new ModelAndView("homePage");
        mov.addObject("list",newsList);
        return mov;
    }

    @GetMapping("/page/newsPage")
    public ModelAndView newsPage(news news){
        news viewNews=newsService.getNewsByNewsId(news.getNewsId());
        ModelAndView mov=new ModelAndView("newsPage");
        mov.addObject("title",viewNews.getTitle());
        mov.addObject("content",viewNews.getContent());
        return mov;
    }





}


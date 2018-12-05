package org.xd.newsplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.xd.newsplatform.pojo.news;
import org.xd.newsplatform.service.newsService;

import javax.servlet.http.HttpSession;

public class newsPage {
    @Autowired
    org.xd.newsplatform.service.newsService newsService;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/page/newsPage")
    public ModelAndView newsPage(news news){
        news viewNews=newsService.getNewsByNewsId(news.getNewsId());
        ModelAndView mov=new ModelAndView("newsPage");
        mov.addObject("title",viewNews.getTitle());
        mov.addObject("content",viewNews.getContent());
        return mov;
    }
}

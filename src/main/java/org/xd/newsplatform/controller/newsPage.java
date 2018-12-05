package org.xd.newsplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.xd.newsplatform.pojo.news;
import org.xd.newsplatform.pojo.reply;
import org.xd.newsplatform.service.newsService;
import org.xd.newsplatform.service.replyService;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Max;
import java.util.List;

@Controller
public class newsPage {
    @Autowired
    org.xd.newsplatform.service.newsService newsService;

    @Autowired
    replyService replyService;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/page/newsPage")
    public ModelAndView newsPage(news news){
        news viewNews=newsService.getNewsByNewsId(news.getNewsId());
        ModelAndView mov=new ModelAndView("newsPage");
        mov.addObject("title",viewNews.getTitle());
        mov.addObject("content",viewNews.getContent());
        List<reply> replyList=replyService.getReplyListByNewsId(news.getNewsId());
        mov.addObject("list",replyList);
        return mov;
    }
}

package org.xd.newsplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.xd.newsplatform.pojo.news;
import org.xd.newsplatform.pojo.reply;
import org.xd.newsplatform.pojo.user;
import org.xd.newsplatform.service.replyService;
import org.xd.newsplatform.service.userService;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class NewsPageController {
    @Autowired
    org.xd.newsplatform.service.newsService newsService;

    @Autowired
    replyService replyService;

    @Autowired
    userService userService;

    @Autowired
    HttpSession httpSession;

    @GetMapping("/page/newsPage")
    public ModelAndView newsPage(news news){
        user viewUser=(user)httpSession.getAttribute("user");
        news viewNews=newsService.getNewsByNewsId(news.getNewsId());
        viewNews.setViewCount(viewNews.getViewCount()+1);
        newsService.updateViewCount(viewNews.getViewCount(),viewNews.getNewsId());
        user newsPostUser=userService.getUser(viewNews.getUserAccount());
        ModelAndView mov=new ModelAndView("newsPage");
        mov.addObject("viewNews",viewNews)
                .addObject("newsUser",newsPostUser.getName())
                .addObject("viewUser", viewUser);


        List<reply> replyList=replyService.getReplyListByNewsId(news.getNewsId());
        Map<reply,user> replyAndUserMap=new LinkedHashMap<>();
        if(replyList!=null){
            for (reply singleReply:replyList) {
                user replyUser=userService.getUser(singleReply.getUserAccount());
                replyAndUserMap.put(singleReply,replyUser);
            }
            mov.addObject("list",replyAndUserMap);
        }

        return mov;
    }

    @PostMapping("/postReply")
    public String replyPost(@RequestParam("replyContent")String replyContent,
                            @RequestParam("newsId")String newsId){
        if((int)httpSession.getAttribute("userRight")==0){
            return "redirect:/login";
        }
        else {
            reply postReply=new reply();
            postReply.setContent(replyService.replyReplaca(replyContent));
            postReply.setNewsId(Integer.valueOf(newsId));
            postReply.setUserAccount(((user) httpSession.getAttribute("user")).getAccount());
            replyService.postReply(postReply);
            return "redirect:/page/newsPage?newsId="+newsId;
        }
    }

    @PostMapping("/deleteReply")
    public String deletePost(@RequestParam("replyId")String replyId,
                             @RequestParam("deleteReplyNewsId")String deleteReplyNewsId){
        replyService.deleteReplyByReplyId(Integer.valueOf(replyId));
        return "redirect:/page/newsPage?newsId="+deleteReplyNewsId;

    }


}

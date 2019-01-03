package org.xd.newsplatform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import org.xd.newsplatform.mapper.ReplyMapper;
import org.xd.newsplatform.pojo.user;
import org.xd.newsplatform.service.newsService;
import org.xd.newsplatform.service.replyService;

import javax.servlet.http.HttpSession;

@Controller
public class UserPageController {

    @Autowired
    HttpSession httpSession;
    @Autowired
    replyService replyService;
    @Autowired
    newsService newsService;

    @GetMapping("/userpage")
    public ModelAndView UserPage(){
       ModelAndView mov=new ModelAndView();
        if(httpSession.getAttribute("user")==null){
            httpSession.setAttribute("userRight",0);
            mov.setViewName("errorPage");
        }
        else {
            user user=(user)httpSession.getAttribute("user");
            mov.setViewName("userPage");
            mov.addObject("user", user);
            int userReplyCount=replyService.getReplyCount(user.getAccount());
            int userNewsCount=newsService.getUserNewsCount(user.getAccount());
            mov.addObject("replyCount",userReplyCount).addObject("userNewsCount",userNewsCount);

        }

        return mov;
    }
}

package org.xd.newsplatform.controller;

import org.apache.ibatis.annotations.Param;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class administratorPage {
    @Autowired
    HttpSession httpSession;

    @Autowired
    newsService newsService;

    @GetMapping("/administratorPage")
    public ModelAndView administratorPage(){
        user viewUser=(user)httpSession.getAttribute("user");
        if(viewUser.getUserRight()!=3){
            ModelAndView mov=new ModelAndView("errorPage");
            return mov;
        }
        else {
            List<news> newsList = newsService.getNewsList();
            Map<news,String> newsMap=new HashMap<>();
            if(newsList!=null){
                for (news news:newsList){
                    newsMap.put(news,newsService.getTypeName(news.getType()));
                }
            }

            ModelAndView mov=new ModelAndView("administratorPage");
            mov.addObject("list",newsMap)
                    .addObject("userName",viewUser.getName());
            return mov;
        }
    }

    @PostMapping("/administratorPage/delete")
    public String delete(@RequestParam("delete")int newsId){
        newsService.deleteNews(newsId);
        return "redirect:/administratorPage";
    }

    @PostMapping("/administratorPage/updateVisible")
    public String updateVisible(@RequestParam("visible")int newsId){
        newsService.updateVisible(newsId);
        return "redirect:/administratorPage";
    }

}

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
import org.xd.newsplatform.service.userService;

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

    @Autowired
    userService userService;

    @GetMapping("/administratorNewsPage")
    public ModelAndView administratorNewsPage(){
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

            ModelAndView mov=new ModelAndView("administratorNewsPage");
            mov.addObject("list",newsMap)
                    .addObject("userName",viewUser.getName());
            return mov;
        }
    }

    @PostMapping("/administratorNewsPage/delete")
    public String delete(@RequestParam("delete")int newsId){
        newsService.deleteNews(newsId);
        return "redirect:/administratorNewsPage";
    }

    @PostMapping("/administratorNewsPage/updateVisible")
    public String updateVisible(@RequestParam("visible")int newsId){
        newsService.updateVisible(newsId);
        return "redirect:/administratorNewsPage";
    }

    @PostMapping("/administratorNewsPage/reviseNews")
    public String updateVisible(@RequestParam("newsTitle")String newsTitle,
                                @RequestParam("newsContent")String newsContent,
                                @RequestParam("newsTypeNum")String newsTypeNum,
                                @RequestParam("newsId")int newsId){
        news reviseNews=newsService.getNewsByNewsId(newsId);
        if (newsTitle!=""){
            reviseNews.setTitle(newsTitle);
        }
        reviseNews.setContent(newsService.contentReplace(newsContent));
        reviseNews.setType(Integer.valueOf(newsTypeNum));
        reviseNews.setVisible(1);

        newsService.reviseNews(reviseNews);

        return "redirect:/administratorNewsPage";
    }

    @GetMapping("/administratorNewsPage/reviseNews")
    public ModelAndView updateVisible(news news){
        news reviseNews=newsService.getNewsByNewsId(news.getNewsId());
        ModelAndView mov=new ModelAndView("reviseNewsPage");

        mov.addObject("title",reviseNews.getTitle())
                .addObject("newsId",reviseNews.getNewsId())
                .addObject("content",newsService.reContentReplaca(reviseNews.getContent()))
                .addObject("type",newsService.getTypeName(reviseNews.getType()));

        return mov;
    }

    @GetMapping("/administratorUserPage")
    public ModelAndView administratorUserPage(){
        user viewUser=(user)httpSession.getAttribute("user");
        if(viewUser.getUserRight()!=3){
            ModelAndView mov=new ModelAndView("errorPage");
            return mov;
        }
        else {
            List<user> userList = userService.getUserList();
            Map<user,String> userMap=new HashMap<>();
            if(userList!=null){
                for (user user:userList){
                    userMap.put(user,userService.getUserRightName(user.getUserRight()));
                }
            }
            ModelAndView mov=new ModelAndView("administratorUserPage");
            mov.addObject("list",userMap)
                    .addObject("userName",viewUser.getName());
            return mov;
        }
    }

    @PostMapping("/administratorUserPage/updateUserRight")
    public String updateUserRight(@RequestParam("userId")int userId,
                                  @RequestParam("userRight")int userRight){
        if(userRight==0){
            userService.deleteUser(userId);
            return "redirect:/administratorUserPage";
        }
        else {
            userService.updateUserRight(userRight,userId);
            return "redirect:/administratorUserPage";
        }
    }

}

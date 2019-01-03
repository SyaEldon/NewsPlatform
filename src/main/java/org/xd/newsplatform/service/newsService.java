package org.xd.newsplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xd.newsplatform.mapper.NewsMapper;
import org.xd.newsplatform.pojo.news;
import org.xd.newsplatform.pojo.page;

import java.util.List;

@Service
public class newsService {
    @Autowired
    NewsMapper newsMapper;

    public List<news> getNewsList(){
        List<news> newsList=newsMapper.getNewsList();
        return newsList;
    }

    public List<news> getNewsListByType(int type){
        List<news> newsList=newsMapper.getNewsListByType(type);
        return newsList;
    }

    /**
     * 实现分页功能
     * @param type
     * @param pageNum
     * @return
     */
    public page<news> getNewsPageListByType(int type,int pageNum){
        int pageSize=5;
        List<news> newsList=newsMapper.getNewsListByType(type);
        int totalRecord=newsList.size();
        page page=new page(pageNum,pageSize,totalRecord);
        int startIndex=page.getStartIndex();
        if(totalRecord-pageSize*(pageNum-1)<pageSize){
            page.setList(newsList.subList(startIndex,totalRecord));
        }
        else {
            page.setList(newsList.subList(startIndex,startIndex+pageSize));
        }
        return page;
    }

    public news getNewsByNewsId(int newsId){
        news news=newsMapper.getNewsByNewsId(newsId);
        return news;
    }

    public void updateViewCount(int viewCout,int newsId){
        newsMapper.updateViewCount(viewCout,newsId);
    }

    public void insertNews(news news){
        newsMapper.insertNews(news);
    }

    public String getTypeName(int type){
        switch(type){
            case 1:return "国外";
            case 2:return "国内";
            case 3:return "体育";
            case 4:return "娱乐";
            case 5:return "旅游";
            case 6:return "教育";
        }
        return "Unkown";
    }

    public String contentReplace(String content){
        return content.replace(" ","&nbsp").replace("\r\n","<br>");
    }

    public String reContentReplaca(String content){
        return content.replace("&nbsp"," ").replace("<br>","\r\n");
    }

    public void deleteNews(int newsId){
        newsMapper.deleteNews(newsId);
    }

    public void updateVisible(int newsId){
        news news=newsMapper.getNewsByNewsId(newsId);
        newsMapper.updateNewsVisible(news.getVisible()*-1,newsId);
    }

    public void reviseNews(news news){
        newsMapper.reviseNews(news);
    }

    public void deleteNewsByUser(String userAccount){
        newsMapper.deleteNewsByUser(userAccount);
    }

    public int getUserNewsCount(String userAccount){
        return newsMapper.userNewsCount(userAccount);
    }
}

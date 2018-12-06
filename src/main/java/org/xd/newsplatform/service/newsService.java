package org.xd.newsplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xd.newsplatform.mapper.NewsMapper;
import org.xd.newsplatform.pojo.news;

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

    public news getNewsByNewsId(int newsId){
        System.out.println(newsId);
        news news=newsMapper.getNewsByNewsId(newsId);
        return news;
    }

    public void updateViewCount(int viewCout,int newsId){
        newsMapper.updateViewCount(viewCout,newsId);
    }

    public void insertNews(news news){
        newsMapper.insertNews(news);
    }

    public String contentReplaca(String content){
        return content.replace(" ","&nbsp").replace("\r\n","<br>");
    }
}

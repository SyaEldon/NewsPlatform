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

    public news getNewsByNewsId(int newsId){
        news news=newsMapper.getNewsByNewsId(newsId);
        return news;
    }
}

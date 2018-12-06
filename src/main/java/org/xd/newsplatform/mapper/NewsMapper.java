package org.xd.newsplatform.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.xd.newsplatform.pojo.news;

import java.util.List;


@Mapper
@Repository
public interface NewsMapper {
    List<news> getNewsList();

    List<news> getNewsListByType(int type);

    news getNewsByNewsId(int newsId);

    int getNewsCount(int newsId);

    int updateViewCount(@Param(value = "viewCount") int viewCount,@Param(value = "newsId") int newsId);

    int updateNewsVisible(@Param(value = "visible") int viewCount,@Param(value = "newsId") int newsId);

    int insertNews(news news);

    int deleteNews(int newsId);

    int reviseNews(news news);

}

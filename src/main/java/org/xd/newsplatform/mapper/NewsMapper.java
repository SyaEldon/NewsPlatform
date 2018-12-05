package org.xd.newsplatform.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.xd.newsplatform.pojo.news;

import java.util.List;


@Mapper
@Repository
public interface NewsMapper {
    List<news> getNewsList();
    news getNewsByNewsId(int newsId);
    int getNewsCount(int newsId);
}

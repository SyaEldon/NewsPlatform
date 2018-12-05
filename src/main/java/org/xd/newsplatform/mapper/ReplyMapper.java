package org.xd.newsplatform.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.xd.newsplatform.pojo.reply;

import java.util.List;

@Mapper
@Repository
public interface ReplyMapper {
    List<reply> getReplyListByNewsId(int newsId);
    int postReply(reply reply);
}

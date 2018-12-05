package org.xd.newsplatform.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xd.newsplatform.mapper.ReplyMapper;
import org.xd.newsplatform.pojo.reply;

import java.util.List;

@Service
public class replyService {
    @Autowired
    ReplyMapper replyMapper;

    public List<reply> getReplyListByNewsId(int newsId){
        List<reply> replyList=replyMapper.getReplyListByNewsId(newsId);
        return replyList;
    }
}
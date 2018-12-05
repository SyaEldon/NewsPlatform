package org.xd.newsplatform.pojo;

import java.util.Date;

public class reply {
    private int replyId;
    private String content;
    private String userAccount;
    private int newsId;
    private Date gmt_creat;
    public Date getGmt_creat() {
        return gmt_creat;
    }

    public void setGmt_creat(Date gmt_creat) {
        this.gmt_creat = gmt_creat;
    }

    public int getReplyId() {
        return replyId;
    }

    public void setReplyId(int replyId) {
        this.replyId = replyId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }


}

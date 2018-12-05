package org.xd.newsplatform.pojo;

import java.text.DateFormat;
import java.util.Date;

/**
 * type
 * 1 国外
 * 2 国内
 * 3 体育
 * 4 娱乐
 * 5 旅游
 * 6 教育
 */
public class news {
    private int newsId;
    private String title;
    private String content;
    private String userAccount;
    private int type;
    private int viewCount;
    private int visible;


    private Date gmt_creat;
    public Date getGmt_creat() {
        return gmt_creat;
    }

    public void setGmt_creat(Date gmt_creat) {
        this.gmt_creat = gmt_creat;
    }



    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNewsId() {
        return newsId;
    }

    public void setNewsId(int newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public int getViewCount() {
        return viewCount;
    }

    public void setViewCount(int viewCount) {
        this.viewCount = viewCount;
    }

    public int getVisible() {
        return visible;
    }

    public void setVisible(int visible) {
        this.visible = visible;
    }


}

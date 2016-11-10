package com.wildwolf.myjrtt.beans;

import java.io.Serializable;

/**
 * Created by ${wild00wolf} on 2016/11/10.
 */
public class NewsBean implements Serializable{
    /**
     * docid
     */
    public String docid;
    /**
     * 标题
     */
    public String title;
    /**
     * 小内容
     */
    public String digest;
    /**
     * 图片地址
     */
    public String imgsrc;
    /**
     * 来源
     */
    public String source;
    /**
     * 时间
     */
    public String ptime;
    /**
     * TAG
     */
    private String tag;

    public String url;

    public String getDocid() {
        return docid;
    }

    public void setDocid(String docid) {
        this.docid = docid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDigest() {
        return digest;
    }

    public void setDigest(String digest) {
        this.digest = digest;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

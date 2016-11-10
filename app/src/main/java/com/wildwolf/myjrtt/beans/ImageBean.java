package com.wildwolf.myjrtt.beans;

import java.io.Serializable;

/**
 * Created by ${wild00wolf} on 2016/11/10.
 */
public class ImageBean implements Serializable{

    private static final long serialVersionUID = 1L;

    private String title;
    private String thumburl;
    private String sourceurl;
    private int height;
    private int width;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumburl() {
        return thumburl;
    }

    public void setThumburl(String thumburl) {
        this.thumburl = thumburl;
    }

    public String getSourceurl() {
        return sourceurl;
    }

    public void setSourceurl(String sourceurl) {
        this.sourceurl = sourceurl;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}

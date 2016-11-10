package com.wildwolf.myjrtt.news.model;

import com.wildwolf.myjrtt.image.model.ImageModelImpl;

/**
 * Created by ${wild00wolf} on 2016/11/10.
 */
public interface NewsModel {
    void loadNews(String url, int type, NewsModelImpl.OnLoadNewsListListener listener);
}

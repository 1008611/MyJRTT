package com.wildwolf.myjrtt.news.view;

import com.wildwolf.myjrtt.beans.NewsBean;

import java.util.List;

/**
 * Created by ${wild00wolf} on 2016/11/10.
 */
public interface NewsView {
    void showProgress();

    void addNews(List<NewsBean> newsList);

    void hideProgress();

    void showLoadFailMsg();
}

package com.wildwolf.myjrtt.news.model;

import com.wildwolf.myjrtt.beans.ImageBean;
import com.wildwolf.myjrtt.beans.NewsBean;
import com.wildwolf.myjrtt.commons.Urls;
import com.wildwolf.myjrtt.image.ImageJsonUtils;
import com.wildwolf.myjrtt.news.NewsJsonUtils;
import com.wildwolf.myjrtt.news.widget.NewsFragment;
import com.wildwolf.myjrtt.utils.LogUtils;
import com.wildwolf.myjrtt.utils.OkHttpUtils;

import java.util.List;

/**
 * Created by ${wild00wolf} on 2016/11/10.
 */
public class NewsModelImpl implements NewsModel {

    @Override
    public void loadNews(String url, final int type, final OnLoadNewsListListener listener) {
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>() {
            @Override
            public void onSuccess(String response) {
                List<NewsBean> newsBeanList = NewsJsonUtils.readJsonNewsBeans(response, getID(type));
                listener.onSuccess(newsBeanList);
            }

            @Override
            public void onFailure(Exception e) {
                listener.onFailure("load news list failure.", e);
            }
        };
        OkHttpUtils.get(url, loadNewsCallback);
    }

    /**
     * 获取ID
     * @param type
     * @return
     */
    private String getID(int type) {
        String id;
        switch (type) {
            case NewsFragment.NEWS_TYPE_TOP:
                id = Urls.TOP_ID;
                break;
            case NewsFragment.NEWS_TYPE_NBA:
                id = Urls.NBA_ID;
                break;
            case NewsFragment.NEWS_TYPE_CARS:
                id = Urls.CAR_ID;
                break;
            case NewsFragment.NEWS_TYPE_JOKES:
                id = Urls.JOKE_ID;
                break;
            default:
                id = Urls.TOP_ID;
                break;
        }
        return id;
    }

    public interface OnLoadNewsListListener {
        void onSuccess(List<NewsBean> list);

        void onFailure(String msg, Exception e);
    }
}

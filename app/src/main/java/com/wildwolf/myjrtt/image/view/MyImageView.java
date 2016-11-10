package com.wildwolf.myjrtt.image.view;

import com.wildwolf.myjrtt.beans.ImageBean;

import java.util.List;

/**
 * Created by ${wild00wolf} on 2016/11/10.
 */
public interface MyImageView {
    void addImages(List<ImageBean> list);
    void showProgress();
    void hideProgress();
    void showLoadFaileMsg();
}

package com.wildwolf.myjrtt.image.presenter;


import com.wildwolf.myjrtt.beans.ImageBean;
import com.wildwolf.myjrtt.image.model.ImageModel;
import com.wildwolf.myjrtt.image.model.ImageModelImpl;
import com.wildwolf.myjrtt.image.view.MyImageView;

import java.util.List;

/**
 * Created by ${wild00wolf} on 2016/11/10.
 */
public class ImagePresenterImpl implements ImagePresenter, ImageModelImpl.OnLoadImageListListener {

    private MyImageView mImageView;
    private ImageModel mImageModel;

    public ImagePresenterImpl(MyImageView imageview) {
        this.mImageView  = imageview;
        this.mImageModel = new ImageModelImpl();
    }

    @Override
    public void loadImageList() {
        mImageView.showProgress();
        mImageModel.loadImageList(this);
    }

    @Override
    public void onSuccess(List<ImageBean> list) {
        mImageView.hideProgress();
        mImageView.addImages(list);
    }

    @Override
    public void onFailure(String msg, Exception e) {
        mImageView.hideProgress();
        mImageView.showLoadFaileMsg();
    }
}

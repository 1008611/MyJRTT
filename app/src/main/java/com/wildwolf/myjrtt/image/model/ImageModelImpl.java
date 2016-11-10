package com.wildwolf.myjrtt.image.model;

import android.util.Log;

import com.wildwolf.myjrtt.beans.ImageBean;
import com.wildwolf.myjrtt.commons.Urls;
import com.wildwolf.myjrtt.image.ImageJsonUtils;
import com.wildwolf.myjrtt.utils.LogUtils;
import com.wildwolf.myjrtt.utils.OkHttpUtils;

import java.util.List;

/**
 * Created by ${wild00wolf} on 2016/11/10.
 */
public class ImageModelImpl implements ImageModel {

    @Override
    public void loadImageList(final ImageModelImpl.OnLoadImageListListener listener) {
        String url = Urls.IMAGES_URL;
        OkHttpUtils.ResultCallback<String> loadNewsCallback = new OkHttpUtils.ResultCallback<String>(){

            @Override
            public void onSuccess(String response) {
                LogUtils.e("TAG------",response);
                List<ImageBean> iamgeBeanList = ImageJsonUtils.readJsonImageBeans(response);
                listener.onSuccess(iamgeBeanList);
            }

            @Override
            public void onFailure(Exception e) {
            listener.onFailure("load image list failure.", e);
            }
        };
        OkHttpUtils.get(url,loadNewsCallback);
    }

    public interface OnLoadImageListListener {
        void onSuccess(List<ImageBean> list);
        void onFailure(String msg, Exception e);
    }
}

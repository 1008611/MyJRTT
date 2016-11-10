package com.wildwolf.myjrtt.image;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.wildwolf.myjrtt.beans.ImageBean;
import com.wildwolf.myjrtt.utils.JsonUtils;
import com.wildwolf.myjrtt.utils.LogUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ${wild00wolf} on 2016/11/10.
 */
public class ImageJsonUtils {
    private final static String TAG = "ImageJsonUtils";
    /**
     * 将获取到的json转换为图片列表对象
     * @param res
     * @return
     */
    public static List<ImageBean> readJsonImageBeans(String res) {
        List<ImageBean> beans = new ArrayList<ImageBean>();
        try {
            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(res).getAsJsonArray();
            for (int i = 1; i < jsonArray.size(); i++) {
                JsonObject jo = jsonArray.get(i).getAsJsonObject();
                ImageBean news = JsonUtils.deserialize(jo, ImageBean.class);
                beans.add(news);
            }
        } catch (Exception e) {
            LogUtils.e(TAG, "readJsonImageBeans error", e);
        }
        return beans;
    }
}
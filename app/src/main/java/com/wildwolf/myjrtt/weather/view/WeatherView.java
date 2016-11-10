package com.wildwolf.myjrtt.weather.view;

import com.wildwolf.myjrtt.beans.ImageBean;
import com.wildwolf.myjrtt.beans.WeatherBean;

import java.util.List;

/**
 * Created by ${wild00wolf} on 2016/11/10.
 */
public interface WeatherView {

    void showProgress();
    void hideProgress();

    void showWeatherLayout();

    void setCity(String city);
    void setToday(String data);
    void setTemperature(String temperature);
    void setWind(String wind);
    void setWeather(String weather);
    void setWeatherImage(int res);
    void setWeatherData(List<WeatherBean> lists);

    void showErrorToast(String msg);


}

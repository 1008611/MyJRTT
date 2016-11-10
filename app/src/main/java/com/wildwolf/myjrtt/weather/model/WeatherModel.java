package com.wildwolf.myjrtt.weather.model;

import android.content.Context;

/**
 * Created by ${wild00wolf} on 2016/11/10.
 */
public interface WeatherModel {
    void loadWeatherData(String cityName, WeatherModelImpl.LoadWeatherListener listener);

    void loadLocation(Context context, WeatherModelImpl.LoadLocationListener listener);
}

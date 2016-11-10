package com.wildwolf.myjrtt.beans;

import java.io.Serializable;

/**
 * Created by ${wild00wolf} on 2016/11/10.
 */
public class WeatherBean implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * temperature
     */
    private String temperature;
    /**
     * weather
     */
    private String weather;
    /**
     * wind
     */
    private String wind;
    /**
     * week
     */
    private String week;
    /**
     * date
     */
    private String date;

    private int imageRes;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getImageRes() {
        return imageRes;
    }

    public void setImageRes(int imageRes) {
        this.imageRes = imageRes;
    }
}

package com.diachenko.weatherforecast.utils;

public class Constants {

    private Constants() {
    }

    public static final String BASE_URL = "https://api.openweathermap.org/";

    public static final String API_KEY = "1936eb95c8bbeb558934050c2d7a26f6";

    public static final String WEATHER_BY_CITY_NAME_PATH = "/data/2.5/weather?&units=metric&APPID="
            + API_KEY;
    public static final String FORECAST_BY_COORDINATIES_PATH = "/data/2.5/forecast?&units=metric&APPID="
            + API_KEY;
    public static final String WEATHER_ICON_PATH ="http://openweathermap.org/img/w/";
}

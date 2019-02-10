package com.diachenko.weatherforecast.data;

import android.arch.lifecycle.LiveData;

import com.diachenko.weatherforecast.data.api.CurrentWeatherResponse;
import com.diachenko.weatherforecast.data.api.responses.WeatherForecastResponse;
import com.diachenko.weatherforecast.utils.Constants;
import com.github.leonardoxh.livedatacalladapter.Resource;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    @GET(Constants.WEATHER_BY_CITY_NAME_PATH)
    LiveData<Resource<CurrentWeatherResponse>> getCurrentWeather(@Query("q") String cityName);

    @GET(Constants.FORECAST_BY_COORDINATIES_PATH)
    LiveData<Resource<WeatherForecastResponse>> getForecastByCoordinates(@Query("lat")Double lat,
                                                                         @Query("lon")Double lon);



}

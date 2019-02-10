package com.diachenko.weatherforecast.ui.viewmodels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.diachenko.weatherforecast.data.WeatherApi;
import com.diachenko.weatherforecast.data.api.responses.WeatherForecastResponse;
import com.github.leonardoxh.livedatacalladapter.Resource;
import com.google.android.gms.maps.model.LatLng;


public class WeatherViewModel extends ViewModel {

    public static final String TAG = WeatherViewModel.class.getCanonicalName();

    private WeatherApi weatherApi;

    public WeatherViewModel(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    public LiveData<Resource<WeatherForecastResponse>> getCurrentWeather(LatLng location) {
        return weatherApi.getForecastByCoordinates(location.latitude,location.longitude);
    }
}

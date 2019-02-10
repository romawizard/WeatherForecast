package com.diachenko.weatherforecast.di.modules;

import android.arch.lifecycle.ViewModelProvider;

import com.diachenko.weatherforecast.data.WeatherApi;
import com.diachenko.weatherforecast.di.ActivityScope;
import com.diachenko.weatherforecast.ui.viewmodels.WeatherViewModel;
import com.diachenko.weatherforecast.ui.viewmodels.WeatherViewModelProvideFactory;
import com.diachenko.weatherforecast.utils.Constants;
import com.github.leonardoxh.livedatacalladapter.LiveDataCallAdapterFactory;
import com.github.leonardoxh.livedatacalladapter.LiveDataResponseBodyConverterFactory;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MainActivityModule {

    @ActivityScope
    @Provides
    WeatherApi getWeatherApi() {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addCallAdapterFactory(LiveDataCallAdapterFactory.create())
                .addConverterFactory(LiveDataResponseBodyConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherApi.class);
    }

    @Provides
    @ActivityScope
    WeatherViewModel provideMainScreenViewModel(WeatherApi api){
        return new WeatherViewModel(api);
    }

    @Provides
    @ActivityScope
    ViewModelProvider.Factory providesMainViewModelProvider(WeatherViewModel mainViewModel) {
        return new WeatherViewModelProvideFactory<>(mainViewModel);
    }
}

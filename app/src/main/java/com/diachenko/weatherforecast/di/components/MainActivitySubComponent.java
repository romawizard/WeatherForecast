package com.diachenko.weatherforecast.di.components;

import com.diachenko.weatherforecast.di.ActivityScope;
import com.diachenko.weatherforecast.di.modules.MainActivityModule;
import com.diachenko.weatherforecast.ui.WeatherActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@ActivityScope
@Subcomponent(modules = MainActivityModule.class)
public interface MainActivitySubComponent extends AndroidInjector<WeatherActivity> {

    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<WeatherActivity>{}
}

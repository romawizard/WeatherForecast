package com.diachenko.weatherforecast.di.modules;

import com.diachenko.weatherforecast.di.components.MainActivitySubComponent;
import com.diachenko.weatherforecast.ui.WeatherActivity;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = MainActivitySubComponent.class)
public abstract class ActivityBuilderModule {

    @Binds
    @IntoMap
    @ClassKey(WeatherActivity.class)
    abstract AndroidInjector.Factory<?>
    bindMainActivityInjectorFactory(MainActivitySubComponent.Builder builder);

}

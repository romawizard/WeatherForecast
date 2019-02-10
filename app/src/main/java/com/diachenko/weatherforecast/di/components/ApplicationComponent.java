package com.diachenko.weatherforecast.di.components;

import com.diachenko.weatherforecast.WeatherApplication;
import com.diachenko.weatherforecast.di.modules.ActivityBuilderModule;
import com.diachenko.weatherforecast.di.modules.ApplicationModule;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Component(modules = {
        AndroidInjectionModule.class,
        ActivityBuilderModule.class,
        ApplicationModule.class})
public interface ApplicationComponent {

    void inject(WeatherApplication application);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(WeatherApplication application);

        ApplicationComponent build();
    }
}

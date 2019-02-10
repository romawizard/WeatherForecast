package com.diachenko.weatherforecast.ui;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.diachenko.weatherforecast.R;
import com.diachenko.weatherforecast.databinding.ActivityWeatherBinding;
import com.diachenko.weatherforecast.ui.viewmodels.WeatherViewModel;
import com.google.android.gms.maps.model.LatLng;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class WeatherActivity extends AppCompatActivity {

    public static final String TAG = WeatherActivity.class.getCanonicalName();
    public static final String LAT_LNG = "latLng";

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Inject
    ViewModelProvider.Factory viewModelProvider;


    public static void newInstance(Context context, LatLng location) {
        Intent intent = new Intent(context,WeatherActivity.class);
        intent.putExtra(LAT_LNG, location);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        ActivityWeatherBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_weather);

        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        LatLng latLng = getIntent().getExtras().getParcelable(LAT_LNG);

        WeatherViewModel model = ViewModelProviders.of(this, viewModelProvider)
                .get(WeatherViewModel.class);
        model.getCurrentWeather(latLng).observe(this, resource -> {
                    if (resource!= null && resource.isSuccess()) {
                        binding.setResponse(resource.getResource());
                    }
                }
        );
    }

}

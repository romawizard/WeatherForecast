package com.diachenko.weatherforecast.ui.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.diachenko.weatherforecast.R;
import com.diachenko.weatherforecast.data.api.CurrentWeatherResponse;
import com.diachenko.weatherforecast.ui.viewmodels.WeatherViewModel;
import com.diachenko.weatherforecast.utils.Constants;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CurrentWeatherFragment extends Fragment {

    public static final String TAG = CurrentWeatherFragment.class.getCanonicalName();

    public static final String CITY = "kharkiv";
    @BindView(R.id.date)
    TextView temperature;
    @BindView(R.id.imageView)
    ImageView imageView;
    Unbinder unbinder;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        WeatherViewModel model = ViewModelProviders.of(getActivity()).get(WeatherViewModel.class);
//        model.getCurrentWeather(CITY).observe(this, (resource) -> {
//            if (resource.isSuccess()) {
//                showWeather(Objects.requireNonNull(resource.getResource()));
//            } else {
//                showError(resource.getError());
//            }
//        });
    }

    private void showError(Throwable error) {

    }

    private void showWeather(CurrentWeatherResponse response) {
        String temp = String.valueOf(response.getMain().getTemp());
        String iconUrl = Constants.WEATHER_ICON_PATH + response.getWeather()
                .get(0).getIcon() + ".png";
        Log.d(TAG, "icon Url " + iconUrl);
        temperature.setText(temp);
        Picasso.get()
                .load(iconUrl)
                .into(imageView);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

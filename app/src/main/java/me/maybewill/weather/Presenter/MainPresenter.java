package me.maybewill.weather.Presenter;

import android.widget.ListView;

import java.util.List;

import me.maybewill.weather.Adapter.DailyWeatherAdapter;
import me.maybewill.weather.Bean.DailyWeatherInfo;
import me.maybewill.weather.Constant.ConstantHttp;
import me.maybewill.weather.Http.HttpMethods;
import me.maybewill.weather.Interface.MainInterface;
import rx.Subscriber;

/**
 * Created by yao on 2017/1/23.
 */

public class MainPresenter {

    private final MainInterface view;

    public MainPresenter(MainInterface view) {
        this.view = view;
    }

    public void getWeatherInfo (String location, final ListView listView) {
        HttpMethods.get().getDailyWeaherInfo(new Subscriber<DailyWeatherInfo>() {
            @Override
            public void onCompleted() {
                view.getWeatherInfoSuccess();
            }

            @Override
            public void onError(Throwable e) {
                view.getWeatherInfoFailed();
            }

            @Override
            public void onNext(DailyWeatherInfo dailyWeatherInfo) {
                List<DailyWeatherInfo.ResultsBean.DailyBean> daily =
                        dailyWeatherInfo.getResults().get(0).getDaily();
                DailyWeatherAdapter dailyWeatherAdapter = new DailyWeatherAdapter(daily);
                listView.setAdapter(dailyWeatherAdapter);
            }
        }, ConstantHttp.WEATHER_API_KEY, location);
    }
}

package me.maybewill.weather.Http;

import java.util.concurrent.TimeUnit;

import me.maybewill.weather.Bean.CurrentWeatherInfo;
import me.maybewill.weather.Bean.DailyWeatherInfo;
import me.maybewill.weather.Constant.ConstantHttp;
import me.maybewill.weather.Interface.HttpInterface;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by yao on 2017/1/21.
 */

public class HttpMethods {

    private static final int DEFAULT_TIMEOUT = 5;
    private HttpInterface httpInterface;

    private HttpMethods() {

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(ConstantHttp.API_BASE_URL)
                .build();
        httpInterface = retrofit.create(HttpInterface.class);
    }


    private static HttpMethods httpMethods;
    public static HttpMethods get () {
        if (httpMethods == null) {
            httpMethods = new HttpMethods();
        }
        return httpMethods;
    }

    public void getCurrentWeatherInfo (Subscriber<CurrentWeatherInfo> subscriber, String key, String location) {
        httpInterface.getCurrentWeatherInfo(key, location)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getDailyWeaherInfo (Subscriber<DailyWeatherInfo> subscriber, String key, String location) {
        httpInterface.getDailyWeahterInfo(key, location)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

 }

package me.maybewill.weather.Interface;

import me.maybewill.weather.Bean.CurrentWeatherInfo;
import me.maybewill.weather.Bean.DailyWeatherInfo;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by yao on 2017/1/21.
 */

public interface HttpInterface {

    @GET("now.json")
    Observable<CurrentWeatherInfo> getCurrentWeatherInfo (
            @Query("key")String key,
            @Query("location")String location
    );

    @GET("daily.json")
    Observable<DailyWeatherInfo> getDailyWeahterInfo (
            @Query("key") String key,
            @Query("location") String location
    );
}

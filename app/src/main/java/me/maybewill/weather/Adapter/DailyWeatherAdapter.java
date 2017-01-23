package me.maybewill.weather.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import me.maybewill.weather.Bean.DailyWeatherInfo;
import me.maybewill.weather.R;
import me.maybewill.weather.Utils.Utils;
import me.maybewill.weather.Utils.UtilsViewHolder;

/**
 * Created by yao on 2017/1/23.
 */

public class DailyWeatherAdapter extends BaseAdapter {

    private final List<DailyWeatherInfo.ResultsBean.DailyBean> daily;

    public DailyWeatherAdapter(List<DailyWeatherInfo.ResultsBean.DailyBean> daily) {
        this.daily = daily;
    }


    @Override
    public int getCount() {
        return daily.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DailyWeatherInfo.ResultsBean.DailyBean dailyBean = daily.get(position);
        UtilsViewHolder holder = UtilsViewHolder
                .createCommonViewHolder(convertView, parent, R.layout.daily_weather_item);
        holder.getTextView(R.id.textview_date)
                .setText("日期：" + Utils.parseDate(dailyBean.getDate()));
        holder.getTextView(R.id.textview_day_weather)
                .setText("日间天气：" + dailyBean.getText_day());
        holder.getTextView(R.id.textview_day_temp)
                .setText("日间温度：" + dailyBean.getCode_day() + "摄氏度");
        holder.getTextView(R.id.textview_night_weather)
                .setText("夜间天气：" + dailyBean.getText_night());
        holder.getTextView(R.id.textview_night_temp)
                .setText("夜间气温：" + dailyBean.getCode_night() + "摄氏度");
        holder.getTextView(R.id.textview_hight)
                .setText("当天最高温度：" + dailyBean.getHigh() + "摄氏度");
        holder.getTextView(R.id.textview_low)
                .setText("当前最低温度：" + dailyBean.getLow() + "摄氏度");
        holder.getTextView(R.id.wind_direction)
                .setText("风向：" + dailyBean.getWind_direction());
        holder.getTextView(R.id.wind_scale)
                .setText("风力等级：" + dailyBean.getWind_scale() + "级");
        return holder.convertView;
    }
}

package me.maybewill.weather.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yao on 2017/1/23.
 */

public class Utils {

    private static String result;

    public static String parseDate(String text){
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(text);
            result = new SimpleDateFormat("yyyy年MM月dd日").format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
}

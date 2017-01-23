package me.maybewill.weather.Utils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class UtilsViewHolder {

    public View convertView;
    private Map<Integer, View> cacheView = new HashMap<>();

    private UtilsViewHolder(View convertView) {
        this.convertView = convertView;
    }

public static UtilsViewHolder createCommonViewHolder (View convertView, ViewGroup parent, int resId){
    UtilsViewHolder holder = null;
    if (convertView == null) {
        convertView = View.inflate(parent.getContext(), resId, null);
        holder = new UtilsViewHolder(convertView);
        convertView.setTag(holder);
    }
    return (UtilsViewHolder) convertView.getTag();
}

    public void putView(int id, View view) {
        cacheView.put(id, view);
    }

    public View getView(int id) {
        if (cacheView.get(id) == null) {
            putView(id, convertView.findViewById(id));
        }

        return cacheView.get(id);
    }

    public TextView getTextView(int id) {
        if (cacheView.get(id) == null) {
            putView(id, convertView.findViewById(id));
        }
        return (TextView) cacheView.get(id);
    }

    public ImageView getImageView(int id) {
        if (cacheView.get(id) == null) {
            putView(id, convertView.findViewById(id));
        }
        return (ImageView) cacheView.get(id);
    }
}
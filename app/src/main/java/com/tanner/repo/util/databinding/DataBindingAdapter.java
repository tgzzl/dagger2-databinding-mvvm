package com.tanner.repo.util.databinding;

import android.databinding.BindingAdapter;
import android.text.TextUtils;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tanner.repo.util.DailyUtils;

public class DataBindingAdapter {

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView iv, String imageUrl) {
        if (!TextUtils.isEmpty(imageUrl))
            Glide.with(iv.getContext()).load(imageUrl).into(iv);
    }

    @BindingAdapter({"body"})
    public static void loadBody(WebView webView, String body) {
        if (!TextUtils.isEmpty(body))
            webView.loadData(body, "text/html; charset=UTF-8", null);
    }

    @BindingAdapter({"datetime"})
    public static void loadDatetime(TextView textView, String datetime) {
        textView.setText(DailyUtils.getDisplayDate(textView.getContext(), Integer.parseInt(datetime)));
    }

}

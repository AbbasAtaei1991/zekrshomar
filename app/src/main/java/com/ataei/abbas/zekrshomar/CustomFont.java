package com.ataei.abbas.zekrshomar;

import android.app.Application;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class CustomFont extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder().setDefaultFontPath("fonts/sans.ttf")
        .setFontAttrId(R.attr.fontPath).build());
    }
}

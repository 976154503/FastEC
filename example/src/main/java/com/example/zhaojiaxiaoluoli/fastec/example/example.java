package com.example.zhaojiaxiaoluoli.fastec.example;

import android.app.Application;

import com.example.latte.app.Latte;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

public class example extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://127.0.0.1/")
//                引入字体
                .withIcon(new FontAwesomeModule())
                .configure();
    }
}

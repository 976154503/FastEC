package com.example.zhaojiaxiaoluoli.fastec.example;

import android.app.Application;

import com.example.core.app.Latte;


public class example extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://127.0.0.1/")

                .configure();
    }
}

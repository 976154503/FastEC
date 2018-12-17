package com.example.zhaojiaxiaoluoli.fastec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.latte.delegates.LatteDelegate;

public class ExampleDelegate extends LatteDelegate {

    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBand(@Nullable Bundle savedInstanceState, View rootView) {

    }
}

package com.example.zhaojiaxiaoluoli.fastec.example;

import com.example.latte.activites.ProxyActivity;
import com.example.latte.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {
    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}

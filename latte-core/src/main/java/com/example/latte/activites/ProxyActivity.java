package com.example.latte.activites;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.ContentFrameLayout;

import com.example.latte.R;
import com.example.latte.delegates.LatteDelegate;

import me.yokeyword.fragmentation.SupportActivity;

/*
 * 主体架构为单Activity多Fragment
 * ProxyActivity为容器Activity
 * */

public abstract class ProxyActivity extends SupportActivity {
    //    让子类强制设置根delegate 也就是主界面delegate
    public abstract LatteDelegate setRootDelegate();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initContainer(savedInstanceState);
    }

    //    初始化容器
    private void initContainer(@Nullable Bundle savedInstanceState) {
        @SuppressLint("RestrictedApi") final ContentFrameLayout container = new ContentFrameLayout(this);
        container.setId(R.id.delegate_container);
        setContentView(container);
//        第一次加载的时候
        if (savedInstanceState == null) {
            loadRootFragment(R.id.delegate_container, setRootDelegate());
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.gc();
        System.runFinalization();
    }
}

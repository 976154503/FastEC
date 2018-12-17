package com.example.latte.delegates;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/*
 * BaseDelegate 相当于 BaseFragment
 * */
public abstract class BaseDelegate extends SwipeBackFragment {

    private Unbinder mUnbinder = null;

    //强制让子类加载布局
    public abstract Object setLayout();

    //    强制让子类绑带布局
    public abstract void onBand(@Nullable Bundle savedInstanceState, View rootView);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        初始化布局
        View rootView = null;
//        如果传入的是布局id
        if (setLayout() instanceof Integer) {
            rootView = inflater.inflate((Integer) setLayout(), container, false);
//            如果传入的是View
        } else if (setLayout() instanceof View) {
            rootView = (View) setLayout();
        }
//        开始绑定布局
        if (rootView != null) {
            mUnbinder = ButterKnife.bind(this, rootView);
            onBand(savedInstanceState, rootView);
        }
        return rootView;
    }

    //页面销毁时解除绑定
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
    }
}

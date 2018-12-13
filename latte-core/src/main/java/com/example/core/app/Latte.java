package com.example.core.app;

import android.content.Context;

import java.util.WeakHashMap;

/*
 * 全局初始化工具类
 * */
public final class Latte {
    //当调用init时将对象的引用转入到配置中 当调用init时转入到getConfigurations中进行配置
    public static Configurator init(Context context) {
        getConfigurations().put(ConfigType.APPLICATION_CONTEXT.name(),context.getApplicationContext());
        return Configurator.getInstance();
    }

    //获取Configurator实例
    private static WeakHashMap<String, Object> getConfigurations() {
        return Configurator.getInstance().getLatteConfigs();
    }
}

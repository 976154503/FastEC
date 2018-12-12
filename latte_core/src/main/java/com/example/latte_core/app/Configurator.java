package com.example.latte_core.app;

import java.util.WeakHashMap;

/*
 * 配置文件的存储以及获取类
 * */
public class Configurator {
    //    储存各类配置项的map 比HashMap的优势是在不使用时能更快的回收
    private static final WeakHashMap<String, Object> LATTE_CONFIGS = new WeakHashMap<>();

    private Configurator() {
        //    项目刚开始时传入初始状态  配置已开始但是没有配置完成
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    //静态内部类单例初始化提升线程安全
    private static class Holder {
        //      INSTANCE 实例
        private static final Configurator INSTANCE = new Configurator();
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    final WeakHashMap<String, Object> getLatteConfigs() {
        return LATTE_CONFIGS;
    }

    //调用configure方法告诉配置文件已经初始化完成
    public final void configure() {
        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    //    配置ApiHost
    public final Configurator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }

    //    对是否完成配置做检查
    private void checkConfiguration() {
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (!isReady) {
            throw new RuntimeException("Configuration is not ready,call configure");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key) {
        checkConfiguration();
        return (T) LATTE_CONFIGS.get(key.name());
    }
}

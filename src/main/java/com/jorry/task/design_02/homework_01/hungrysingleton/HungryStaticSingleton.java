package com.jorry.task.design_02.homework_01.hungrysingleton;

// 饿汉式静态单例
public class HungryStaticSingleton {

    private static final HungryStaticSingleton hungryStaticSingleton;

    static {
        hungryStaticSingleton = new HungryStaticSingleton();
    }

    public static HungryStaticSingleton getInstance() {
        return hungryStaticSingleton;
    }

}

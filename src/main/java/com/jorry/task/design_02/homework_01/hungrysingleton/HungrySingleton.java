package com.jorry.task.design_02.homework_01.hungrysingleton;

// 饿汉式单例
// 缺点：类加载就初始化，浪费内存空间
public class HungrySingleton {

    private static final HungrySingleton hungrySingleton = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return hungrySingleton;
    }

}

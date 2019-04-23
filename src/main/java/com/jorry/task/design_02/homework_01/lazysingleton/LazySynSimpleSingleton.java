package com.jorry.task.design_02.homework_01.lazysingleton;

// 懒汉式单列（双重单例）
public class LazySynSimpleSingleton {

    // volatile
    private volatile static LazySynSimpleSingleton lazy = null;

    // 适中方案
    public static LazySynSimpleSingleton getInstance() {
        // 如果去掉该层判断，方法无法进入
        if (lazy == null) {
            // 如果不双重判断，在多线程同时进入，可能会有安全隐患
            // 如果加双重，等此方法释放后，lazy就不为null
            synchronized (LazySynSimpleSingleton.class) {
                if (lazy == null) {
                    lazy = new LazySynSimpleSingleton();
                    // CPU指定到会转成JVM指令执行
                    //指令重排序的问题，volatile（对线程可见）
                    //1. 分配内存给这个对象
                    //2. 初始化对象
                    //3. 将初始化好的对象和内存地址简历关联，赋值
                    //4. 用户初次访问
                }
            }
        }
        return lazy;
    }

}

package com.jorry.task.design_02.homework_01.threadlocal;

// 伪线程安全
// 使用 ThreadLocal 来实现多数据源动态切换
public class ThreadLocalSingleton {

    private ThreadLocalSingleton(){}

    private static final ThreadLocal<ThreadLocalSingleton> threadLocal =
            new ThreadLocal <ThreadLocalSingleton>() {
                protected ThreadLocalSingleton initialValue() {
                    return new ThreadLocalSingleton();
                }
            };

    public static ThreadLocalSingleton getInstance() {
        return threadLocal.get();
    }

}

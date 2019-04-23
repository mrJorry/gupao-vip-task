package com.jorry.task.design_02.homework_01.lazysingleton;

// 懒汉式单例（不安全）
public class LazySimpleSingleton {

    private static LazySimpleSingleton lazy = null;

    // 写法1 -- 不安全
    public static LazySimpleSingleton getInstance1() {
        if (lazy == null) {
            lazy = new LazySimpleSingleton();
        }
        return lazy;
    }

    // 写法二 -- 不安全
    // JDK1.6之后对synchronized性能优化了不少
    // 不可避免的还是存在一定性能问题
    public synchronized static LazySimpleSingleton getInstance2() {
        if (lazy == null) {
            lazy = new LazySimpleSingleton();
        }
        return lazy;
    }

}

package com.jorry.task.design_02.homework_01.lazysingleton;

// 懒汉式最优写法(静态内部类单例)
// 全程没有用到Synchronized
public class LazyInnerClassSingleton {

    // 虽然构造方法被自由化了，但是程序可以通过强吻方式反射访问到
    private LazyInnerClassSingleton() {
        // 为了解决反射破坏单例
        if (LazyHolder.lazy != null) {
            throw new RuntimeException("不允许实例多个对象");
        }
    }

    // final 保证方法不能重写
    // 巧妙利用了内部类的特性
    // JVM底层执行逻辑，完美的避免了线程安全问题
    public static final LazyInnerClassSingleton getInstance() {
        return LazyHolder.lazy;
    }

    // 静态内部类的优点是：
    // 外部类加载时并不需要立即加载内部类，内部类不被加载则不去初始化 instance，故而不占内存。
    // 即当 LazyInnerClassSingleton 第一次被加载时，并不需要去加载 LazyHolder，只有当getInstance()方法第一次被调用时，
    // 才会去初始化instance,第一次调用getInstance()方法会导致虚拟机加载 LazyHolder 类，
    // 这种方法不仅能确保线程安全，也能保证单例的唯一性，同时也延迟了单例的实例化。
    public static class LazyHolder {
        private static final LazyInnerClassSingleton lazy = new LazyInnerClassSingleton();
    }

}

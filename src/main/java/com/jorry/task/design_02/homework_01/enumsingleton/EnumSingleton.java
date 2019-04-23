package com.jorry.task.design_02.homework_01.enumsingleton;

/**
 * 注册式，类名+枚举值被JVM保存
 * 所以才是真·单例无双
 *
 * 不能用反射创建枚举
 */
// 它更简洁，自动支持序列化机制，绝对防止多次实例化
// 防止反序列化重新创建新的对象
public enum EnumSingleton {
    INSTANCE;
}

package com.jorry.task.design_02.homework_02.destroy;

import com.jorry.task.design_02.homework_01.lazysingleton.LazyInnerClassSingleton;

import java.lang.reflect.Constructor;

// 通过反射破坏单例
public class Reflex {

    public static void main(String[] args) {
        try {
            Class <?> clazz = LazyInnerClassSingleton.class;
            Constructor c = clazz.getDeclaredConstructor(null);
            c.setAccessible(true); // 强吻
            Object o1 = c.newInstance();

            Object o2 = LazyInnerClassSingleton.getInstance();

            System.out.println(o1 == o2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

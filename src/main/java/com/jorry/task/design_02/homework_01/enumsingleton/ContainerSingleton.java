package com.jorry.task.design_02.homework_01.enumsingleton;

import java.util.HashMap;
import java.util.Map;

// 类似spring，容器式单例
public class ContainerSingleton {
    private static final Map <String, Object> map = new HashMap <String, Object>();

    private ContainerSingleton() {

    }

    //或者是传入className,反射做。
    public static Object getBeam(String beanName) {
        Object bean = map.get(beanName);
        if (null != bean) {
            return bean;
        }
        synchronized (ContainerSingleton.class) {
            bean = map.get(beanName);
            if (null == bean) {
                map.put(beanName, new Object());
            }
        }
        return bean;
    }

}

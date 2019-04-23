package com.jorry.task.design_03.proxy.dbroute.db;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class OrderServiceDynamicProxy implements InvocationHandler {

    private Object tagger;

    public Object getInstence(Object proxyObj) {
        tagger = proxyObj;
        Class <?> clazz = proxyObj.getClass();
        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before(args[0]);
        Object invoke = method.invoke(tagger, args);
        after();
        return invoke;
    }

    private void after() {
        System.out.println("after....");
        DynamicDataSourceEntity.restore();
    }

    private void before(Object arg) {
        try {
            System.out.println("before....");
            Integer year = (Integer) tagger.getClass().getMethod("getYear").invoke(tagger);

            System.out.println("配置到【DB_" + year + "】数据源");
            DynamicDataSourceEntity.set(year);
        } catch (Exception e) {
            System.out.println("error....");
        }
    }
}

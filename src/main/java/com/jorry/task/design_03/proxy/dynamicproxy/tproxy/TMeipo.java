package com.jorry.task.design_03.proxy.dynamicproxy.tproxy;


import java.lang.reflect.Method;

/**
 * Created by Tom on 2019/3/10.
 */
public class TMeipo implements TInvocationHandler {

    private Object target;

    // 返回 TInvocationHandler
    public Object getInstance(Object person) throws Exception {
        this.target = person;
        Class <?> clazz = target.getClass();
        // clazz.getInterfaces()：这个类实现了哪些接口
        return TProxy.newProxyInstance(new TClassLoader() , clazz.getInterfaces(), this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object obj = method.invoke(this.target, args);
        after();
        return obj;
    }

    private void before() {
        System.out.println("我是媒婆，我要给你找对象，现在已经确认你的需求");
        System.out.println("开始物色");
    }

    private void after() {
        System.out.println("OK的话，准备办事");
    }
}

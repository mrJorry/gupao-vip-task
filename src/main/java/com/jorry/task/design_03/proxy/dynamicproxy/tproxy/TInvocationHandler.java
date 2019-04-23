package com.jorry.task.design_03.proxy.dynamicproxy.tproxy;

import java.lang.reflect.Method;

public interface TInvocationHandler {

    Object invoke(Object proxy, Method method, Object[] args) throws Throwable;

}

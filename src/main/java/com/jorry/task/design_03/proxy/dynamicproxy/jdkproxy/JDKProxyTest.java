package com.jorry.task.design_03.proxy.dynamicproxy.jdkproxy;

import java.lang.reflect.Method;

/**
 * Created by Tom on 2019/3/10.
 */
public class JDKProxyTest {

    public static void main(String[] args) {
        try {
            // 首先通过媒婆代理girl，得到返回girl对象
            Object obj = new JDKMeipo().getInstance(new Girl());
            // 通过当前类去找 findLove 方法
            Method method = obj.getClass().getMethod("findLove", null);
            // 实现方法加强，先调取代理类的 invoke 方法
            method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}

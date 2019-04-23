package com.jorry.task.design_03.proxy.dynamicproxy.tproxy;

import com.jorry.task.design_03.proxy.dynamicproxy.jdkproxy.Girl;

import java.lang.reflect.Method;

/**
 * Created by Tom on 2019/3/10.
 */
public class Main {

    public static void main(String[] args) {
        try {
            // 首先通过媒婆代理girl，得到返回girl对象
            Object obj = new TMeipo().getInstance(new Girl());
            // obj 实际是 --> $Proxy0 文件

            // 通过当前类去找 findLove 方法
            // 在调用 $Proxy0 的 findLove 方法
            Method method = obj.getClass().getMethod("findLove", null);
            // 实现方法加强，先调取代理类的 invoke 方法
            method.invoke(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}

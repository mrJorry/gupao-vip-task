package com.jorry.task.design_03.proxy.dbroute;

public class OrderDao {

    public int add(Order order) {
        System.out.println("添加成功");
        return 1;
    }

}

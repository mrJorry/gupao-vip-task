package com.jorry.task.design_03.proxy.dbroute;

public interface IOrderService {

    int add(Order order);

    int update(Order order);

    int create(Order order);

    Integer getYear();

}

package com.jorry.task.design_03.proxy.dbroute;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceImpl implements IOrderService {

    private OrderDao orderDao;

    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public OrderServiceImpl() {
        this.orderDao = new OrderDao();
    }

    @Override
    public int add(Order order) {
        return orderDao.add(order);
    }

    @Override
    public int update(Order order) {
        return 0;
    }

    @Override
    public int create(Order order) {
        System.out.println("create...");
        return 0;
    }

    @Override
    public Integer getYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return Integer.parseInt(sdf.format(new Date()));
    }
}

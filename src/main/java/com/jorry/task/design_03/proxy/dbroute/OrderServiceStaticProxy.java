package com.jorry.task.design_03.proxy.dbroute;

import com.jorry.task.design_03.proxy.dbroute.db.DynamicDataSourceEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class OrderServiceStaticProxy implements IOrderService {

    private static SimpleDateFormat format = new SimpleDateFormat("yyyy");

    private IOrderService iOrderService;

    public OrderServiceStaticProxy(IOrderService iOrderService) {
        this.iOrderService = iOrderService;
    }

    @Override
    public int add(Order order) {
        return 0;
    }

    @Override
    public int update(Order order) {
        return 0;
    }

    @Override
    public int create(Order order) {
        Long time = order.getCreateTime();
        Integer dbRouter = Integer.parseInt(format.format(time));
        System.out.println("静态代理类自动分配到[DB_" + dbRouter + "]");
        DynamicDataSourceEntity.set(dbRouter);
        int i = iOrderService.create(order);
        return i;
    }

    @Override
    public Integer getYear() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        return Integer.parseInt(sdf.format(new Date()));
    }
}

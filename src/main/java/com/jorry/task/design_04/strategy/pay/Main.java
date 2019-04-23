package com.jorry.task.design_04.strategy.pay;

import com.jorry.task.design_04.strategy.pay.payport.PayStrategy;
import com.jorry.task.design_04.strategy.pay.payport.Payment;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        String payKey = "jdPay";
        Order order = new Order(1L, "2019042100001", new BigDecimal("300"));
        System.out.println(order.pay(payKey));
    }

}

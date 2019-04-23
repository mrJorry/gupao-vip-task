package com.jorry.task.design_04.strategy.pay;

import com.jorry.task.design_04.strategy.pay.payport.PayStrategy;
import com.jorry.task.design_04.strategy.pay.payport.Payment;

import java.math.BigDecimal;

public class Order {

    private Long orderId;
    private String orderCode;
    private BigDecimal amount;

    public Order(Long orderId, String orderCode, BigDecimal amount) {
        this.orderId = orderId;
        this.orderCode = orderCode;
        this.amount = amount;
    }

    public MsgResult pay(String keyPay) {
        Payment pay = PayStrategy.pay(keyPay);
        System.out.println("欢迎使用支付" + pay.getName() + ",本次支付" + amount);
        return pay.pay(keyPay, amount);
    }
}

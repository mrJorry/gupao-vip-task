package com.jorry.task.design_04.strategy.pay.payport;

import java.math.BigDecimal;

public class JDPay extends Payment{
    @Override
    public String getName() {
        return "京东白条支付";
    }

    @Override
    protected BigDecimal queryBalance(String uid) {
        return new BigDecimal("200.13");
    }
}

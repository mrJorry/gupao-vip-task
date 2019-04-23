package com.jorry.task.design_04.strategy.pay.payport;

import java.math.BigDecimal;

public class AliPay extends Payment{
    @Override
    public String getName() {
        return "阿里支付";
    }

    @Override
    protected BigDecimal queryBalance(String uid) {
        return new BigDecimal("450.13");
    }
}

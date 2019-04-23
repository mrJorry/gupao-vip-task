package com.jorry.task.design_04.strategy.pay.payport;

import java.math.BigDecimal;

public class WxPay extends Payment{
    @Override
    public String getName() {
        return "微信支付";
    }

    @Override
    protected BigDecimal queryBalance(String uid) {
        return new BigDecimal("100.13");
    }
}

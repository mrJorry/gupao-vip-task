package com.jorry.task.design_04.strategy.pay.payport;

import com.jorry.task.design_04.strategy.pay.MsgResult;

import java.math.BigDecimal;

public abstract class Payment {

    public abstract String getName();

    protected abstract BigDecimal queryBalance(String uid);

    public MsgResult pay(String uid, BigDecimal amount) {
        if (queryBalance(uid).compareTo(amount) == -1) {
            return new MsgResult(500, "支付失败", "余额不足");
        }
        return new MsgResult(0, "支付成功", "扣减余额" + amount);
    }

}

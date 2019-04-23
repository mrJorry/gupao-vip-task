package com.jorry.task.design_04.strategy.pay.payport;

import java.util.HashMap;
import java.util.Map;

public class PayStrategy {

    private static final String ALI_PAY = "aliPay";
    private static final String JD_PAY = "jdPay";
    private static final String WX_PAY = "wxPay";
    private static final String DEFAULT_PAY = ALI_PAY;

    private static Map<String, Payment> map = new HashMap <>();

    static {
        map.put(ALI_PAY, new AliPay());
        map.put(JD_PAY, new JDPay());
        map.put(WX_PAY, new WxPay());
    }

    public static Payment pay(String key) {
        if (!map.containsKey(key)) {
            return map.get(DEFAULT_PAY);
        }
        return map.get(key);
    }

}

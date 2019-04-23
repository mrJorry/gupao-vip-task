package com.jorry.task.design_04.strategy.promotion;

import java.util.HashMap;
import java.util.Map;

public class PromotionStrategyFactory {

    private static Map<String, PromotionStrategy> map = new HashMap <>();

    static {
        map.put(KEYS.CASHBACK.key, new CashbackStrategy());
        map.put(KEYS.COUPON.key, new CouponStrategy());
        map.put(KEYS.EMPTY.key, new EmptyStrategy());
        map.put(KEYS.GROUPBUY.key, new GroupbuyStrategy());
    }

    private static final PromotionStrategy default_s = new CashbackStrategy();

    private PromotionStrategyFactory() {

    }

    public static PromotionStrategy getPromotionStrategy(String promotionKey) {
        PromotionStrategy promotionStrategy = map.get(promotionKey);
        return (promotionStrategy == null ? default_s : promotionStrategy);
    }

    public enum KEYS {
        CASHBACK("cashback"),
        COUPON("coupon"),
        EMPTY("empty"),
        GROUPBUY("groupbuy");

        private String key;

        KEYS(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

}

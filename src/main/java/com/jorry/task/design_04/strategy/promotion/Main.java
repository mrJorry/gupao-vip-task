package com.jorry.task.design_04.strategy.promotion;

public class Main {

    public static void main(String[] args) {
//        PromotionAvtivity p = new PromotionAvtivity(new CouponStrategy());
//        PromotionAvtivity c = new PromotionAvtivity(new CashbackStrategy());
//        p.excetion();
//        c.excetion();

        String key = "groupbuy";
        PromotionAvtivity p = new PromotionAvtivity(PromotionStrategyFactory.getPromotionStrategy(key));
        p.excetion();

    }

}

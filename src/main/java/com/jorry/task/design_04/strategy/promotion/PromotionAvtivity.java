package com.jorry.task.design_04.strategy.promotion;

public class PromotionAvtivity {

    private PromotionStrategy promotionStrategy;

    public PromotionAvtivity(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void excetion() {
        promotionStrategy.doPromotion();
    }

}

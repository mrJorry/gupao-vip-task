package com.jorry.task.design_04.strategy.promotion;

public class EmptyStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("EmptyStrategy...");
    }
}

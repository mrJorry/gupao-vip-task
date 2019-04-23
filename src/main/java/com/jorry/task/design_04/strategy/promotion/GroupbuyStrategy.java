package com.jorry.task.design_04.strategy.promotion;

public class GroupbuyStrategy implements PromotionStrategy{
    @Override
    public void doPromotion() {
        System.out.println("GroupbuyStrategy...");
    }
}

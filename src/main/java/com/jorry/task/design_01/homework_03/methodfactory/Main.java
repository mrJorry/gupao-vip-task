package com.jorry.task.design_01.homework_03.methodfactory;

public class Main {

    // 方法工厂
    public static void main(String[] args) {
        ICar card = MethodFactory.getCar(CardEnum.getCName(CardEnum.BMW.name()));
        card.car();
    }

}

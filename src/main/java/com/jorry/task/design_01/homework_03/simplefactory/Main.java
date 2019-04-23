package com.jorry.task.design_01.homework_03.simplefactory;

public class Main {

    // 简单工厂
    public static void main(String[] args) {
        ICra factory = new Benz();
        factory.car();
    }

}

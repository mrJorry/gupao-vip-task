package com.jorry.task.design_01.homework_03.abstractfactory;

public class Main {

    // 抽象工厂
    public static void main(String[] args) {
        AbstractFactory factory = new BenzFactory();
        factory.getCra().car();
        factory.getTyre().tyre();

        System.out.println("--------------------------");
        factory = new BmwFactory();
        factory.getCra().car();
        factory.getTyre().tyre();
    }

}

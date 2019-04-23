package com.jorry.task.design_01.homework_03.abstractfactory;

public class BenzFactory extends AbstractFactory {

    @Override
    public ICra getCra() {
        return new Benz();
    }

    @Override
    public ITyre getTyre() {
        return new BenzTyre();
    }

}

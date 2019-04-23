package com.jorry.task.design_01.homework_03.abstractfactory;

public class BmwFactory extends AbstractFactory {

    @Override
    public ICra getCra() {
        return new Bmw();
    }

    @Override
    public ITyre getTyre() {
        return new BmwTyre();
    }

}

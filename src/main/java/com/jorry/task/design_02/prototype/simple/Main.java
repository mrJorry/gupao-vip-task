package com.jorry.task.design_02.prototype.simple;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ConcretePrototypeA concretePrototype = new ConcretePrototypeA();
        concretePrototype.setAge(18);
        concretePrototype.setName("jorry");
        List list = new ArrayList();
        concretePrototype.setList(list);
        ConcretePrototypeA closeEntity = (ConcretePrototypeA) concretePrototype.close();

        System.out.println("未克隆的引用地址：" + concretePrototype.getList());
        System.out.println("克隆的引用地址：" + closeEntity.getList());
        System.out.println(concretePrototype.getList() == closeEntity.getList());

    }

}

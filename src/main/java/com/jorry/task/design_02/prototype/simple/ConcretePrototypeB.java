package com.jorry.task.design_02.prototype.simple;

import java.util.List;

public class ConcretePrototypeB implements Prototype {

    private int age;
    private String name;
    private List list;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public Prototype close() {
        ConcretePrototypeB concretePrototype = new ConcretePrototypeB();
        concretePrototype.setAge(this.age);
        concretePrototype.setName(this.name);
        concretePrototype.setList(this.list);
        return concretePrototype;
    }
}

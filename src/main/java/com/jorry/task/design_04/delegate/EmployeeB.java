package com.jorry.task.design_04.delegate;

public class EmployeeB implements IEmployee{
    @Override
    public void doIng() {
        System.out.println("我是B员工，擅长框架搭建");
    }
}

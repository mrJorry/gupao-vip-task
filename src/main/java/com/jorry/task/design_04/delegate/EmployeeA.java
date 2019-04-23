package com.jorry.task.design_04.delegate;

public class EmployeeA implements IEmployee {
    @Override
    public void doIng() {
        System.out.println("我是A员工，擅长业务");
    }
}

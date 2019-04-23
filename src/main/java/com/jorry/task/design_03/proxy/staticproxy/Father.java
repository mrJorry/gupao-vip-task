package com.jorry.task.design_03.proxy.staticproxy;

import com.jorry.task.design_03.proxy.Person;

public class Father {

    private Scon person;

    public Father(Scon person) {
        this.person = person;
    }

    public int findLove() {
        System.out.println("父亲物色对象");
        this.person.findLove();
        System.out.println("双方父母同意");
        return 0;
    }

}

package com.jorry.task.design_03.proxy.staticproxy;

public class Main {

    public static void main(String[] args) {
        Father father = new Father(new Scon());
        father.findLove();
    }

}

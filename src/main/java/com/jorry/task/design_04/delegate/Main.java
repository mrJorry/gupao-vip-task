package com.jorry.task.design_04.delegate;

public class Main {

    public static void main(String[] args) {
        new Boss().command("业务", new Leader());
    }

}

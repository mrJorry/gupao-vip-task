package com.jorry.task.design_01.homework_03.methodfactory;

public enum CardEnum {

    BENZ("BENZ", Benz.class.getName()),
    BMW("BMW", Bmw.class.getName());

    private String className;
    private String name;

    CardEnum(String name, String className) {
        this.className = className;
        this.name = name;
    }

    public static String getCName(String name) {
        for (CardEnum cards : CardEnum.values()) {
            if (name.equals(cards.name)) {
                return cards.className;
            }
        }
        return null;
    }
}

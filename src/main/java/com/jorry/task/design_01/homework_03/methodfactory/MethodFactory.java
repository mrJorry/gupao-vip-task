package com.jorry.task.design_01.homework_03.methodfactory;

public class MethodFactory {

    public static ICar getCar(String className) {
//        switch (name) {
////            case "benz":
////                return new Benz();
////            case "bmw":
////                return new Bmw();
////            default:
////                return null;
////        }

        try {
            return (ICar) Class.forName(className).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

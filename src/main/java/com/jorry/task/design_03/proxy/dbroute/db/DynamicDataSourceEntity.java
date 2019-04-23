package com.jorry.task.design_03.proxy.dbroute.db;

public class DynamicDataSourceEntity {

    public final static String defaule_source = null;

    private static ThreadLocal <String> local = new ThreadLocal <String>();

    public static String get() {
        return local.get();
    }

    public static void restore() {
        local.set(defaule_source);
    }

    public static void set(String source) {
        local.set(source);
    }

    public static void set(int year) {
        local.set("DB_" + year);
    }

}

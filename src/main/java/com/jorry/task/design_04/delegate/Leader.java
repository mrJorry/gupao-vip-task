package com.jorry.task.design_04.delegate;

import java.util.HashMap;
import java.util.Map;

public class Leader {

    // 预先知道每个员工的特长，特征，发配任务
    private Map <String, IEmployee> emps = new HashMap <>();

    public Leader() {
        emps.put("架构", new EmployeeB());
        emps.put("业务", new EmployeeA());
    }

    public void doIng(String jobName) {
        emps.get(jobName).doIng();
    }

}

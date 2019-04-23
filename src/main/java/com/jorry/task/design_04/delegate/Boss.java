package com.jorry.task.design_04.delegate;

public class Boss {

    public void command(String jobName, Leader leader) {
        leader.doIng(jobName);
    }

}

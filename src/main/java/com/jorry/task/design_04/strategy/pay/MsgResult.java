package com.jorry.task.design_04.strategy.pay;

public class MsgResult {

    private int code;
    private String msg;
    private Object message;

    @Override
    public String toString() {
        return "返回信息{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", message=" + message +
                '}';
    }

    public MsgResult(int code, String msg, Object message) {
        this.code = code;
        this.msg = msg;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}

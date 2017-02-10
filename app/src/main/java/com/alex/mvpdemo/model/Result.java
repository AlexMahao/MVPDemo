package com.alex.mvpdemo.model;

/**
 *  请求响应的结果
 * Created by alex_mahao on 2017/2/10.
 */
public class Result {

    private String code;

    private String msg;

    private String data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Result(String code, String msg, String data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result() {

    }
}

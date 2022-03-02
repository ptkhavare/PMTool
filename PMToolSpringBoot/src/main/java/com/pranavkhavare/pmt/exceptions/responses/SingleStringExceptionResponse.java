package com.pranavkhavare.pmt.exceptions.responses;

public class SingleStringExceptionResponse {
    private String msg;

    public SingleStringExceptionResponse(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
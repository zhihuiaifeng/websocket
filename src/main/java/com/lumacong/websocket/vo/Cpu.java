package com.lumacong.websocket.vo;

public class Cpu {
    private String time;
    private Integer num;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Cpu(String time, Integer num) {
        super();
        this.time = time;
        this.num = num;
    }
}

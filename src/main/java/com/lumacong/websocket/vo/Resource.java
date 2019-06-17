package com.lumacong.websocket.vo;

public class Resource {
    private String time;
    private Integer cpuNum;
    private Integer memoryNum;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getCpuNum() {
        return cpuNum;
    }

    public void setCpuNum(Integer cpuNum) {
        this.cpuNum = cpuNum;
    }


    public Integer getMemoryNum() {
        return memoryNum;
    }

    public void setMemoryNum(Integer memoryNum) {
        this.memoryNum = memoryNum;
    }

    public Resource(String time, Integer cpuNum, Integer memoryNum) {
        this.time = time;
        this.cpuNum = cpuNum;
        this.memoryNum = memoryNum;
    }
}

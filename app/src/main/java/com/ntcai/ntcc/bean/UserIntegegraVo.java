package com.ntcai.ntcc.bean;

public class UserIntegegraVo {
    private String name;
    private String time;
    private double integera;

    public UserIntegegraVo(String name, String time, double integera) {
        this.name = name;
        this.time = time;
        this.integera = integera;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getIntegera() {
        return integera;
    }

    public void setIntegera(double integera) {
        this.integera = integera;
    }
}

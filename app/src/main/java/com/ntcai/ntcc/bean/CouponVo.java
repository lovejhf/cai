package com.ntcai.ntcc.bean;

public class CouponVo {
    private double amount;
    private String name;
    private String time;
    private String  type;
    private int status;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public CouponVo(double amount, String name, String time, String type, int status) {
        this.amount = amount;
        this.name = name;
        this.time = time;
        this.type = type;
        this.status = status;
    }

    public CouponVo(double amount, String name, String time, String type) {
        this.amount = amount;
        this.name = name;
        this.time = time;
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

package com.ntcai.ntcc.bean;

import java.io.Serializable;

public class CategoryTwoArray implements Serializable {
    private String  name;
    private String sub;
    private double amount;

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
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


}

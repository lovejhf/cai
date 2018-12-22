package com.ntcai.ntcc.bean;

public class MineOrderVo {
    private int imageRecourse;
    private String name;
    private String sub;

    public MineOrderVo(int imageRecourse, String name, String sub) {
        this.imageRecourse = imageRecourse;
        this.name = name;
        this.sub = sub;
    }

    public int getImageRecourse() {
        return imageRecourse;
    }

    public void setImageRecourse(int imageRecourse) {
        this.imageRecourse = imageRecourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }
}

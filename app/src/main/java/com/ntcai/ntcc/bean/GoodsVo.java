package com.ntcai.ntcc.bean;

public class GoodsVo {
    private String goodsName;
    private String spec;
    private double price;
    private int num;
    private String goods_img;
    private double totalPrice;
    private boolean isSelecet = false;//默认未选中

    public GoodsVo(String goodsName, String spec, double price, int num, String goods_img, double totalPrice) {
        this.goodsName = goodsName;
        this.spec = spec;
        this.price = price;
        this.num = num;
        this.goods_img = goods_img;
        this.totalPrice = totalPrice;
    }

    public boolean isSelecet() {
        return isSelecet;
    }

    public void setSelecet(boolean selecet) {
        isSelecet = selecet;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getGoods_img() {
        return goods_img;
    }

    public void setGoods_img(String goods_img) {
        this.goods_img = goods_img;
    }
}

package com.ntcai.ntcc.bean;

import java.util.List;

public class OrderVo {
    private String order_no;
    private String status;
    private double totalPay;
    private List<GoodsVo> goods;

    public OrderVo(String order_no, String status, double totalPay, List<GoodsVo> goods) {
        this.order_no = order_no;
        this.status = status;
        this.totalPay = totalPay;
        this.goods = goods;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }

    public List<GoodsVo> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsVo> goods) {
        this.goods = goods;
    }
}

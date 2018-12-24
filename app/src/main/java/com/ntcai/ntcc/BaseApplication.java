package com.ntcai.ntcc;

import android.app.Application;

import com.hjq.toast.ToastUtils;
import com.hjq.toast.style.ToastQQStyle;
import com.mob.MobSDK;
import com.mob.paysdk.AliPayAPI;
import com.mob.paysdk.MobPayAPI;
import com.mob.paysdk.OnPayListener;
import com.mob.paysdk.Order;
import com.mob.paysdk.PayOrder;
import com.mob.paysdk.PayResult;
import com.mob.paysdk.PaySDK;
import com.mob.paysdk.WXPayAPI;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MobSDK.init(this, "29714f045a5a4", "dbefc759427ee08940a399e22e2d7360");
        ToastUtils.init(this);
        ToastUtils.initStyle(new ToastQQStyle());
//        AliPayAPI alipay = PaySDK.createMobPayAPI(AliPayAPI.class);
//        PayOrder order = new PayOrder();
//        order.setOrderNo("订单号");
//        order.setAmount(1);
//        order.setSubject("支付标题");
//        order.setBody("支付主体");
//        alipay.pay(order, new OnPayListener<Order>() {
//            @Override
//            public boolean onWillPay(String s, Order order, MobPayAPI mobPayAPI) {
//                return false;
//            }
//
//            @Override
//            public void onPayEnd(PayResult payResult, Order order, MobPayAPI mobPayAPI) {
//
//            }
//        });
//
//        WXPayAPI wxpay = PaySDK.createMobPayAPI(WXPayAPI.class);
//        PayOrder order1 = new PayOrder();
//        order1.setOrderNo("订单号");
//        order1.setAmount(1);
//        order1.setSubject("支付标题");
//        order1.setBody("支付主体");
//        wxpay.pay(order1, new OnPayListener<Order>() {
//            @Override
//            public boolean onWillPay(String s, Order order, MobPayAPI mobPayAPI) {
//                return false;
//            }
//
//            @Override
//            public void onPayEnd(PayResult payResult, Order order, MobPayAPI mobPayAPI) {
//
//            }
//        });
    }
}

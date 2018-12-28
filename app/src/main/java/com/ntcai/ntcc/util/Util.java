package com.ntcai.ntcc.util;

import android.util.Pair;

import com.ntcai.ntcc.R;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Util {

    public static String decimalFormatMoney(double numbers) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA);
        // 把转换后的货币String类型返回
        String numString = format.format(numbers);
        return numString;

    }

    public static List<Pair<String,Integer>> getPayType(){
        List<Pair<String,Integer>> pay = new ArrayList<>();
        pay.add(new Pair<>("支付宝支付", R.mipmap.ic_ali_pay));
        pay.add(new Pair<>("微信支付", R.mipmap.ic_wx_pay));
        return pay;
    }

}

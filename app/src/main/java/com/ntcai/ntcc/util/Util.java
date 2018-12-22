package com.ntcai.ntcc.util;

import java.text.NumberFormat;
import java.util.Locale;

public class Util {

    public static String decimalFormatMoney(double numbers) {
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA);
        // 把转换后的货币String类型返回
        String numString = format.format(numbers);
        return numString;

    }

}

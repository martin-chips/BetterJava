package com.dimple;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.EnumSet;
import java.util.Locale;

/**
 * Hello world!
 */
enum Season {
    SPRING, SUMMER, FAIL, WINTER
}

public class App {
    public static void main(String[] args) {
        System.out.println(formatCurrency("$0.00", 65326));
        System.out.println(formatCurrency(new BigDecimal("888888860.5326"),0,Locale.getDefault()));
        System.out.println(String.valueOf(new BigDecimal("456")));
    }

    public static String formatCurrency(String pattern, double value) {
        NumberFormat format = new DecimalFormat(pattern);
        return format.format(value);
    }

    public static String formatCurrency(BigDecimal money, int scale, Locale locale) {
        money = money.setScale(scale, BigDecimal.ROUND_HALF_UP);
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(locale.getCountry().equals("CA") ? Locale.US : locale);
        currencyFormat.setMaximumFractionDigits(scale);
        return currencyFormat.format(money);
    }
}

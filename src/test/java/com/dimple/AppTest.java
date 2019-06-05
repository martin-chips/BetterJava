package com.dimple;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    public static void main(String[] args) {
        Locale locale = new Locale(Locale.JAPAN.getLanguage());
        BigDecimal bigDecimal = new BigDecimal("4564456545646");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        System.out.println(numberFormat.format(bigDecimal));
    }
}

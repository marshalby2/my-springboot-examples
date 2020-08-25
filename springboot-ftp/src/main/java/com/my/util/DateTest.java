package com.my.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @Description TODO
 * @Author marshal
 * @Date 19/5/20 5:13 PM
 */
public class DateTest {
    public static void main(String[] args) {
        System.out.println(Calendar.getInstance().get(Calendar.YEAR));
        System.out.println(Calendar.getInstance().get(Calendar.MONTH));
        System.out.println(Calendar.getInstance().get(Calendar.DATE));
        System.out.println(Calendar.getInstance().getTime());
    }
}

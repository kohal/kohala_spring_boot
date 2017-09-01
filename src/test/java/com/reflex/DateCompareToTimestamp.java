package com.reflex;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @Des:
 * @Author: xuyongjian
 * @Date: 2017/6/30
 */
public class DateCompareToTimestamp {


    @Test
    public void test(){
        Date date1 = new Date();

        Timestamp ts = new Timestamp(date1.getTime());

        Timestamp ts1 = new Timestamp(System.currentTimeMillis());

        System.out.println(ts1);
        System.out.println(ts);  // 2016-08-08 22:37:37.078
        Assert.assertEquals(ts1,ts);
        Date date2 = new Date(ts.getTime());
        Assert.assertEquals(date1, date2);
        ts.setNanos(0);
        System.out.println(ts); // 2016-08-08 22:37:37.0
        Date date3 = new Date(ts.getTime());
        Assert.assertNotEquals(date1, date3);
    }
}

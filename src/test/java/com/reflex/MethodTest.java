package com.reflex;

/**
 * @Des:
 * @Author: xuyongjian
 * @Date: 2017/7/6
 */
public class MethodTest {

    public static void main(String[] args) {
        Integer a = new Integer(1);
        addNum(a);
        System.out.println("a="+a);

    }

    public static void addNum(Integer b) {
        b++;
        b = new Integer(2);
        Integer c = b + 3;
        System.out.println("b="+b);
        System.out.println("c="+c);

    }
}

